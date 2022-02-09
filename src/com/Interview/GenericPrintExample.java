package com.Interview;

import java.util.ArrayList;
import java.util.List;

public class GenericPrintExample {
    public static void main(String[] args) {
        GenericPrintPrimitive<Integer> iprint = new GenericPrintPrimitive<>(23);
        iprint.print();

        GenericPrintPrimitive<Double> dprint = new GenericPrintPrimitive<>(33.5);
        dprint.print();
        //
        GenericPrintClass<Cat> catprint = new GenericPrintClass<>(new Cat());
        catprint.print();
        GenericPrintClass<Dog> dogprint = new GenericPrintClass<>(new Dog());
        dogprint.print();

        shout("John", 74);

        //example to print a list
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(33);
        printList(intList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printList(catList);

        printListExtends(catList);

    }

    //Generic method: parameter types <T, V> and return type T
    private static <T, V> T shout(T thingToShout, V otherThingToShout) {
        System.out.println(thingToShout + "!!!!!");
        System.out.println(otherThingToShout + "!!!!!");

        return thingToShout;
    }

    // Print out a wildcard list: any type of list
    private static void printList(List<?> myList) {
        System.out.println(); // print out

    }

    // Print out a wildcard list with extends: any type extended from Animal
    private static void printListExtends(List<? extends Animal> myList) {
        System.out.println(); // print out

    }
}

