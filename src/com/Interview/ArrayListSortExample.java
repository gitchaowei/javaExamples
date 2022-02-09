package com.Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class ArrayListSortExample {
    public static void main(String[] args) {
        ArraylistNaturalOrder();
       // ArraylistReverseOrder();
       // ArrayListObjectSort();
    }
    static void ArraylistNaturalOrder() {
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

    static void ArrayListObjectSort() {
            ArrayList<Student> arraylist = new ArrayList<Student>();
            arraylist.add(new Student(223, "Chaitanya", 26));
            arraylist.add(new Student(245, "Rahul", 24));
            arraylist.add(new Student(209, "Ajeet", 32));

//            Collections.sort(arraylist);  //? error?

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

class Student implements Comparable {
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
        return this.studentage-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
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