package com.codes.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortComparatorDemo {
    public static void main (String[] args){
        ArrayList<EmployeeComparator> Arr = new ArrayList<EmployeeComparator>();
        Arr.add(new EmployeeComparator(1044, "Rajesh", "Bangalore"));
        Arr.add(new EmployeeComparator(1031, "Ralph", "Hyderabad"));
        Arr.add(new EmployeeComparator(1201, "Karan", "Haryana"));
        System.out.println("Unsorted Data");
        for (int i=0; i<Arr.size(); i++)
            System.out.println(Arr.get(i));
        Collections.sort(Arr, new SortByRoll());
        System.out.println("nSorted data according to Employee IDs");
        for (int i=0; i<Arr.size(); i++)
            System.out.println(Arr.get(i));
        Collections.sort(Arr, new SortByName());
        System.out.println("nSorted data according to Employee name");
        for (int i=0; i<Arr.size(); i++)
            System.out.println(Arr.get(i));
    }



}

class EmployeeComparator {
    int EmpID;
    String name, address;
    public EmployeeComparator(int EmpID, String name, String address) {
        this.EmpID = EmpID;
        this.name = name;
        this.address = address;
    }
    public String toString() {
        return this.EmpID + " " + this.name + " " + this.address;
    }
}
class SortByRoll implements Comparator<EmployeeComparator> {
    public int compare(EmployeeComparator a, EmployeeComparator b){
        return a.EmpID - b.EmpID;
    }
}
class SortByName implements Comparator<EmployeeComparator> {
    public int compare(EmployeeComparator a, EmployeeComparator b) {
        return a.name.compareTo(b.name);
    }
}
