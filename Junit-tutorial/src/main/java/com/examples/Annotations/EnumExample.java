package com.examples.Annotations;
enum Mobile {   // enum extands ENUM already. so more extands any other class but can implements interface
    APPLE (100),SAMSUNG,HTC(90);
    int price;
    public int getPrice() {
        return price;
    }
    Mobile() {
        price = 80;
        System.out.println("Mobile constructor");
    }
    Mobile(int price) {
        this.price = price;
    }
}
// similar with following:
//Class Mobile {
//    static final Mobile APPLE = new Mobile();
//    static final Mobile SAMSUNG = new Mobile();
//    static final Mobile HTC = new Mobile();
//    int price;
//    public int getPrice() {
//        return price;
//    }
//}

public class EnumExample {
    public static void main(String[] args) {
        Mobile [] m = Mobile.values();

        for ( Mobile phone: m ) {
            System.out.println(phone + " oridinal: "+ phone.ordinal());

        }
        System.out.println("Oridinal APPLE " + Mobile.APPLE.ordinal() + "Oridinal SAMSUNG " + Mobile.SAMSUNG.ordinal()); //print

    }


}
