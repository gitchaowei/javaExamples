package com.Interview.CreationalDesignPatterns;
//
// Here using synchronized makes sure that only one thread at a time can execute getInstance().
//The main disadvantage of this is method is that using synchronized every time
// while creating the singleton object is expensive and may decrease the performance of your program.
// However if performance of getInstance() is not critical for your application
// this method provides a clean and simple solution.
public class SingletonSyn {
    private static SingletonSyn obj;

    private SingletonSyn() {}

    // Only one thread can execute this at a time
    public static synchronized SingletonSyn getInstance()
    {
        if (obj==null)
            obj = new SingletonSyn();
        return obj;
    }

}
