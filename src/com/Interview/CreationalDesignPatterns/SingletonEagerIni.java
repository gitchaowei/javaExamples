package com.Interview.CreationalDesignPatterns;
//
// Static initializer based Java implementation of
// singleton design pattern
// Here we have created instance of singleton in static initializer.
// JVM executes static initializer when the class is loaded and
// hence this is guaranteed to be thread safe.
// Use this method only when your singleton class is light and
// is used throughout the execution of your program.
//
public class SingletonEagerIni {
    private static SingletonEagerIni obj = new SingletonEagerIni();

    private SingletonEagerIni() {}

    public static SingletonEagerIni getInstance()
    {
        return obj;
    }
}
