package com.codes.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastDemo {
    public static void main(String[] args)
    {
//        FailFast1();
//        FailFast2();
        FailFast3();

    }


    private static void FailFast1() {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        Iterator iterator = cityCode.keySet().iterator();

        while (iterator.hasNext()) {
            // iterator.next() return the next element in iterator
            System.out.println(cityCode.get(iterator.next()));

            // adding an element to the orignal HashMap.
            // exception will be thrown on next call of next() method
            cityCode.put("Istanbul", "Turkey");
        }
    }

    private static void FailFast2() {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                // Removes from the underlying collection the last element returned by this iterator (optional operation).
                itr.remove();
            }
        }

        System.out.println(al);

        itr = al.iterator();
        while (itr.hasNext()) {//.hasNext() return true but it has no next() due to deleting the original element
            if (itr.next() == 3) {
                // will throw Exception on next call of next() method
                // However, deleting through itr.remove() will be OK
                al.remove(3);
            }
        }
    }

    private static void FailFast3() {

        Integer[] intArr = new Integer[]{1, 3, 5, 8};
        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<Integer>(intArr);
        //
        // When creating iterator of a CopyOnWriteArrayList and CopyOnWriteArraySet,
        // the iterator uses a snapshot of the underlying list (or set) and
        // the iterator does not reflect any changes to the list or set after the snapshot was created.
        // This iterator will never throw a ConcurrentModificationException.
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Integer no = (Integer) itr.next();
            System.out.println(no);
            if (no == 5) {
                // This will not print, hence it has created a separate copy
                list.add(14);  //itr does not see this adding
            }
        }
        System.out.println("List after removal: " + list);
        System.out.println("Iterator list: ");

        itr = list.iterator();
        while (itr.hasNext()) {
            // iterator.next() return the next element in iterator
            System.out.println(itr.next());
        }
    }
}


