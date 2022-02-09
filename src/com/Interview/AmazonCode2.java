package com.Interview;

import java.util.*;

// Find the K largest elements from a big file or array.
public class AmazonCode2 {

    public static void main(String[] args) {

        System.out.println("Please enter how many largest numbers: ");
        Scanner sc= new Scanner(System.in);

        int MaxNum = sc.nextInt();

        int [] arrData = {20, 13, 2,69,40,29,70};

        // method 1
        SortedSet <Integer> arrList = new TreeSet<Integer>();

        for (int i=0; i< arrData.length; i++) {
            arrList.add(arrData[i]);
        }
        System.out.println("Sorted Array:");
        Iterator <Integer> iset = arrList.iterator();
        while (iset.hasNext()) {
            System.out.println(iset.next());
        }
        //
        // method 2
        //

        List list = new ArrayList();

        for (int i=0;i<arrData.length;i++) {
            list.add(arrData[i]);
        }

        System.out.println("Initial List: "+list);
        Collections.sort(list);
        System.out.println("Sorted List: "+list);
// reverse sort
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("Reversed Sorted List: "+list);
        //
        // method 3
        //
        Arrays.sort(arrData);
        System.out.println("Sorted Array:");
        for (int i = arrData.length-MaxNum; i < arrData.length; i++)
        {
            System.out.println(arrData[i]);
        }


    }


}
