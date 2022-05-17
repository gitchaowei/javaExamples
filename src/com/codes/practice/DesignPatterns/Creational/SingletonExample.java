package com.codes.practice.DesignPatterns.Creational;

public class SingletonExample{

    public static void main(String[] args) {
        SingletonClassic singletonClassic = SingletonClassic.getInstance();

        singletonClassic.sayHello();
    }

}