package com.codes.practice.shoppingcart;

import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCartDemo {
    public static void main(String[] args)
    {
        // creates new items with product name, quantity and unit price
        ShoppingItem i1 = new ShoppingItem("Olive Oil 1l", 3, 100.0);
        ShoppingItem i2 = new ShoppingItem("Cheese Slices", 2, 50.0);
        ShoppingItem i3 = new ShoppingItem("Bread", 1, 75.0);
        ShoppingItem i4 = new ShoppingItem("Eggs", 50, 10.0);
        ShoppingItem i5 = new ShoppingItem("Chicken Salami", 2, 100.0);

        ShoppingCart cart = new ShoppingCart();

        /* add the item to the cart */
        cart.addToCart(i1);
        cart.addToCart(i2);
        cart.addToCart(i3);
        cart.addToCart(i4);
        cart.addToCart(i5);

        /*
         * shows the list of items in the cart with quantity
         * Expected Output to the console:
         * Olive Oil 1l: 3
         * Cheese Slices: 2
         * Bread: 1
         * Eggs: 50
         * Chicken Salami: 2
         */
        cart.showCart();

        /* remove the item sent as argument from the cart */
        cart.removeFromCart(i3);

        /*
         * shows the list of items in the cart with quantity
         * Expected Output to the console:
         * Olive Oil 1l: 3
         * Cheese Slices: 2
         * Eggs: 50
         * Chicken Salami: 2
         */
        cart.showCart();

        /*
         * gets the total amount for the items in the cart
         * Expected Output:
         * 1100
         */
        double totalAmount = cart.getTotalAmount();
        System.out.println(totalAmount);

        /*
         * Gets the payable amount,
         * it deducts discount and add tax to the total amount of items in cart
         * Expected Output:
         * 1254
         */
        double payableAmount = cart.getPayableAmount();
        System.out.println(payableAmount);

        /* apply a coupon code */
        cart.applyCoupon("IND50");

        /*
         * print the items with the quanity, unit price, total amount
         * apply coupon if valid
         * add tax to the total amount after discount
         * Expected Output to the console:
         * Olive Oil 1l      3    100.00    300.00
         * Cheese Slices     2     50.00    100.00
         * Eggs             50     10.00    500.00
         * Chicken Salami    2    100.00    200.00
         *                          Total: 1100.00
         *                          Disc%:    0.00
         *                          Tax:    154.00
         *                          Total: 1254.00
         *
         */
        cart.printInvoice();

        cart.applyCoupon("IND10");

        /*
         * print the items with the quantity, unit price, total amount
         * apply coupon if valid
         * add tax to the total amount after discount
         * Expected Output to the console:
         * Olive Oil 1l      3    100.00    300.00
         * Cheese Slices     2     50.00    100.00
         * Eggs             50     10.00    500.00
         * Chicken Salami    2    100.00    200.00
         *                          Total: 1100.00
         *                          Disc%:  110.00
         *                          Tax:    154.00
         *                          Total: 1128.60
         *
         */
        cart.printInvoice();

        cart.addToCart(new ShoppingItem("Milk", 5, 30.00));
        /*
         * print the items with the quanity, unit price, total amount
         * apply coupon if valid
         * add tax to the total amount after discount
         * Expected Output to the console:
         * Olive Oil 1l      3    100.00    300.00
         * Cheese Slices     2     50.00    100.00
         * Eggs             50     10.00    500.00
         * Chicken Salami    2    100.00    200.00
         * Milk              5     30.00    150.00
         *                          Total: 1250.00
         *                          Disc%:  125.00
         *                          Tax:    157.50
         *                          Total: 1282.50
         *
         */
        cart.printInvoice();
    }

}


class ShoppingItem {
    private String productName;
    private int quantity;
    private double unitPrice;
    ShoppingItem(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public String toString() {
        String s = this.productName + ":" + this.quantity + "\n";
        return s;
    }
    public String getProductName() {
        return this.productName;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCart {
    ArrayList<ShoppingItem> itemList;
    double totalAmount;
    double payableAmount;
    double discount;
    double tax;
    String coupon;
    ShoppingCart() {
        this.itemList = new ArrayList<ShoppingItem>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
    }
    public void addToCart(ShoppingItem itemA) {
        // need to check if the item exists already in the cart
        // if exists, update the quantity
        // otherwise, add the new item
        boolean update = false;
        ListIterator<ShoppingItem> iterator = this.itemList.listIterator();
        while(iterator.hasNext()) {
            ShoppingItem item = iterator.next();
            if (item.getProductName().equals(itemA.getProductName())) {
                item.setQuantity(itemA.getQuantity()+item.getQuantity());
                update = true;
                break;
            }
        }
        if (!update) {
            this.itemList.add(itemA);
        }
    }
    public void showCart() {
        ListIterator<ShoppingItem> iterator = itemList.listIterator();
        while(iterator.hasNext()) {
            ShoppingItem item1 = iterator.next();
            System.out.println(item1);
        }
    }
    public void removeFromCart(ShoppingItem item) {
        ListIterator<ShoppingItem> iterator1 = itemList.listIterator();
        while(iterator1.hasNext()) {
            ShoppingItem item2 = iterator1.next();
            if (item2.getProductName().equals(item.getProductName())) {
                this.itemList.remove(item);
                break;
            }
        }
    }
    public double getTotalAmount() {
        ListIterator<ShoppingItem> iterator2 = itemList.listIterator();
        this.totalAmount = 0;
        while(iterator2.hasNext()) {
            ShoppingItem item3 = iterator2.next();
            this.totalAmount = this.totalAmount + (item3.getUnitPrice() * item3.getQuantity());
        }
        return this.totalAmount;
    }
    public void applyCoupon(String coupon) {
        this.coupon = coupon;
        if (coupon.equals("IND10")) {
            this.discount = this.getTotalAmount() * (0.1);
            this.totalAmount = this.totalAmount - this.discount;
        } else {
            this.totalAmount = this.totalAmount;
        }
    }
    public double getPayableAmount() {
        this.payableAmount = 0;
        this.tax = this.totalAmount * (0.14);
        this.payableAmount = this.totalAmount + this.tax;
        return this.payableAmount;
    }
    public void printInvoice() {
        ListIterator<ShoppingItem> iterator3 = itemList.listIterator();
        while(iterator3.hasNext()) {
            ShoppingItem item4 = iterator3.next();
            System.out.print(item4.getProductName() + "\t");
            System.out.print(item4.getQuantity() + "\t");
            System.out.print(item4.getUnitPrice() + "\t");
            System.out.println(item4.getUnitPrice() * item4.getQuantity());
        }
        System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
        this.applyCoupon(this.coupon);
        System.out.println("\t\t\t" + "Discount : " + this.discount);
        this.getPayableAmount();
        System.out.println("\t\t\t" + "Tax      : " + this.tax);
        System.out.println("\t\t\t" + "Total    : " + this.getPayableAmount());
    }
}