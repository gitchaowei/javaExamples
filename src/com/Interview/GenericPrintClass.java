package com.Interview;

public class GenericPrintClass<T extends Animal> {

    private T thingToPrint;

    public GenericPrintClass(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
