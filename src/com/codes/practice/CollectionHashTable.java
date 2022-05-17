package com.codes.practice;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//Features of Hashtable
// a) It is similar to HashMap, but is synchronized.
// b) Hashtable stores key/value pair in hash table.
// c) In Hashtable we specify an object that is used as a key, and the value we want to associate to that key.
//    The key is then hashed, which hash code is used as the index at which the value is stored within the table.
// d) The initial default capacity of Hashtable class is 11 whereas loadFactor is 0.75.
// e) HashMap doesn’t provide any Enumeration, while Hashtable provides not fail-fast Enumeration.
//
public class CollectionHashTable {
    // public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, Serializable
    public static void main(String[] args) {
       HashTableWithNoSetCapability();
       HashTableWithSetFillRatioCapability();
       HashTableFromMap();
    }

    private static void HashTableWithNoSetCapability() {
        // No need to mention the
        // Generic type twice
        Hashtable<Integer, String> ht1 = new Hashtable<>();

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2
                = new Hashtable<Integer, String>();

        // Inserting the Elements
        // using put() method
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        ht2.put(4, "four");
        ht2.put(5, "five");
        ht2.put(6, "six");

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1 + " Size: " + ht1.size());
        System.out.println("Mappings of ht2 : " + ht2 + " Size: " + ht2.size());
        // Check if a key is present and if
        // present, print value
        if (ht1.containsKey(2)) {
            String a = ht1.get(2);
            System.out.println("value for key 2: " + a);
        }
        for (Map.Entry<Integer, String> e : ht1.entrySet()) {
            System.out.println(e.getKey() + " "
                    + e.getValue());
        }

    }

    private static void HashTableWithSetFillRatioCapability() {
        // No need to mention the
        // Generic type twice
        Hashtable<Integer, String> ht1
                = new Hashtable<>(4, 0.75f);

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2
                = new Hashtable<Integer, String>(3, 0.5f);

        // Inserting the Elements
        // using put() method
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        ht2.put(4, "four");
        ht2.put(5, "five");
        ht2.put(6, "six");

        ht2.put(2, "two two"); // update the value at key 2
        ht2.remove(4); // remove the map entry with the key 4

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1 + " Size: " + ht1.size());
        System.out.println("Mappings of ht2 : " + ht2 + " Size: " + ht2.size());
        // Check if a key is present and if
        // present, print value
        if (ht1.containsKey(2)) {
            String a = ht1.get(2);
            System.out.println("value for key 2: " + a);
        }
        for (Map.Entry<Integer, String> e : ht1.entrySet()) {
            System.out.println(e.getKey() + " "
                    + e.getValue());
        }

    }

    private static void HashTableWithSetCapability() {
        // No need to mention the
        // Generic type twice
        Hashtable<Integer, String> ht1 = new Hashtable<>(4);

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2
                = new Hashtable<Integer, String>(2);

        // Inserting the Elements
        // using put() method
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        ht2.put(4, "four");
        ht2.put(5, "five");
        ht2.put(6, "six");

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1 + " Size: " + ht1.size());
        System.out.println("Mappings of ht2 : " + ht2 + " Size: " + ht2.size());
        // Check if a key is present and if
        // present, print value
        if (ht1.containsKey(2)) {
            String a = ht1.get(2);
            System.out.println("value for key 2" + a);
        }
        // Iterating using enhanced for loop
        for (Map.Entry<Integer, String> e : ht1.entrySet()) {
            System.out.println(e.getKey() + " "
                    + e.getValue());

        }
    }

    private static void HashTableFromMap() {
// No need to mention the
        // Generic type twice
        Map<Integer, String> hm = new HashMap<>();

        // Inserting the Elements
        // using put() method
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2 = new Hashtable<Integer, String>(hm);

        // Print mappings to the console
        System.out.println("Mappings of ht2 : " + ht2);

    }
}
