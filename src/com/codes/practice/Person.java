package com.codes.practice;

public class Person implements Comparable{

        private String name;
        private int age;

        public Person(String strName, int iAge){
            this.name = strName;
            this.age = iAge;
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }

        public void setName(String strName){
            this.name = strName;
        }

        public void setAge(int iAge){
            this.age = iAge;
        }

        public String toString(){
            return this.name;
        }

        // Compare method
        public int compareTo(Object obj){
            return this.getName().compareTo(((Person) obj).getName());
        }
    }
