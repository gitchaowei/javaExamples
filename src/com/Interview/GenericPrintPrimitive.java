package com.Interview;

public class GenericPrintPrimitive<T> {
    private T thingToPrint;

    public GenericPrintPrimitive(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
