package com.codes.practice;

public class ClassInstanceOf {

    public static void main(String[] args) {
        People objPeople = new People();
        People objBoy = new Boy();

        // As obj is of type person, it is not an
        // instance of Boy or interface
        System.out.println("People obj instanceof Person: "
                + (objPeople instanceof People));
        System.out.println("People obj instanceof Boy: "
                + (objPeople instanceof Boy));
        System.out.println("People obj instanceof MyInterface: "
                + (objPeople instanceof MyInterface));

        // Since obj2 is of type boy,
        // whose parent class is person
        // and it implements the interface Myinterface
        // it is instance of all of these classes
        System.out.println("objBoy instanceof Person: "
                + (objBoy instanceof People));
        System.out.println("objBoy instanceof Boy: "
                + (objBoy instanceof Boy));
        System.out.println("objBoy instanceof MyInterface: "
                + (objBoy instanceof MyInterface));

    }
}

interface MyInterface {
}
class People {
}

class Boy extends People implements MyInterface {
}
