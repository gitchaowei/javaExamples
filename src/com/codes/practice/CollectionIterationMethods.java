package com.codes.practice;

import java.util.*;

public class CollectionIterationMethods {
    public static void main(String[] args) {
        forLoop();
        iteratorMethod();
        forEachMethod();
    }

    // Java program to demonstrate the
    // working of enhanced for loop to iterate
    // collection objects
    //
    public static void forLoop()
    {
        // 1. Using enhanced For loop

        // Declaring the ArrayList
        Collection<String> calstr = new ArrayList<String>();
        List<String> alstr = new ArrayList<String>();

        // Appending new elements at
        // the end of the list
        alstr.add("Abhishek Rout");
        alstr.add("Vaibhav Kamble");
        alstr.add("Anupam Kumar");

        // for-each loop for iterating
        // unconditionally through collection
        for (String name : alstr)
            System.out.println("Name : " + name);

        // 2. Using simple For loop
        // Declaring the ArrayList
        Vector<String> vstr = new Vector<String>();

        // Appending new elements at
        // the end of the list
        vstr.add("Abhishek Rout");
        vstr.add("Vaibhav Kamble");
        vstr.add("Anupam Kumar");

        // for loop for iterating
        // through collection
        for (int i = 0; i < vstr.size(); i++)
            System.out.println("Name " + (i + 1) + ": " + vstr.get(i));
    }

    // Java program to demonstrate the working of iterator method to iterate
    // collection objects
    public static void iteratorMethod()
    {
        //Using Iterator method
        // Declaring the LinkedList
        LinkedList<String> llstr = new LinkedList<String>();

        // Appending new elements at
        // the end of the list
        llstr.add("Abhishek Rout");
        llstr.add("Vaibhav Kamble");
        llstr.add("Anupam Kumar");

        // for loop for iterating
        // conditionally through collection
        System.out.println("Using For loop");

        for (Iterator<String> itr = llstr.iterator();
             itr.hasNext();)

            System.out.println("Name : " + itr.next());

        // while loop for iterating
        // conditionally through collection
        System.out.println("\nUsing While Loop");

        Iterator<String> itr = llstr.iterator();

        while (itr.hasNext())
            System.out.println("Name : " + itr.next());
    }

    public static void forEachMethod()
    {
        // Using .forEach() method Declaring the ArrayList
        ArrayList<String> alstr = new ArrayList<String>();

        // Appending new elements at the end of the list
        alstr.add("Abhishek Rout");
        alstr.add("Vaibhav Kamble");
        alstr.add("Anupam Kumar");

        // forEach for iterating through collection
        // with iterable variable
        System.out.println("With iterable");

        alstr.forEach((String name) -> {
            System.out.println("Name : " + name);
        });

        System.out.println("\nWithout iterable");
        alstr.forEach(System.out::println);
    }
}
