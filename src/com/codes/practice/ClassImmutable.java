package com.codes.practice;

import java.util.HashMap;
import java.util.Map;

// Create An Immutable Class
public class ClassImmutable {
    public static void main(String[] args)
    {

        // Creating Map object with reference to HashMap
        Map<String, String> map = new HashMap<>();

        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        StudentImmu s = new StudentImmu("ABC", 101, map);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());

        // Uncommenting below line causes error
        // s.regNo = 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetadata());
        s.getMetadata().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetadata());
    }
}

// Class 1
// An immutable class
// 1. final class
// 2. private final fields
// 3. there should not be any setters
final class StudentImmu {

    // Member attributes of final class
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    // Constructor of immutable class
    // Parameterized constructor
    public StudentImmu(String name, int regNo,
                   Map<String, String> metadata)
    {
        this.name = name;
        this.regNo = regNo;

        Map<String, String> tempMap = new HashMap<>();

        // Iterating using for-each loop
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap;
    }

    public String getName() { return name; }
    public int getRegNo() { return regNo; }

    public Map<String, String> getMetadata()
    {
        // create a copy of HashMap data for return
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

