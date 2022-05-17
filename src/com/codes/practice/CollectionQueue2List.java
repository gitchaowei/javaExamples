package com.codes.practice;

import java.util.*;


public class CollectionQueue2List {
    public static void main(String[] args) {
//        LinkedList2List();
        PriorityQueue2Array2List();
        PriorityQueueTest();

    }

    // LinkedList implements both List and Queue (+ DeQue) interfaces
    public static void LinkedList2List() {
        Queue q = new LinkedList();
        q.add("Amit Sharma");
        q.add("Vijay Raj");
        q.add("JaiShankar");
        q.add("Raj");
        List l = (List) q;  // OK since LinkedList implements both Queue and List interfaces

        // Collections.sort(List)
        // Sorts the specified list into ascending order,
        // according to the natural ordering of its elements.
        Collections.sort(l);

        System.out.println("The list (sorted) converted from LinkedList is:");
        System.out.println(l);
    }

    // PriorityQueue implements Queue interface
    // However, it does not implement List interface
    //
    // The elements of the priority queue are ordered according to their natural ordering,
    // or by a Comparator provided at queue construction time, depending on which constructor is used.
    // A priority queue does not permit null elements.
    // A priority queue relying on natural ordering also does not permit insertion of non-comparable objects
    // (doing so may result in ClassCastException).
    public static void PriorityQueue2Array2List() {
        Queue q = new PriorityQueue();
        q.add("Amit Sharma");
        q.add("Vijay Raj");
        q.add("JaiShankar");
        q.add("Raj");

        //Collections.sort(queue); // cannot do this. Collections.sort() sorts a list type only
        //List l = (List) q; // Not OK, throws ClassCastException since PriorityQueue does not implement List interface

        System.out.println("The original Priority Queue [sorted differently from Arrays.sort()] is:");
        System.out.println(q);

        // Creating the array and using toArray()
        Object[] arr = q.toArray();
        //convert to List
        List l = Arrays.asList(arr);  // l is a wrapper of arr
        //Arrays.sort(arr);             // sorting arr will reflect l. So l is also sorted
        Collections.sort(l);    // or sort l will reflect arr. So arr is also sorted

        // print the list
        System.out.println("The list (sorted) converted from Priority Queue is:");
        System.out.println(l);
        // print the array
        System.out.println("The array (sorted) converted from Priority Queue is:");
        for (int j = 0; j < arr.length; j++)
            System.out.println(arr[j]);
    }

    // Test iterator() and queue methods
    public static void PriorityQueueTest() {
        PriorityQueue<String> queue=new PriorityQueue<String>();  // sorted in their natural order
        queue.add("Amit Sharma");
        queue.add("Vijay Raj");
        queue.add("JaiShankar");
        queue.add("Raj");

        System.out.println("Priority Queue operation example:");
        // queue.element():
        // Retrieves, but does not remove, the head of this queue.
        System.out.println("head:"+queue.element()); // "Amit Sharma"
        // queue.peek():
        // Retrieves, but does not remove, the head of this queue,
        // or returns null if this queue is empty.
        System.out.println("head:"+queue.peek());

        System.out.println("iterating the queue elements:");
        Iterator itr=queue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        // output:
        //  Amit Sharma
        //  Raj
        //  JaiShankar
        //  Vijay Raj

        // remove():
        // Retrieves and removes the head of this queue.
        // This method differs from poll() only in that it throws an exception if this queue is empty.
        //queue.remove();
        //queue.remove();
        System.out.println("Item: " + queue.remove());
        System.out.println("Item: " + queue.remove());
        System.out.println("Item: " + queue.remove());
        System.out.println("Item: " + queue.remove());

        // queue.poll() Retrieves and removes the head of this queue in sorted order
        // or returns null if this queue is empty.
        System.out.println("Item: " + queue.poll());
        System.out.println("Item: " + queue.poll());
        System.out.println("Item: " + queue.poll());
        System.out.println("Item: " + queue.poll());

        System.out.println("after removing two elements:");
        Iterator<String> itr2 = queue.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
