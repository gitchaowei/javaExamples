package com.codes.practice;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class StackDemo {
    public static void main(String args[]) {
        StackDemo1 ();
    }

    public static void StackDemo1 () {
        //creating an object of Stack class
        Stack <Integer> stk = new Stack<>();
        System.out.println("stack: " + stk);
        //pushing elements into the stack
        pushelmnt(stk, 20);
        pushelmnt(stk, 13);
        pushelmnt(stk, 89);
        pushelmnt(stk, 90);
        pushelmnt(stk, 11);
        pushelmnt(stk, 45);
        pushelmnt(stk, 18);
        //popping elements from the stack
        popelmnt(stk);
        popelmnt(stk);
        //throws exception if the stack is empty
        try
        {
            popelmnt(stk);
        }
        catch (EmptyStackException e)
        {
            System.out.println("empty stack");
        }
    }
    //performing push operation
    private static void pushelmnt(Stack stk, int x)
    {
        //invoking push() method
            stk.push(x);
        System.out.println("push -> " + x);
        //prints modified stack
        System.out.println("stack: " + stk);
    }
    //performing pop operation
    private static void popelmnt(Stack stk)
    {
        System.out.print("pop -> ");
        //invoking pop() method
        Integer x = (Integer) stk.pop();
        System.out.println(x);
        //prints modified stack
        System.out.println("stack: " + stk);
    }

    public static void StackDemo2()
    {
        Stack<String> stk= new Stack<>();
        // pushing elements into Stack
        stk.push("Apple");
        stk.push("Grapes");
        stk.push("Mango");
        stk.push("Orange");
        System.out.println("Stack: " + stk);
        // Access element from the top of the stack
        String fruits = stk.peek();
        //prints stack
        System.out.println("Element at top: " + fruits);
    }
    public static void StackDemo3()
    {
        // .search
        // It returns the object location from the top of the stack.
        // If it returns -1, it means that the object is not on the stack.
        Stack<String> stk= new Stack<>();
//pushing elements into Stack
        stk.push("Mac Book");
        stk.push("HP");
        stk.push("DELL");
        stk.push("Asus");
        System.out.println("Stack: " + stk);
// Search an element
        int location = stk.search("HP");
        System.out.println("Location of Dell: " + location);
    }

    public static void StackDemo4()
    {
        Stack stk = new Stack();
        stk.push(22);
        stk.push(33);
        stk.push(44);
        stk.push(55);
        stk.push(66);
// Checks the Stack is empty or not
        boolean rslt=stk.empty();
        System.out.println("Is the stack empty or not? " +rslt);
// Find the size of the Stack
        int x=stk.size();
        System.out.println("The stack size is: "+x);
        //iteration over the stack
        Iterator iterator = stk.iterator();
        while(iterator.hasNext())
        {
            Object values = iterator.next();
            System.out.println(values);
        }
    }
}
