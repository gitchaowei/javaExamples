package com.codes.practice;

import java.util.*;

// Find the K largest elements from a big file or array.
public class AmazonCode2 {

    public static void main(String[] args) {

        System.out.println("Please enter how many largest numbers: ");
        Scanner sc= new Scanner(System.in);

        int MaxNum = sc.nextInt();

        int [] arrData = {20, 13, 2,69,40,29,70};

        // method 1: use TreeSet
        // Features of a TreeSet:
        //1. TreeSet implements the SortedSet interface. So, duplicate values are not allowed.
        //2. Objects in a TreeSet are stored in a sorted and ascending order.
        //3. TreeSet does not preserve the insertion order of elements but elements are sorted by keys.
        //4. If we are depending on the default natural sorting order, the objects that are being inserted into
        //   the tree should be homogeneous and comparable. TreeSet does not allow the insertion of
        //   heterogeneous objects. It will throw a classCastException at Runtime if we try to add
        //   heterogeneous objects.
        //5. The TreeSet can only accept generic types which are comparable.
        SortedSet <Integer> arrList = new TreeSet<Integer>();

        for (int i=0; i< arrData.length; i++) {
            arrList.add(arrData[i]);
        }
        System.out.println("Sorted Array:");
        Iterator <Integer> iset = arrList.iterator();
        int ii=0;
        while (iset.hasNext()) {
            if (ii >= (arrList.size()-MaxNum) )
                System.out.println(iset.next());
            else
                iset.next();
            ii++;
        }

        //
        // method 2: Use Collections.sort(list)
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
        // method 3: use Arrays.sort(array)
        //
        Arrays.sort(arrData);
        System.out.println("Sorted Array:");
        for (int i = arrData.length-MaxNum; i < arrData.length; i++)
        {
            System.out.println(arrData[i]);
        }
    }
}
