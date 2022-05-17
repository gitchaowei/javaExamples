package com.codes.practice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// HashMap is a non-synchronized collection class
public class SynchronizedHashMap {
    public static void main(String[] args) {
        CollectionsSynchronizedMapExample();
        ConcurrentHashMapExample();
    }

    public static void CollectionsSynchronizedMapExample() {
        HashMap<Integer, String> hmap= new HashMap<Integer, String>();
        hmap.put(2, "Anil");
        hmap.put(44, "Ajit");
        hmap.put(1, "Brad");
        hmap.put(4, "Sachin");
        hmap.put(88, "XYZ");

        Map map= Collections.synchronizedMap(hmap);
        Set set = map.entrySet();
        synchronized(map){
            Iterator i = set.iterator();
            // Display elements
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
        }

    }

    public static void ConcurrentHashMapExample() {
        // Creating ConcurrentHashMap
        Map<String, String> cityTemperatureMap = new ConcurrentHashMap<String, String>();

        // Storing elements
        // Null is not allowed in ConcurrentHashMap
        cityTemperatureMap.put("Delhi", "24");
        cityTemperatureMap.put("Mumbai", "32");
        //cityTemperatureMap.put(null, "26");
        cityTemperatureMap.put("Chennai", "35");
        cityTemperatureMap.put("Bangalore", "22" );

        for (Map.Entry<String, String> e : cityTemperatureMap.entrySet()) {
            //need to use .calculate() to have Atomic operations in ConcurrentHashMap

            System.out.println(e.getKey() + " = " + e.getValue());
        }
        // Iterator returned by the Java ConcurrentHashMap is fail-safe
        // which means it will not throw ConcurrentModificationException.
        Iterator<String> iterator = cityTemperatureMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(cityTemperatureMap.get(iterator.next()));
            // adding new value, it won't throw error
            cityTemperatureMap.put("Kolkata", "34");
        }
        // to create concurerntHashSet from ConcurrentHashMap
//        ConcurrentHashMap<String, Integer> bookAndPrice = new ConcurrentHashMap<>();
//        Set<String> concurerntHashSet = bookAndPrice.newKeySet(bookAndPrice.size());
    }
}
