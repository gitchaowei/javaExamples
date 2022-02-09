package com.Interview.CreationalDesignPatterns;

public class SingletonExample{

    public static void main(String[] args) {
        SingletonClassic singletonClassic = SingletonClassic.getInstance();

        singletonClassic.sayHello();
    }

}