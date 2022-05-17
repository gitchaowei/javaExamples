package com.codes.practice;

import java.text.NumberFormat;
import java.util.*;

public class CalcBestPerformance {
    public static void main(String[] args) {
        Map <Integer, List> mapList = new TreeMap<>();

        List<Boolean> list1 = new ArrayList<>();
        list1.add(true);
        list1.add(true);
        list1.add(true);
        list1.add(true);
        list1.add(true);
        list1.add(false);
        list1.add(false);
        mapList.put(0,list1);
        System.out.println(list1);

        List<Boolean> list2 = new ArrayList<>();
        list2.add(true);
        list2.add(true);
        list2.add(true);
        list2.add(false);
        mapList.put(1,list2);
        System.out.println(list2);

        List<Boolean> list3 = new ArrayList<>();
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(false);
        list3.add(false);
        mapList.put(2,list3);
        System.out.println(list3);

        List<Boolean> list4 = new ArrayList<>();
        list4.add(true);
        list4.add(true);
        list4.add(true);
        list4.add(true);
        list4.add(true);
        list4.add(true);
        list4.add(false);
        list4.add(false);
        mapList.put(3,list4);
        System.out.println(list4);

        double maxPC = 0.0;
        for (Map.Entry <Integer, List> entry : mapList.entrySet() ) {
            List listTemp;
            listTemp = entry.getValue();
            int listSize = listTemp.size();
            int trueSize = 0;
            double PC;

            for (Object b : listTemp) {
                if (b.equals(true))
                    trueSize = trueSize + 1;
            }
            PC = (double) trueSize/listSize;
            System.out.println(String.format("Percentage of TRUE size: %.2f", PC));
            // or
            //System.out.printf("Percentage of TRUE size: %.2f", PC);

            if (maxPC < PC) maxPC = PC;
        }

        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(1);
        System.out.println("Maximum percentage of successful tests: " + defaultFormat.format(maxPC));
        //System.out.println(String.format("Maximum percentage of successful tests: %.2f", maxPC));
    }

}
