package com.codes.practice.DesignPatterns.Creational;

// The main problem with above method is that it is not thread safe.
// such as two SingletonClassic objects created using one SingletonClassic object (static)
// created in the class.
public class SingletonClassic {
    //Public class
    //1. private and static member data
    private static SingletonClassic singletonClass = null;

    // 2. private constructor to force use of getInstance()
    // to create Singleton object
    private SingletonClassic() {    }

    // 3.Singleton obj is not created until we need it and call getInstance() method
    public static SingletonClassic getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClassic();
        }
        return singletonClass;
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
