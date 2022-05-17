package com.codes.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

// Iterator:
// 1) Can traverse elements present in Collection only in the forward direction.
// 2) Helps to traverse Map, List and Set.
// 3) Indexes cannot be obtained by using Iterator.
// 4) Cannot modify or replace elements through Collection
//    Cannot add or remove elements through Collection (throws ConcurrentModificationException).
//    Allowed remove() through Iterator
// 5) Certain methods of Iterator are next(), remove() and hasNext().
//
// ListIterator:
// 1) Can traverse elements present in Collection both in forward and backward directions.
// 2) Can only traverse List and not Map and Set.
// 3) methods like nextIndex() and previousIndex() to obtain indexes of elements at any time while traversing List.
// 4) can modify or replace elements through ListIterator.set(E e), also ListIterator.remove(), .add(),
//    However, throw exception when add() and remove() through collections list when calling next iterator.next() (see example below)
// 5) Certain methods of ListIterator are next(), previous(), hasNext(), hasPrevious(), add(E e).
//
public class CollectionIteratorListIterator {
    public static void main(String[] args) {
        forwardBackward();
        replaceElement();
    }

    public static void forwardBackward() {
        ArrayList<Integer> list
                = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Iterator
        Iterator itr = list.iterator(); // itr is a wrapper of list

        System.out.println("Iterator:");
        System.out.println("Forward traversal: ");
        int i=0;
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
            if (i==2) {

                //itr.remove(); // OK. no iterator.add() methods available

                //list.add(3,33); // exception when calling itr.next();
                // or
                //list.add(33); // exception when calling itr.next();
                // or
                //list.remove(2); // exception when calling itr.next();
            }
            i++;
        }
        System.out.println();

        //
        // Creating a vector object
        Vector<Integer> v = new Vector<Integer>();

        // Adding elements to the vector object
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);
        // Creating Iterator object
        Iterator<Integer> itrv = v.iterator();

        // Checking the next element availability
        while (itrv.hasNext()) {

            // Moving cursor to the next element
            int intV = (Integer)itrv.next();

            // Checking if i == 10 then
            // remove the element
            if (intV == 10) {
                itrv.remove();
            }
        }
        System.out.println(v);
        System.out.println();



        // ListIterator
        ListIterator litr = list.listIterator(); // litr is a wrapper of list

        System.out.println("ListIterator:");
        System.out.println("Forward Traversal : ");
        i=0;
        while (litr.hasNext()) {
            System.out.print(litr.next() + " ");
            if (i==2) {

                litr.remove(); // OK. no iterator.add() methods available
                litr.add(33);  // add at removed item position
                litr.previous();
                litr.set(44);   // Exception without litr.previous() call

                //list.add(3,33); // exception when calling itr.next();
                // or
                //list.add(33); // exception when calling itr.next();
                // or
                //list.remove(2); // exception when calling itr.next();
            }
            i++;

        }
        System.out.println();

        System.out.println("Backward Traversal : ");

        while (litr.hasPrevious())
            System.out.print(litr.previous() + " ");

        System.out.println();
    }
    public static void replaceElement()
    {

        ArrayList<Integer> aList
                = new ArrayList<Integer>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);
        aList.add(5);

        System.out.println("Elements of ArrayList: ");
        for (Integer i : aList) {
            System.out.println(i);
        }
        ListIterator<Integer> l = aList.listIterator();  // l is a wrapper of aList
        l.next();
        l.set(80000);  // replace index 0 (item value 1)

        l.set(70000);  // replace index 0 (item value 80000)
        l.next();
        l.set(60000);  // replace index 1 (item value 2)
        System.out.println("\nNow the ArrayList" + " elements are: ");
        for (Integer i : aList) {
            System.out.println(i);
        }
    }
}
