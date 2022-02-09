package com.Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntToArrayListExample {
    public static void main(String[] args) {
        // convert int array to Integer ArrayList
        int[] arr = {1, 2, 9, 4, 5, 0};

        List<Integer> list = new ArrayList<>(arr.length);

        for (int i : arr) {
            list.add(Integer.valueOf(i));
        }
        System.out.println(list);

        // convert Integer ArrayList to int array
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);

        for (int x : ret) {
            System.out.print(x + " ");
        }
        System.out.println();
        // or
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(primitive));

        //1. Filter out the null values before mapping:
        //
        //int[] primitive = list.stream()
        //                    .filter(Objects::nonNull)
        //                    .mapToInt(Integer::intValue)
        //                    .toArray();
        //2. Map the null values to a default value:
        //
        //int[] primitive = list.stream()
        //                    .map(i -> (i == null ? 0 : i))
        //                    .mapToInt(Integer::intValue)
        //                    .toArray();
        //3. Handle null inside the lambda expression itself:
        //
        //int[] primitive = list.stream()
        //                    .mapToInt(i -> (i == null ? 0 : i))
        //                    .toArray();
    }
}
