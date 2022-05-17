package com.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArraysMerge {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    static void example1()
    {
        int firstArray[] = { 11,22,33,44,55,98,76,54,60};
        int secondArray[] = {66,77,88,99,22,67,21,90,80,70};

        int source_arr[], sourcePos, dest_arr[], destPos, len;
        source_arr = firstArray;
        dest_arr = secondArray;
        sourcePos = 2;
        destPos = 4;
        len = 3;
// Print elements of source
        System.out.print("source_array : ");
        for (int i = 0; i < firstArray.length; i++) {
            System.out.print(firstArray[i] + " ");
        }
        System.out.println("");
        System.out.println("sourcePos : " + sourcePos);

// Print elements of destination
        System.out.print("dest_array : ");
        for (int i = 0; i < secondArray.length; i++) {
            System.out.print(secondArray[i] + " ");
        }
        System.out.println("");
        System.out.println("destPos : " + destPos);
        System.out.println("len : " + len);

//invoking arraycopy() method
        System.arraycopy(source_arr, sourcePos, dest_arr,destPos, len);
// Print elements of destination after
        System.out.print("Resultant array : ");
        for (int i = 0; i < secondArray.length; i++)
            System.out.print(secondArray[i] + " ");
    }

    private static void example2() {
        int[] firstArray = {23,45,12,78,4,90,1};        //source array
        int[] secondArray = {77,11,45,88,32,56,3};  //destination array

        int fal = firstArray.length;        //determines length of firstArray
        int sal = secondArray.length;   //determines length of secondArray
        int[] result = new int[fal + sal];  //resultant array of size first array and second array

        System.arraycopy(firstArray, 0, result, 0, fal);
        System.arraycopy(secondArray, 0, result, fal, sal);

        System.out.println(Arrays.toString(result));    //prints the resultant array
    }

    private static void example3() {
            int[] firstArray = {56,78,90,32,67,12}; //initialized array
            int[] secondArray = {11,14,9,5,2,23,15};

            int length = firstArray.length + secondArray.length; //add the length of firstArray into secondArray
            int[] mergedArray = new int[length];    //resultant array
            int pos = 0;
            for (int element : firstArray) //copying elements of secondArray using for-each loop
            {
                mergedArray[pos] = element;
                pos++;              //increases position by 1
            }
            for (int element : secondArray) //copying elements of firstArray using for-each loop
            {
                mergedArray[pos] = element;
                pos++;
            }
            System.out.println(Arrays.toString(mergedArray));   //prints the resultant array
    }
    private static void example4() {

        String str1[] = { "A", "E", "I" };          //source array
        String str2[] = { "O", "U" };               //destination array
        List <String> list = new ArrayList(Arrays.asList(str1)); //returns a list view of an array
//returns a list view of str2 and adds all elements of str2 into list
        list.addAll(Arrays.asList(str2));
        String[] str3 = (String[])list.toArray();         //converting list to array
        System.out.println(Arrays.toString(str3));  //prints the resultant array

    }

    private static void example5() {
        Integer[] firstArray = new Integer[]{13,12,11,6,9,3}; //source array
        Integer[] secondArray = new Integer[]{78,34,56,67,2,11,7}; //destination array
        Integer[] mergedArray = (Integer[]) mergeArray(firstArray,secondArray); //merged array
        System.out.println("Merged array: "+ Arrays.toString(mergedArray));
    }
    // function to merge two arrays
    private static <T> Object[] mergeArray(T[] arr1, T[] arr2)
    {
        return Stream.of(arr1, arr2).flatMap(Stream::of).toArray();
    }
}
