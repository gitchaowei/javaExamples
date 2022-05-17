package com.codes.practice;
//
// The most commonly used type parameter names are:
//
//  E - Element (used extensively by the Java Collections Framework)
//  K - Key
//  N - Number
//  T - Type
//  V - Value
//  S,U,V etc. - 2nd, 3rd, 4th types
//these names are used throughout the Java SE API
//
public class GenericPrintClass<T extends Animal> {

    private T thingToPrint;

    public GenericPrintClass(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
