package com.codes.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Exceptions:
// The main difference between checked and unchecked exception:
// * the checked exceptions are checked at compile-time: IOException, SQLException and ParseException
// * the unchecked exceptions are checked at runtime:
//       Runtime
//       NullPointerException
//       ArrayIndexOutOfBoundsExceptionexception
//       IllegalArgumentException
//Error:
// * VM Error
// * Assertion Error, etc.
public class ExceptionsCheckedUnchecked {
    public static void main(String[] args) {

    }

    public static void CheckedException() throws IOException {
        FileInputStream fis = null;
        //
        // without throws IOException from CheckedException() method or ,
        // using try-catch blocks, this constructor FileInputStream(File filename)
        //  throws FileNotFoundException which is a checked exception
        //
        fis = new FileInputStream("B:/myfile.txt");
        int k;

        /* Method read() of FileInputStream class also throws
         * a checked exception: IOException
         */
        while(( k = fis.read() ) != -1)
        {
            System.out.print((char)k);
        }

        /*The method close() closes the file input stream
         * It throws IOException*/
        fis.close();
    }
// using try-catch block:
// public static void CheckedException() {
//    FileInputStream fis = null;
//	try{
//        fis = new FileInputStream("B:/myfile.txt");
//    }catch(FileNotFoundException fnfe){
//        System.out.println("The specified file is not " +
//                "present at the given path");
//    }
//    int k;
//	try{
//        while(( k = fis.read() ) != -1)
//        {
//            System.out.print((char)k);
//        }
//        fis.close();
//    }catch(IOException ioe){
//        System.out.println("I/O error occurred: "+ioe);
//    }

    // If you compile this code, it would compile successfully.
    // However when you will run it, it would throw ArithmeticException.
    public static void UncheckedException()
    {
        int num1=10;
        int num2=0;
        /*Since I'm dividing an integer with 0
         * it should throw ArithmeticException
         */
        int res=num1/num2;
        System.out.println(res);

        int arr[] ={1,2,3,4,5};
        /* My array has only 5 elements but we are trying to
         * display the value of 8th element. It should throw
         * ArrayIndexOutOfBoundsException
         */
        System.out.println(arr[7]);

        // solution:
        //
//        try{
//            int arr[] ={1,2,3,4,5};
//            System.out.println(arr[7]);
//        }
//        catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("The specified index does not exist " +
//                    "in array. Please correct the error.");
//        }
    }
}
