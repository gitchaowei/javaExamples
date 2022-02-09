package com.Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortObject {

    public static void main(String args[]){
        Person p1 = new Person("Jack",30);
        Person p2 = new Person("Donald",29);
        Person p3 = new Person("Alvin",31);

        List personCollection = new ArrayList();
        personCollection.add(p1);
        personCollection.add(p2);
        personCollection.add(p3);

        System.out.println("Before Sort :"+personCollection);
        // Using Collections
        Collections.sort(personCollection);
        System.out.println("After Sort :"+personCollection);
    }

}
