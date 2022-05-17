package com.codes.practice;

import java.util.Collections;
import java.util.LinkedList;

public class CollectionList {
    public static void main(String[] args) {
// Declaring linkedlist without any initial size
        LinkedList<String> ll = new LinkedList<String>();
        ll.add(new String("Physics"));
        ll.add(new String("Maths"));
        ll.add(new String("Java"));
        ll.add(new String("English"));
        ll.add(new String("Chemistry"));
        System.out.println("The elements of the linked list before reversing: " + ll);
        // Calling user defined function for reversing
        ll = reverseLinkedList(ll);
        System.out.println("The elements of the linked list after reversing: " + ll);
    }

    public static LinkedList<String> reverseLinkedList(LinkedList<String> ll)
    {
        for (int i = 0; i < ll.size() / 2; i++)
        {
            // swap
            String temp = ll.get(i);
            ll.set(i, ll.get(ll.size() - i - 1));
            ll.set(ll.size() - i - 1, temp);
        }

        // or
        // Collections.reverse method to reverse the list
        //Collections.reverse(ll);
        // Return the reversed arraylist
        return ll;
    }



}
