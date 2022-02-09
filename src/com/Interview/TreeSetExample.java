package com.Interview;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        //TreeSetExample1 ();
        //TreeSetExample2();
        TreeSetExample4();
    }

    private static void TreeSetExample1() {
        // Creating a NavigableSet object  with
        // reference to TreeSet class
        NavigableSet<String> ts = new TreeSet<>();

        // Elements are added using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");

        // Printing the elements inside the TreeSet object
        System.out.println("Tree Set is " + ts);

        String check = "Geeks";

        // Check if the above string exists in
        // the treeset or not
        System.out.println("Contains " + check + " "
                + ts.contains(check));

        // Print the first element in
        // the TreeSet
        System.out.println("First Value " + ts.first());

        // Print the last element in
        // the TreeSet
        System.out.println("Last Value " + ts.last());

        String val = "Geek";

        // Find the values just greater
        // and smaller than the above string
        System.out.println("Higher " + ts.higher(val));
        System.out.println("Lower " + ts.lower(val));


    }

    private static void TreeSetExample2() {
        // Creating an object of NavigableSet
        // with reference to TreeSet class
        // Declaring object of string type
        NavigableSet<String> ts = new TreeSet<>();

        // Elements are added
        // using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");

        // Print and display initial elements of TreeSet
        System.out.println("Initial TreeSet " + ts);

        // Removing a specific existing element inserted
        // above
        ts.remove("B");

        // Printing the updated TreeSet
        System.out.println("After removing element B" + ts);

        // Now removing the first element
        // using pollFirst() method
        ts.pollFirst();

        // Again printing the updated TreeSet
        System.out.println("After removing first " + ts);

        // Removing the last element
        // using pollLast() method
        ts.pollLast();

        // Lastly printing the elements of TreeSet remaining
        // to figure out pollLast() method
        System.out.println("After removing last " + ts);

    }

    private static void TreeSetExample3() {
        // Creating an object of Set with reference to
        // TreeSet class

        // Note: You can refer above media if geek
        // is confused in programs why we are not
        // directly creating TreeSet object
        Set<String> ts = new TreeSet<>();

        // Adding elements in above object
        // using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");

        // Now we will be using for each loop in order
        // to iterate through the TreeSet
        for (String value : ts)

            // Printing the values inside the object
            System.out.print(value + ", ");

        System.out.println();

        // Object creation
        Set<StringBuffer> sbts = new TreeSet<>();

        // Adding elements to above object
        // using add() method
        sbts.add(new StringBuffer("A"));
        sbts.add(new StringBuffer("Z"));
        sbts.add(new StringBuffer("L"));
        sbts.add(new StringBuffer("B"));
        sbts.add(new StringBuffer("O"));
        sbts.add(new StringBuffer(1));

        // Note: StringBuffer implements Comparable
        // interface

        // Printing the elements
        System.out.println(sbts);
    }

    private static void TreeSetExample4() {
        NavigableSet<Integer> ns = new TreeSet<>();
        ns.add(0);
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.add(4);
        ns.add(5);
        ns.add(6);

        // Get a reverse view of the navigable set
        NavigableSet<Integer> reverseNs = ns.descendingSet();

        // Print the normal and reverse views
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);

        NavigableSet<Integer> threeOrMore = ns.tailSet(3, true);
        System.out.println("3 or  more:  " + threeOrMore);
        System.out.println("lower(3): " + ns.lower(3));
        System.out.println("floor(3): " + ns.floor(3));
        System.out.println("higher(3): " + ns.higher(3));
        System.out.println("ceiling(3): " + ns.ceiling(3));

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());


    }

}
