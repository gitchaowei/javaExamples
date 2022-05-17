package com.codes.practice;

public class CloneableTest implements Cloneable {
    // student info
    int rollno;
    String name;

    CloneableTest(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String args[]){
        try{
            CloneableTest s1=new CloneableTest(101,"amit");

            CloneableTest s2=(CloneableTest)s1.clone();

            System.out.println(s1.rollno+" "+s1.name);
            System.out.println(s2.rollno+" "+s2.name);
        }
        catch(CloneNotSupportedException c){

        }
    }
}
