package com.codes.practice;

import java.util.*;
import java.util.Map.Entry;

public class SortHashMapByValue {
        //implementation of HashMap
        Map<String, Integer> map = new HashMap<String, Integer>();
        public static void main(String[] args)
        {
            SortHashMapByValue sv = new SortHashMapByValue();
            sv.createMap();
            System.out.println("Sorting values in ascending order:");
            sv.sortByValue(true);
            System.out.println("Sorting values in  descending order");
            sv.sortByValue(false);

            sv.sortByKey();

            HashMapSorting ();

        }
        //method to add elements in the HashMap
        void createMap()
        {
            map.put("Apple", 65000);
            map.put("HP", 20000);
            map.put("Dell", 32000);
            map.put("Asus", 21478);
            map.put("Samsung", 36546);
            map.put("Lenovo", 19990);
            System.out.println("Before sorting: ");
            printMap(map);
        }
        //sort elements by values
        void sortByValue(boolean order)
        {
//convert HashMap into List
            List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
//sorting the list elements
            Collections.sort(list, new Comparator<Entry<String, Integer>>()
            {
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
                {
                    if (order)
                    {
//compare two object and return an integer
                        return o1.getValue().compareTo(o2.getValue());}
                    else
                    {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
            });
//prints the sorted HashMap
            Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
            for (Entry<String, Integer> entry : list)
            {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
            printMap(sortedMap);
        }
        //method for printing the elements
        public void printMap(Map<String, Integer> map)
        {
            System.out.println("Company\t Price ");
            for (Entry<String, Integer> entry : map.entrySet())
            {
                System.out.println(entry.getKey() +"\t"+entry.getValue());
            }
            System.out.println("\n");
        }
    //
    // use TreeMap constructor to sort the elements and pass the object of HashMap class
    // as an argument
    //
    void sortByKey() {

        Iterator <String> it = map.keySet().iterator();
        System.out.println("Before Sorting");
        while(it.hasNext())
        {
            String key=(String)it.next();
            System.out.println("key:  "+key+"     value:   "+map.get(key));
        }
        System.out.println("\n");

        System.out.println("After Sorting");

        //using TreeMap constructor to sort the HashMap
        TreeMap mapSorted = new TreeMap (map);
        Iterator itr = mapSorted.keySet().iterator();

        while(itr.hasNext())
        {
            String key=(String)itr.next();
            System.out.println("key:  "+ key + "     value:   "+ map.get(key));
        }
    }


//    private static void  HashMapSorting () {
//
//        HashMap<String, String> codenames = new HashMap<String, String>();
//        codenames.put("JDK 1.1.4", "Sparkler");
//        codenames.put("J2SE 1.2", "Playground");
//        codenames.put("J2SE 1.3", "Kestrel");
//        codenames.put("J2SE 1.4", "Merlin");
//        codenames.put("J2SE 5.0", "Tiger");
//        codenames.put("Java SE 6", "Mustang");
//        codenames.put("Java SE 7", "Dolphin");
//        System.out.println("HashMap before sorting, random order " + codenames);
//
//        Set<Map.Entry<String, String>> entries = codenames.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getKey() + " ==> " + entry.getValue());
//        }
//        // Now let's sort HashMap by keys first
//        // all you need to do is create a TreeMap with mappings of HashMap
//        // TreeMap keeps all entries in sorted order
//        TreeMap<String, String> sorted = new TreeMap<>(codenames);
//
//        Set<Map.Entry<String, String>> mappings = sorted.entrySet();
//        System.out.println("HashMap after sorting by keys in ascending order "+ sorted);
//        for(Map.Entry<String, String> mapping : mappings){
//            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
//        }
//
//        // Now let's sort the HashMap by values
//        // there is no direct way to sort HashMap by values but you
//        // can do this by writing your own comparator, which takes
//        // Map.Entry object and arrange them in order increasing
//        // or decreasing by values.
//        Comparator<Map.Entry<String, String>> valueComparator =
//                new Comparator<Map.Entry<String,String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
//                String v1 = e1.getValue();
//                String v2 = e2.getValue();
//                return v1.compareTo(v2); }
//        };
//        // Sort method needs a List, so let's first convert Set to List in Java
//        List<Map.Entry<String, String>> listOfEntries = new ArrayList<Map.Entry<String, String>>(entries);
//        // sorting HashMap by values using comparator
//        Collections.sort(listOfEntries, valueComparator);
//        LinkedHashMap<String, String> sortedByValue =
//                new LinkedHashMap<String, String>(listOfEntries.size());
//        // copying entries from List to Map
//        for(Map.Entry<String, String> entry : listOfEntries){
//            sortedByValue.put(entry.getKey(), entry.getValue());
//        }
//
//        System.out.println("HashMap after sorting entries by values "+sortedByValue);
//        Set<Map.Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();
//        for(Map.Entry<String, String> mapping : entrySetSortedByValue){
//            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
//        }
//    }

    // re-write codes by memorizing above codes
    private static void  HashMapSorting () {
        Map<String, String> hmap = new HashMap<>();

        hmap.put("JDK 1.1.4", "Sparkler");
        hmap.put("J2SE 1.2", "Playground");
        hmap.put("J2SE 1.3", "Kestrel");
        hmap.put("J2SE 1.4", "Merlin");
        hmap.put("J2SE 5.0", "Tiger");
        hmap.put("Java SE 6", "Mustang");
        hmap.put("Java SE 7", "Dolphin");

        // sorted by key
        Map<String, String> sortedMapByKey =  new TreeMap<>(hmap);
        System.out.println("HashMap Before sorted by key: "+ hmap);
        System.out.println("HashMap after sorted by key: "+ sortedMapByKey);

        // sorting by value
        // 1) get value set
        Set <Map.Entry<String, String>> entriesSet = hmap.entrySet();
        // 2) convert set to list due to Collections.sort(list) needs a list
        List <Map.Entry<String, String>> entriesList = new ArrayList(entriesSet);
        // 3) create Comparator instance and implement Comparator's compare() for sorting by map value
        Comparator <Map.Entry<String, String>> comp =  new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                return (e1.getValue().compareTo(e2.getValue()));
            }
        };
        // 4) sort list
        Collections.sort(entriesList, comp);

        // 5) Convert the sorted list into LinkedHashMap
        //
        Map<String, String> lhmap = new LinkedHashMap<>();

        for (Map.Entry<String, String> entry : entriesList) {  // iterate the list
            lhmap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("HashMap Before sorted by value: "+ hmap);
        System.out.println("HashMap after sorted by value: "+ lhmap);

        // or print using for loop
        Set <Map.Entry<String, String>> lhmapSet = lhmap.entrySet();
        for (Map.Entry<String, String> entry : lhmapSet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
