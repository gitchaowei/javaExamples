package com.codes.practice;

import java.text.ParseException;
import java.util.*;

// LinkedHashMap
//  it maintains the insertion order of keys, the order in which keys are inserted into LinkedHashMap.
//
// HashMap
//  it doesn't maintain any order of keys, or values. it is totally random.
//  it provides an easy way to insert, delete, and search the elements,
//  HashMap iterates faster than LinkedHashMap
//
public class CollectionHashMap {

    public static void main(String args[]) {
//        HashMapDemo1();
//        LinkedHashMapDemo1();
//        LinkedHashMapDemo2();

//        LinkedHashMap_RemoveEldest();
//        LinkedHashMap_Clear();
    }

    private static void HashMapDemo1(){
        //HashMap implementation
        Map<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(1,"Chris");  //Adding elements in Map
        hm.put(null, "Ajay");
        hm.put(2,"Morris");
        hm.put(3,"Sam");
        hm.put(4,"Cruise");
        System.out.println("Iterating Hashmap...");
        for(Map.Entry me : hm.entrySet()){
            System.out.println(me.getKey()+" "+me.getValue());
        }
    }

    private static void LinkedHashMapDemo1() {
        // create an instance of LinkedHashMap
        Map<Integer, String> lhm;
        lhm = new LinkedHashMap<Integer, String>();

        // insert element in LinkedHashMap
        lhm.put(100, "Amit");

        // insert first null key
        lhm.put(null, "Ajay");
        lhm.put(101, "Vijay");
        lhm.put(102, "Rahul");
        lhm.put(103, "Rahul"); //q duplicated value

        // insert second null key
        // which replace first null key value
        lhm.put(null, "Anuj");

        // insert duplicate
        // which replace first 102 key value
        lhm.put(102, "Saurav");

        // Printing all entries inside Map
        // Note: It prints the elements in same order as they were inserted
        System.out.println(lhm);

        // iterate and print the key/value pairs
        lhm.entrySet().stream().forEach((m) -> {
            System.out.println(m.getKey() + " "
                    + m.getValue());
        });
    }

    private static void LinkedHashMapDemo2() {

        // Creating an empty LinkedHashMap
        Map<String, String> lhm
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


    private static void LinkedHashMap_RemoveEldest() {
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

    private static void LinkedHashMap_Clear() {

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

    private static void hashMapMerge() {
        // example 1
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"A");
        hashMap.put(2,"B");
        hashMap.put(3,"C");
        System.out.println("HashMap : " + hashMap);

        hashMap.merge(3, "DDD", (v1, v2) -> v1.length() > v2.length() ? v1 : v2);
        System.out.println("HashMap after Merge : " + hashMap);
        // output:
        // HashMap 1 : {1=A, 2=B, 3=C}
        // HashMap 1 after Merge : {1=A, 2=B, 3=DDD}

        // example 2: same key merge
        HashMap<Integer,String> hashMap1 = new HashMap<>();
        hashMap1.put(1,"A");
        hashMap1.put(2,"B");
        hashMap1.put(3,"C");
        System.out.println("HashMap 1 : " + hashMap1);

        HashMap<Integer,String> hashMap2 = new HashMap<>();
        hashMap2.put(1,"D");
        hashMap2.put(2,"E");
        hashMap2.put(3,"F");
        System.out.println("HashMap 2 : " + hashMap2);

        hashMap2.forEach((key, value) -> hashMap1.merge( key, value,(v1, v2)-> v1.equalsIgnoreCase(v2) ? v1 : v1 + v2));
        System.out.println("HashMap 1 after Merge : " + hashMap1);
        // output hashMap1 and hashMap2:
        //
        // HashMap 1 : {1=A, 2=B, 3=C}
        // HashMap 2 : {1=D, 2=E, 3=F}
        // HashMap 1 after Merge : {1=AD, 2=BE, 3=CF}

        // example 3: different key merge
        HashMap<Integer,String> hashMap3 = new HashMap<>();
        hashMap3.put(1,"A");
        hashMap3.put(2,"B");
        hashMap3.put(3,"C");
        System.out.println("HashMap 1 : " + hashMap3);

        HashMap<Integer,String> hashMap4 = new HashMap<>();
        hashMap4.put(4,"D");
        hashMap4.put(5,"E");
        hashMap4.put(6,"F");
        System.out.println("HashMap 2 : " + hashMap4);

        hashMap4.forEach((key, value) -> hashMap3.merge( key, value,(v1, v2)-> v1.equalsIgnoreCase(v2) ? v1 : v1 + v2));
        System.out.println("HashMap 1 after Merge : " + hashMap3);

        // output:
        // HashMap 1 : {1=A, 2=B, 3=C}
        // HashMap 2 : {4=D, 5=E, 6=F}
        // HashMap 1 after Merge : {1=A, 2=B, 3=C, 4=D, 5=E, 6=F}
    }

}




