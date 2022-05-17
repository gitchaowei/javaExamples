package com.codes.practice;

import java.util.Optional;

// Optional class was introduced in Java 8.
//
//The purpose of the class is to provide a type-level solution for representing optional values
// instead of null references.
//
public class OptionalClassDemo1 {
    public static void main(String[] args) {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        Optional<String> empty = Optional.empty();

        // the argument passed to the of() method can't be null.
        // Otherwise, we'll get a NullPointerException
        name = null;
        //Optional.of(name);  //NullPointerException
        Optional<String> optnull = Optional.ofNullable(name);
        System.out.println("Null isPresent(): " + optnull.isPresent() +" A String isPresent(): " + opt.isPresent());

        System.out.println("Null IsEmpty: " + optnull.isEmpty() +" A String IsEmpty: " + opt.isEmpty());

        Optional<String> opt1 = Optional.of("baeldung");
        opt1.ifPresent(nameStr -> System.out.println(nameStr.length()));

        // output:
        // Null isPresent(): falseA String isPresent(): true
        // Null IsEmpty: trueA String IsEmpty: false
        // 8
    }
}
