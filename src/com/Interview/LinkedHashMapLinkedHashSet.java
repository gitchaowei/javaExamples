package com.Interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LinkedHashMapLinkedHashSet {

    public static void main(String args[]) {
        LinkedHashMapExample();
        LinkedHashSetExample();
        Linked_Hash_Map_RemoveEldest();
    }


    private static void LinkedHashMapExample() {
        // create an instance of LinkedHashMap
        LinkedHashMap<Integer, String> lhm;
        lhm = new LinkedHashMap<Integer, String>();

        // insert element in LinkedHashMap
        lhm.put(100, "Amit");

        // insert first null key
        lhm.put(null, "Ajay");
        lhm.put(101, "Vijay");
        lhm.put(102, "Rahul");

        // insert second null key
        // which replace first null key value
        lhm.put(null, "Anuj");

        // insert duplicate
        // which replace first 102 key value
        lhm.put(102, "Saurav");

        // iterate and print the key/value pairs
        lhm.entrySet().stream().forEach((m) -> {
            System.out.println(m.getKey() + " "
                    + m.getValue());
        });
    }

    private static void Linked_Hash_Map_Calls() {

        // Creating an empty LinkedHashMap
        LinkedHashMap<String, String> lhm
                = new LinkedHashMap<String, String>();

        // Adding entries in Map
        // using put() method
        lhm.put("one", "practice.geeksforgeeks.org");
        lhm.put("two", "code.geeksforgeeks.org");
        lhm.put("four", "quiz.geeksforgeeks.org");

        // Printing all entries inside Map
        System.out.println(lhm);

        // Note: It prints the elements in same order
        // as they were inserted

        // Getting and printing value for a specic key
        System.out.println("Getting value for key 'one': "
                + lhm.get("one"));

        // Getting size of Map using size() method
        System.out.println("Size of the map: "
                + lhm.size());

        // Checking whether Map is empty or not
        System.out.println("Is map empty? "
                + lhm.isEmpty());

        // Using containsKey() method to check for a key
        System.out.println("Contains key 'two'? "
                + lhm.containsKey("two"));

        // Using containsKey() method to check for a value
        System.out.println(
                "Contains value 'practice.geeks"
                        + "forgeeks.org'? "
                        + lhm.containsValue("practice"
                        + ".geeksforgeeks.org"));

        // Removing entry using remove() method
        System.out.println("delete element 'one': "
                + lhm.remove("one"));

        // Printing mappings to the console
        System.out.println("Mappings of LinkedHashMap : "
                + lhm);
    }

    private static void LinkedHashSetExample() {
        {
            // create an instance of LinkedHashSet
            LinkedHashSet<String> lhs
                    = new LinkedHashSet<String>();

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
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }

    }

    private static void Linked_Hash_Map_RemoveEldest() {
        // Creating the linked hashmap and implementing
        // removeEldestEntry() to MAX size
        final int MAX = 6;
        LinkedHashMap<Integer, String> li_hash_map =
                new LinkedHashMap<Integer, String>() {
                    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                        return size() > MAX;
                    }
                };
        // Adding elements using put()
        li_hash_map.put(0, "Welcome");
        li_hash_map.put(1, "To");
        li_hash_map.put(2, "The");
        li_hash_map.put(3, "World");
        li_hash_map.put(4, "Of");
        li_hash_map.put(5, "geeks");

        System.out.println("" + li_hash_map);

        // Adding more elements
        li_hash_map.put(6, "GeeksforGeeks");

        // Displaying the map after adding one more element
        System.out.println("" + li_hash_map);

        // Adding more elements
        li_hash_map.put(7, "Hello");

        // Displaying the map after adding one more element
        System.out.println("" + li_hash_map);
    }

    private static void Linked_Hash_Map_Clear() {

        // Creating an empty LinkedHashMap
        LinkedHashMap<Integer, String> li_hash_map =
                new LinkedHashMap<Integer, String>();

        // Mapping string values to int keys
        li_hash_map.put(10, "Geeks");
        li_hash_map.put(15, "4");
        li_hash_map.put(20, "Geeks");
        li_hash_map.put(25, "Welcomes");
        li_hash_map.put(30, "You");

        // Displaying the LinkedHashMap
        System.out.println("Initial Mappings are: " + li_hash_map);

        // Clearing the linked hash map using clear()
        li_hash_map.clear();

        // Displaying the final HashMap
        System.out.println("Finally the maps look like this: " + li_hash_map);
    }
}
