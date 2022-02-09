package com.Interview.CreationalDesignPatterns;


//
// declared the obj volatile which ensures that multiple threads offer the obj variable
// correctly when it is being initialized to Singleton instance.
// This method drastically reduces the overhead of calling the synchronized method every time.
//
public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck obj  = null;

    private SingletonDoubleCheck() {}

    public static SingletonDoubleCheck getInstance()
    {
        if (obj == null)
        {
            // To make thread safe
            synchronized (SingletonDoubleCheck.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj==null)
                    obj = new SingletonDoubleCheck();
            }
        }
        return obj;
    }


}
