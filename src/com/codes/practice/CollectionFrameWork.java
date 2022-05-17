package com.codes.practice;

import java.util.*;

//What are the two ways to iterate the elements of a collection?
//What is the difference between ArrayList and LinkedList classes in collection framework?
//What is the difference between ArrayList and Vector classes in collection framework?
//What is the difference between HashSet and HashMap classes in collection framework?
//What is the difference between HashMap and Hashtable class?
//What is the difference between Iterator and Enumeration interface in collection framework?
//What is the difference between Comparable and Comparator interfaces?
//What does the hashcode() method?
//What is the difference between Java collection and Java collections?
//
//Java interview questions on collections
//
// What is the difference between arraylist and vector in java?
//      Vector is synchronized while ArrayList is not synchronized
// What is the difference between arraylist and linkedlist?
//      1) Iterator can traverse only in forward direction
//      2) ListIterator traverses both in forward and backward directions
//      3) ListIterator is only applicable for List collection implemented classes like arraylist, linkedlist etc.
//      4) ListIterator can help to replace an element whereas Iterator cannot.
// What is the difference between Iterator and Enumeration?
//      1) The functionality of Enumeration and the Iterator are same.
//      2) Using Enumeration you can only traverse and fetch the objects for read-only access,
//        where as using Iterator we can also add and remove the objects through Iterator not Collection.
//      3) Enumeration is a legacy interface which is used for traversing Vector, Hashtable
// what is the difference between list and set in java?
// what is the difference between set and map in java?
// what is the difference between hashset and treeset in java?
// what is the difference between hashset and hashmap in java?
// what is the difference between hashmap and treemap in java?
// what is the difference between hashmap and hashtable in java?
// what is the difference between collection and collections in java?
// what is the difference between comparable and comparator interfaces?
// what is the hashcode method in java?
// Java equals method
// Java hashCode method
// Why to override hashcode and equals method in java?
// How hashmap works internally?
// How put and get works in hashmap?
// How to resolve collision in hashmap?
// How hashmap stores null key?
// How hashset works internally?
//
//The Collection interface (java.util.Collection) and Map interface (java.util.Map)
// are the two main “root” interfaces of Java collection classes.
public class CollectionFrameWork {
    public static void main(String[] args) {
        ArrayVectorHashableExample();
        ArrayListExample();
        VectorExample();
        StackExample();
        ArrayDeQueueExample();
    }

    private static void ArrayVectorHashableExample() {
        // Creating instances of the array, vector and hashtable
        int arr[] = new int[]{1, 2, 3, 4};
        Vector<Integer> v = new Vector();
        Hashtable<Integer, String> h = new Hashtable();

        // Adding the elements into the
        // vector
        v.addElement(1);
        v.addElement(2);
        v.add(31);
        // insert at index 0
        v.add(0,11);
        // Adding the element into the
        // hashtable
        h.put(1, "geeks");
        h.put(2, "4geeks");

        // Array instance creation requires [],
        // while Vector and hastable require ()
        // Vector element insertion requires addElement(),
        // but hashtable element insertion requires put()

        // Accessing the first element of the
        // array, vector and hashtable
        System.out.println(arr[0]);
        System.out.println(v.elementAt(0));
        System.out.println(h.get(1));

        // Array elements are accessed using [],
        // vector elements using elementAt()
        // and hashtable elements using get()
    }

    private static void ArrayListExample() {
// ArrayList, Vector, Stack, LinkedList all implement List Interface
        //
        // 1. ArrayList: is non-synchronized (Vector is synchronized)
        //
        // Declaring the ArrayList with
        // initial size n
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Appending new elements at
        // the end of the list
        for (int i = 1; i <= 5; i++)
            al.add(i+10);

        // Printing elements
        System.out.println(al);

        // Remove element at index 3
        al.remove(3);

        // Displaying the ArrayList
        // after deletion
        System.out.println(al);

        // Printing elements one by one
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }

    private static void LinkedlistExample() {
        //
        // 2. Linkedlist
        //
        // Declaring the LinkedList
        LinkedList<Integer> ll = new LinkedList<Integer>();

        // Appending new elements at
        // the end of the list
        for (int i = 1; i <= 5; i++)
            ll.add(i+10);

        // Printing elements
        System.out.println(ll);

        // Remove element at index 3
        ll.remove(3);

        // Displaying the List
        // after deletion
        System.out.println(ll);

        // Printing elements one by one
        for (int i = 0; i < ll.size(); i++)
            System.out.print(ll.get(i) + " ");


    }

    private static void VectorExample() {
        //
        // 3. Vector: is synchronized
        // A vector provides us with dynamic arrays in Java.
        // Though, it may be slower than standard arrays
        // but can be helpful in programs where lots of manipulation in the array is needed.
        // This is identical to ArrayList in terms of implementation.
        // However, the primary difference between a vector and an ArrayList is
        // that a Vector is synchronized and an ArrayList is non-synchronized
        //
        // Declaring the Vector
        Vector<Integer> v = new Vector<Integer>();

        // Appending new elements at the end of the list
        for (int i = 1; i <= 5; i++)
            v.add(i);

        // Printing elements
        System.out.println(v);

        // Remove element at index 3
        v.remove(3);

        // Displaying the Vector
        // after deletion
        System.out.println(v);

        // Printing elements one by one
        for (int i = 0; i < v.size(); i++)
            System.out.print(v.get(i) + " ");

    }

    private static void StackExample() {
// Stack class models and implements the Stack data structure.
// The class is based on the basic principle of last-in-first-out.
// In addition to the basic push and pop operations,
// the class provides three more functions of empty, search and peek.
// The class can also be referred to as the subclass of Vector.
        Stack<String> stack = new Stack<String>();
        stack.push("Geeks");
        stack.push("For");
        stack.push("Geeks");
        stack.push("Geeks");

        // Iterator for the stack
        Iterator<String> itr = stack.iterator();

        // Printing the stack
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        stack.pop();

        // Iterator for the stack
        itr = stack.iterator();

        // Printing the stack
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

    }

    //Queue <T> pq = new PriorityQueue<> ();
    //Queue <T> ad = new ArrayDeque<> ();
    //
    //Where T is the type of the object.
    //
    private static void PriorityQueueExample() {
//A PriorityQueue is used when the objects are supposed to be processed based on the priority.
// It is known that a queue follows the First-In-First-Out algorithm,
// but sometimes the elements of the queue are needed to be processed according to
// the priority and this class is used in these cases.
// The PriorityQueue is based on the priority heap.
// The elements of the priority queue are ordered according to the natural ordering,
// or by a Comparator provided at queue construction time, depending on which constructor is used.
// Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());

    }


    private static void ArrayDeQueueExample() {
        //Array deques are resizable-array and have no capacity restrictions
        // and they grow as necessary to support usage.

// Initializing an deque
        ArrayDeque<Integer> de_que = new ArrayDeque<Integer>(10);

        // add() method to insert
        de_que.add(10);
        de_que.add(20);
        de_que.add(30);
        de_que.add(40);
        de_que.add(50);

        System.out.println(de_que);

        // clear() method
        de_que.clear();

        // addFirst() method to insert the
        // elements at the head
        de_que.addFirst(564);
        de_que.addFirst(291);

        // addLast() method to insert the
        // elements at the tail
        de_que.addLast(24);
        de_que.addLast(14);

        System.out.println(de_que);
    }
}
