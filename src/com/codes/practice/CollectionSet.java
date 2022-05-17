package com.codes.practice;

import java.util.*;

//
// HashSet is an unordered & unsorted collection of the data set,
// whereas the LinkedHashSet is an ordered and sorted collection of HashSet.
//
// LinkedHashSet
//  it is an ordered version of HashSet that maintains a doubly-linked List across all elements.
//  it is used when the insertion order is needed to be maintained.
//
// HashSet
//  When iterating through a HashSet the order is unpredictable.
//  HashSet iterates faster than LinkedHashSet
//
// TreeSet
//  implements the SortedSet interface and uses a Tree for storage.
// The order is maintained by a set using their natural ordering whether or not an explicit comparator is provided.
//
public class CollectionSet {
    public static void main(String[] args) {
//        LinkedHashSetDemo1();
//        HashSetDemo1();
//        TreeSetDemo1();
//        listToSet();
        treeSetOps();
    }
    private static void LinkedHashSetDemo1() {
        {
            // create an instance of LinkedHashSet
            LinkedHashSet<String> lhs = new LinkedHashSet<String>();

            // insert element in LinkedHashMap
            lhs.add("Amit");

            // insert first null key
            lhs.add(null);
            lhs.add("Vijay");
            lhs.add("Rahul");

            // insert second null key
            // which replace first null key value
            lhs.add(null);
            // insert duplicate
            lhs.add("Vijay");

            // create an iterator
            // iterate and print the elements
            Iterator<String> itr = lhs.iterator();
            System.out.println("LinkedHashSet order is in insertion order:");

            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }

    private static void HashSetDemo1()
    {
        // Creating an empty HashSet
        HashSet<String> h = new HashSet<String>();

        // Adding elements into HashSet
        // using add() method
        h.add("India");     // return true
        h.add("Australia"); // return true
        h.add("South Africa"); // return true
        h.add("America"); // return true

        // Adding duplicate elements
        h.add("India");  // return false

        // Displaying the HashSet
        System.out.println(h);
        System.out.println("List contains India or not:" + h.contains("India"));

        // Removing items from HashSet
        // using remove() method
        h.remove("Australia");
        System.out.println("List after removing Australia:" + h);

        // Display message
        System.out.println("Iterating over list (order is unsorted):");

        // Iterating over hashSet items
        Iterator<String> i = h.iterator();

        // Holds true till there is single element remaining
        while (i.hasNext())

            // Iterating over elements using next() method
            System.out.println(i.next());
    }

    private static void TreeSetDemo1()
    {
        // Creating a Set interface with reference to TreeSet class
        // Declaring object of string type
        Set<String> ts = new TreeSet<>();

        // Elements are added using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");

        // Print all elements inside object
        System.out.println(ts);
    }

    private static void listToSet() {
        List <String> list = new ArrayList();

        list.add("Ravi");
        list.add("Vijay");
        list.add("Ajay");
        list.add("Chao");
        list.add("Jenny");
        list.add("Jenny");
        System.out.println("List: "+list);

        System.out.println("ArrayList:");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Set <String> hs = new HashSet(list);
        System.out.println("HashSet: "+hs);

        System.out.println("HashSet:");
        it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // same order as List insert order
        Set <String> lhs = new LinkedHashSet(list);
        System.out.println("LinkedHashSet: "+lhs);

        System.out.println("LinkedHashSet:");
        it = lhs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // sorted
        Set <String> ts = new TreeSet(list);
        System.out.println("TreeSet (sorted) from list: "+ts);

        System.out.println("TreeSet:");
        it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        List <String> ls = new ArrayList(ts);
        System.out.println("ArrayList from TreeSet: "+ls);


    }
    private static void treeSetOps() {
        // TreeSet : sorted
        TreeSet<Integer> intSet=new TreeSet<Integer>();
        intSet.add(24);
        intSet.add(66);
        intSet.add(12);
        intSet.add(15);
        System.out.println("Initial Integer TreeSet: "+intSet);

        System.out.println("Highest Value: "+intSet.pollFirst()); // delete after poll
        System.out.println("Lowest Value: "+intSet.pollLast());   // delete after poll

        System.out.println("Integer TreeSet after poll: "+intSet);

        intSet.add(66);
        intSet.add(12);

        System.out.println("Head Set: "+ intSet.headSet(24, true));
        System.out.println("TailSet: "+ intSet.tailSet(15, false));

        TreeSet<String> strSet=new TreeSet<String>();
        strSet.add("A");
        strSet.add("B");
        strSet.add("C");
        strSet.add("D");
        strSet.add("E");
        System.out.println("Initial Set: "+strSet);
        System.out.println("Reverse Set: "+strSet.descendingSet());
        System.out.println("Head Set: "+strSet.headSet("C", true));
        System.out.println("SubSet: "+strSet.subSet("A", false, "E", true));
        System.out.println("TailSet: "+strSet.tailSet("C", false));

        System.out.println("Intial Set: "+strSet);
        System.out.println("Head Set: "+strSet.headSet("C"));
        System.out.println("SubSet: "+strSet.subSet("A", "E"));
        System.out.println("TailSet: "+strSet.tailSet("C"));
    }
}


