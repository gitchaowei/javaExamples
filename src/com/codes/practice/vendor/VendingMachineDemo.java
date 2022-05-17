package com.codes.practice.vendor;

import java.util.*;

public class VendingMachineDemo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // TODO To complete in step3
        VendingMachineInterface machineInterface = null;

        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();
        int[] enteredCoins = {}; // TODO Complete in step 3
        machineInterface.enterCoins(enteredCoins);

        machineInterface.displayChangeMessage();
    }
}

interface VendingMachineInterface {
    void displayProducts();
    void selectProduct(int product);
    void displayEnterCoinsMessage();
    void enterCoins(int... coins);
    void displayChangeMessage();
}

interface Calculator {

    int calculateTotal(CoinBundle enteredCoins);
    CoinBundle calculateChange(int amountMoneyToReturn);

}

interface VendingMachineController {
    CoinBundle calculateChange(VendingMachineRequest request);
}

class TextVendingMachineInterface implements VendingMachineInterface {

    private VendingMachineController controller = new SimpleVendingMachineController();
    private int selectedProduct;
    private CoinBundle change;


    @Override
    public void displayProducts() {
        System.out.println(" *********************************************");
        System.out.println("     WELCOME TO THE VENDING MACHINE           ");
        System.out.println(" *********************************************");
        System.out.println("            Products available:               ");
        System.out.println("                                              ");
        for(Product product: Product.values()){
            if(!Product.EMPTY.equals(product)) {
                System.out.println("     " + product.getSelectionNumber() + "  " + product.name() + " - Price: " + product.getPrice() + "   ");
            }
        }
        System.out.println("                                              ");
        System.out.println(" Please select your product: ");


    }

    @Override
    public void selectProduct(int product) {
        this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
        System.out.println(" Please enter coins as follows: ");
        System.out.println(" num of 5 cents coins,num of 10 cents coins,num of 20 cents coins,num of 50 cents coins,num of 100 cents coins  ");
        System.out.println("                                              ");
        System.out.println(" Example: If you would like to enter 2 ten cents coins: 0,2,0,0,0");
        System.out.println("Plese enter coins:");

    }

    @Override
    public void enterCoins(int... coins) {
        VendingMachineRequest request = new VendingMachineRequest(selectedProduct, coins);
        change = controller.calculateChange(request);

    }

    @Override
    public void displayChangeMessage() {
        System.out.println("                                              ");
        System.out.println("Your change is :"+ change.getTotal()+"cents split as follows: ");
        System.out.println("    100 cents coins: "+ change.number100CentsCoins);
        System.out.println("    50 cents coins: "+ change.number50CentsCoins);
        System.out.println("    20 cents coins: "+ change.number20CentsCoins);
        System.out.println("    10 cents coins: "+ change.number10CentsCoins);
        System.out.println("    5 cents coins: "+ change.number5CentsCoins);

    }
}
class SimpleVendingMachineController implements VendingMachineController {

    private Calculator calculator = new SimpleCalculator();

    @Override
    public CoinBundle calculateChange(VendingMachineRequest request) {
        int total = calculator.calculateTotal(request.enteredCoins);
        int totalChange = total - request.product.getPrice();
        return calculator.calculateChange(totalChange);
    }
}
class VendingMachineRequest {
    public Product product;
    public CoinBundle enteredCoins;

    public VendingMachineRequest(int selectedProduct, int... enteredCoins){
        // TODO Complete in step 3
        this.product = null;
        this.enteredCoins = new CoinBundle(enteredCoins);
    }
}

enum Coin {
    FIVE_CENTS(5), TEN_CENTS(10),  TWENTY_CENTS(20), FIFTY_CENTS(50), HUNDRED_CENTS(100);

    private int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}

class CoinBundle {
    public int number5CentsCoins;
    public int number10CentsCoins;
    public int number20CentsCoins;
    public int number50CentsCoins;
    public int number100CentsCoins;

    public CoinBundle(int... enteredCoins) {
        this.number5CentsCoins = enteredCoins[0];
        this.number10CentsCoins = enteredCoins[1];
        this.number20CentsCoins = enteredCoins[2];
        this.number50CentsCoins = enteredCoins[3];
        this.number100CentsCoins = enteredCoins[4];

    }
    public int getTotal(){
        int total = 0;
        total = total+this.number5CentsCoins*Coin.FIVE_CENTS.getValue();
        total = total+this.number10CentsCoins*Coin.TEN_CENTS.getValue();
        total = total+this.number20CentsCoins*Coin.TWENTY_CENTS.getValue();
        total = total+this.number50CentsCoins*Coin.FIFTY_CENTS.getValue();
        total = total+this.number100CentsCoins*Coin.HUNDRED_CENTS.getValue();
        return total;
    }
}

enum Product {
    TWIX(1,100), COKE(2,50), WATER(3,30), SANDWICH(4,150), EMPTY(0,0);

    private int selectionNumber;
    private int price;

    Product(int selectionNumber, int price){
        this.selectionNumber = selectionNumber;
        this.price = price;
    }

    public int getSelectionNumber(){
        return selectionNumber;
    }

    public int getPrice(){
        return this.price;
    }

}

class SimpleCalculator implements Calculator{

    @Override
    public int calculateTotal(CoinBundle enteredCoins) {
        return enteredCoins.getTotal();
    }

    @Override
    public CoinBundle calculateChange(int amountMoneyToReturn) {
        CoinBundle change = new CoinBundle(new int[5]);
        int remainingAmount = amountMoneyToReturn;
        change.number100CentsCoins = remainingAmount / Coin.HUNDRED_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.HUNDRED_CENTS.getValue();

        change.number50CentsCoins = remainingAmount / Coin.FIFTY_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.FIFTY_CENTS.getValue();

        change.number20CentsCoins = remainingAmount / Coin.TWENTY_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.TWENTY_CENTS.getValue();

        change.number10CentsCoins = remainingAmount / Coin.TEN_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.TEN_CENTS.getValue();

        change.number5CentsCoins = remainingAmount / Coin.FIVE_CENTS.getValue();


        return change;
    }
}