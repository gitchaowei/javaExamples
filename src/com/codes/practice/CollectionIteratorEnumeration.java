package com.codes.practice;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

// Difference between Iterator and Enumeration:
// (see also FailFastDemo.java and CollectionsIteratorListIterator.java)
//
// 1) The functionality of Enumeration and the Iterator are same.
// 2) Enumeration can only traverse and fetch the objects for read-only access,
// 3) Enumeration is a legacy interface which is used for traversing Vector, Hashtable
// 4) By using an iterator, we can perform both read and remove operations, but we cannot perform replace operation.
//    Iterator has no add() method. but ListIterator has add())
//    remove the objects through Iterator but not through Collection or throw exception.
// 5) ListIterator is only applicable for list implemented classes like ArrayList, LinkedList, Stack, etc.
//    ListIterator traverses both in the forward and backward direction.
//    By using ListIteartor, we can perform read, remove, and replace operation.
//
public class CollectionIteratorEnumeration {
    public static void main(String args[])
    {
        // Creating a vector object
        Vector<Integer> v = new Vector<Integer>();

        // Adding elements to the vector object
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);

        System.out.println("Enumeration: ");

        // Creating an Enumeration object
        Enumeration e = v.elements();

        // Checking the next element availability
        // no modification through Enumeration e is alloweed
        while (e.hasMoreElements()) {

            // Moving cursor to the next element
            int i = (Integer)e.nextElement();

            // Printing the element
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Iterator: ");

        // Creating Iterator object
        Iterator<Integer> itr = v.iterator();

        // Checking the next element availability
        while (itr.hasNext()) {

            // Moving cursor to the next element
            int i = (Integer)itr.next();

            // Checking if i == 10 then
            // remove the element
            if (i == 10)
                itr.remove();  // OK to remove through itr, but not through v
        }
        System.out.println(v);
        System.out.println();

        System.out.println("ListIterator: ");

        // Creating ListIterator object
        // v is vector impleting list interface, so ListIterator can be used
        ListIterator<Integer> ltr = v.listIterator();

        // Checking the next element availability
        while (ltr.hasNext()) {

            // Moving cursor to the next element
            int i = (Integer)ltr.next();

            // Performing add, remove, and
            // replace operation
            if (i == 20)
                ltr.remove();
            else if (i == 30) {
                ltr.add(60);
                ltr.previous();
            }
            else if (i == 40)
                ltr.set(100);
        }

        System.out.println(v);
    }
}
