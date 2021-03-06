package com.codes.practice.DesignPatterns.Behavioral;
// This interface handles adding, deleting and updating
// all observers

import java.text.DecimalFormat;
import java.util.ArrayList;

interface SubjectStock {
    public void register(ObserverStock o);
    public void unregister(ObserverStock o);
    public void notifyObserver();
}
// The Observers update method is called when the Subject changes

interface ObserverStock {
    public void update(double ibmPrice, double aaplPrice, double googPrice);
}

// Uses the Subject interface to update all Observers
class StockGrabber implements SubjectStock {

    private ArrayList<ObserverStock> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {

        // Creates an ArrayList to hold all observers
        observers = new ArrayList<ObserverStock>();
    }

    public void register(ObserverStock newObserver) {

        // Adds a new observer to the ArrayList
        observers.add(newObserver);
    }

    public void unregister(ObserverStock deleteObserver) {

        // Get the index of the observer to delete
        int observerIndex = observers.indexOf(deleteObserver);

        // Print out message (Have to increment index to match)
        System.out.println("Observer " + (observerIndex + 1) + " deleted");

        // Removes observer from the ArrayList
        observers.remove(observerIndex);
    }

    public void notifyObserver() {

        // Cycle through all observers and notifies them of
        // price changes
        for (ObserverStock observer : observers) {
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    // Change prices for all stocks and notifies observers of changes
    public void setIBMPrice(double newIBMPrice) {
        this.ibmPrice = newIBMPrice;
        notifyObserver();
    }

    public void setAAPLPrice(double newAAPLPrice) {
        this.aaplPrice = newAAPLPrice;
        notifyObserver();
    }

    public void setGOOGPrice(double newGOOGPrice) {
        this.googPrice = newGOOGPrice;
        notifyObserver();
    }
}

// Represents each Observer that is monitoring changes in the subject
class StockObserver implements ObserverStock {

    // Static used as a counter
    private static int observerIDTracker = 0;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;
    // Used to track the observers
    private int observerID;

    // Will hold reference to the StockGrabber object
    private SubjectStock stockGrabber;

    public StockObserver(SubjectStock stockGrabber) {

        // Store the reference to the stockGrabber object so
        // I can make calls to its methods
        this.stockGrabber = stockGrabber;

        // Assign an observer ID and increment the static counter
        this.observerID = ++observerIDTracker;

        // Message notifies user of new observer
        System.out.println("New Observer " + this.observerID);

        // Add the observer to the Subjects ArrayList
        stockGrabber.register(this);
    }

    // Called to update all observers. implement Observer interface
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrices();
    }

    public void printThePrices() {
        System.out.println(observerID + "\nIBM: " + ibmPrice + "\nAAPL: " +
                aaplPrice + "\nGOOG: " + googPrice + "\n");
    }

}



class GetTheStock implements Runnable {

    // Could be used to set how many seconds to wait
    // in Thread.sleep() below

    // private int startTime;
    private String stock;
    private double price;

    // Will hold reference to the StockGrabber object
    private SubjectStock stockGrabber;

    public GetTheStock(SubjectStock stockGrabber, int newStartTime, String newStock, double newPrice) {

        // Store the reference to the stockGrabber object so
        // I can make calls to its methods
        this.stockGrabber = stockGrabber;

        // startTime = newStartTime;  Not used to have variable sleep time
        stock = newStock;
        price = newPrice;
    }

    public void run() {

        for (int i = 1; i <= 20; i++) {
            try {
                // Sleep for 2 seconds
                Thread.sleep(2000);

                // Use Thread.sleep(startTime * 1000); to
                // make sleep time variable
            } catch (InterruptedException e) {

            }

            // Generates a random number between -.03 and .03
            double randNum = (Math.random() * (.06)) - .03;

            // Formats decimals to 2 places
            DecimalFormat df = new DecimalFormat("#.##");

            // Change the price and then convert it back into a double
            price = Double.valueOf(df.format((price + randNum)));

            if (stock == "IBM") ((StockGrabber) stockGrabber).setIBMPrice(price);
            if (stock == "AAPL") ((StockGrabber) stockGrabber).setAAPLPrice(price);
            if (stock == "GOOG") ((StockGrabber) stockGrabber).setGOOGPrice(price);

            System.out.println(stock + ": " + df.format((price + randNum)) +
                    " " + df.format(randNum));

            System.out.println();
        }
    }
}

public class ObserverDesignPatternStock {

    public static void main(String[] args) {

        // Create the Subject object
        // It will handle updating all observers
        // as well as deleting and adding them
        StockGrabber stockGrabber = new StockGrabber();

        // Create a real time Observer that will be sent updates from Subject
        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAAPLPrice(677.60);
        stockGrabber.setGOOGPrice(676.40);

        // Create another real time Observer that will be sent updates from Subject
        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAAPLPrice(677.60);
        stockGrabber.setGOOGPrice(676.40);

        // Delete one of the observers

        // stockGrabber.unregister(observer2);

        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAAPLPrice(677.60);
        stockGrabber.setGOOGPrice(676.40);

        // Create 3 threads using the Runnable interface
        // GetTheStock implements Runnable, so it doesn't waste
        // its one extendable class option
        Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
        Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
        Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);

        // Call for the code in run to execute
        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();
    }
}
