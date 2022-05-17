package com.codes.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayListObjectSort1();
        ArrayListObjectSort2();
        SortArrays();
       // ArraylistReverseOrder();
    }


    static void SortArrays() {
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Pineapple");
        // method 1:
        // List collection sorted in natural order
        Collections.sort(fruits);

        // method 2
        //Note: Arrays.sort( [] array)
       int[] intArr = {3,2,1};
       Object [] strArr= fruits.toArray();
        // difference between toArray() and toArray( T[]): toArray() is instantiating a Objects and not Strings
        // 1. no runtime error:
        //Object [] tSObjectArray = new String[2];  //tSObjectArray is pointing to String array
        //String [] tStringArray = (String[]) tSObjectArray;
        // 2. runtime error:
        //Object [] tSObjectArray = new Object[2];  // tSObjectArray is not pointing to String array
        //String [] tStringArray = (String[]) tSObjectArray;

        Arrays.sort(intArr);
        Arrays.sort(strArr);

        for (int i:intArr) {
            System.out.println(i);
        }
        for (Object str: strArr ) {
            System.out.println(str);
        }

        for (String str : fruits) {
            System.out.println(str);
        }

    }
    static void ArraylistReverseOrder() {
        ArrayList<String> arraylist = new ArrayList<String>();
        arraylist.add("AA");
        arraylist.add("ZZ");
        arraylist.add("CC");
        arraylist.add("FF");

        /*Unsorted List: ArrayList content before sorting*/
        System.out.println("Before Sorting:");
        for(String str: arraylist){
            System.out.println(str);
        }

        /* Sorting in decreasing order*/
        Collections.sort(arraylist, Collections.reverseOrder());

        /* Sorted List in reverse order*/
        System.out.println("ArrayList in descending order:");
        for(String str: arraylist){
            System.out.println(str);
        }

    }
    // sort a collection of a class implementing Comparable interface
    // Person implements Comparable interface
    private static void ArrayListObjectSort1() {
        Person p1 = new Person("Jack",30);
        Person p2 = new Person("Donald",29);
        Person p3 = new Person("Alvin",31);

        List personCollection = new ArrayList();
        personCollection.add(p1);
        personCollection.add(p2);
        personCollection.add(p3);

        System.out.println("Before Sort :"+personCollection);
        // Using Collections
        Collections.sort(personCollection);  // Person class implemented CompareTo() interface already
        System.out.println("After Sort :"+personCollection);

    }

    static void ArrayListObjectSort2() {
            ArrayList<Student> arraylist = new ArrayList<Student>();
            arraylist.add(new Student(223, "Chaitanya", 26));
            arraylist.add(new Student(245, "Rahul", 24));
            arraylist.add(new Student(209, "Ajeet", 32));

            Collections.sort(arraylist);  //? error?
            System.out.println("Sorted with Comparable Interface Implementation using age comparing (ascending):");
            for(Student str: arraylist){
                System.out.println(str);
            }
        Collections.sort(arraylist, Collections.reverseOrder());
        System.out.println("Sorted with Comparable Interface Implementation using age comparing (descending):");
        for(Student str: arraylist){
            System.out.println(str);
        }

        /*Sorting based on Student Name*/
        System.out.println("Student Name Sorting:");
        Collections.sort(arraylist, Student.StuNameComparator);

        for(Student str: arraylist){
            System.out.println(str);
        }

        /* Sorting on Rollno property*/
        System.out.println("RollNum Sorting:");
        Collections.sort(arraylist, Student.StuRollno);
        for(Student str: arraylist){
            System.out.println(str);
        }
    }
}


//Comparable
//1)	Comparable provides a single sorting sequence. In other words, we can sort the collection
//      on the basis of a single element such as id, name, and price.
//2)	Comparable affects the original class, i.e., the actual class is modified. (Implements Comparable <> { @override CompareTo(<>) }
//3)	Comparable provides compareTo() method to sort elements.
//4)	Comparable is present in java.lang package.
//5)	We can sort the list elements of Comparable type by Collections.sort(List) method.
//Comparator
//1)	The Comparator provides multiple sorting sequences. In other words, we can sort the collection
//      on the basis of multiple elements such as id, name, and price etc.
//2)	Comparator doesn't affect the original class, i.e., the actual class is not modified.
//3)	Comparator provides compare() method to sort elements.
//4)	A Comparator is present in the java.util package.
//5)	We can sort the list elements of Comparator type by Collections.sort(List, Comparator) method.
//
class Student implements Comparable <Student> {
    private String studentname;
    private int rollno;
    private int studentage;

    public Student(int rollno, String studentname, int studentage) {
        this.rollno = rollno;
        this.studentname = studentname;
        this.studentage = studentage;
    }

    public String getStudentname() {
        return studentname;
    }
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public int getStudentage() {
        return studentage;
    }
    public void setStudentage(int studentage) {
        this.studentage = studentage;
    }

    @Override
    public int compareTo(Student comparestu) {
        int compareage=((Student)comparestu).getStudentage();
        /* For Ascending order*/
        //return this.studentage-compareage;

        /* For Descending order do like this */
        return compareage-this.studentage;
    }

    /*Comparator for sorting the list by Student Name*/
    public static Comparator<Student> StuNameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getStudentname().toUpperCase();
            String StudentName2 = s2.getStudentname().toUpperCase();

            //ascending order
            return StudentName1.compareTo(StudentName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<Student> StuRollno = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {

            int rollno1 = s1.getRollno();
            int rollno2 = s2.getRollno();

            /*For ascending order*/
            return rollno1-rollno2;

            /*For descending order*/
            //return rollno2-rollno1;
        }};
    @Override
    public String toString() {
        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
    }

}