package com.codes.practice;

// TreeMap class is a red-black tree based implementation.
// It implements the NavigableMap interface and extends AbstractMap class.
// It provides an efficient means of storing key-value pairs in sorted order.
//
// The important points about Java TreeMap class are:
//
//     Java TreeMap contains values based on the key.
//     Java TreeMap contains only unique elements.
//     Java TreeMap cannot have a null key but can have multiple null values.
//     Java TreeMap is non synchronized.
//     Java TreeMap maintains ascending order.
//
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CollectionTreeMap {
    public static void main(String[] args) {
        TreeMapDemo1();
        TreeMapDemo2();
        TreeMapBookExample();
    }


    private static void TreeMapDemo1() {
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();
        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");
        System.out.println("Before invoking remove() method");
        for(Map.Entry m:map.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }
        map.remove(102);
        System.out.println("After invoking remove() method");
        for(Map.Entry m:map.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }

    private static void TreeMapDemo2(){
        NavigableMap<Integer,String> map=new TreeMap<Integer,String>();
        // or
        //SortedMap<Integer,String> map=new TreeMap<Integer,String>();
        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");
        //Maintains descending order
        System.out.println("descendingMap: "+map.descendingMap());
        //Returns key-value pairs whose keys are less than or equal to the specified key.
        System.out.println("headMap: "+map.headMap(102,true));
        //Returns key-value pairs whose keys are greater than or equal to the specified key.
        System.out.println("tailMap: "+map.tailMap(102,true));
        //Returns key-value pairs exists in between the specified key.
        System.out.println("subMap: "+map.subMap(100, false, 102, true));
    }

    private static void TreeMapBookExample() {
        //Creating map of Books
        Map<Integer, Book_Demo> map=new TreeMap<Integer, Book_Demo>();
        //Creating Books
        Book_Demo b1=new Book_Demo(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book_Demo b2=new Book_Demo(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book_Demo b3=new Book_Demo(103,"Operating System","Galvin","Wiley",6);
        //Adding Books to map
        map.put(2,b2);
        map.put(1,b1);
        map.put(3,b3);

        //Traversing map
        for(Map.Entry<Integer, Book_Demo> entry:map.entrySet()){
            int key=entry.getKey();
            Book_Demo b=entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}

class Book_Demo {
    int id;
    String name,author,publisher;
    int quantity;
    public Book_Demo(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}