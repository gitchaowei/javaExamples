package com.codes.practice;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class IOStreamInputOutputDemo {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStreamDemo1();
        FileIOStream();
//        ScannerBufferedReader();
//        BufferedReaderFileReader1();
//        BufferedReaderFileReader2();
    }

    public static void ByteArrayInputStreamDemo1() throws IOException
    {
        final String XML_DATA = "<Employee><id>100</id><first>Zara</first><last>Ali</last><Salary>10000</Salary><Dob>18-08-1978</Dob></Employee>";
        int c;
        ByteArrayInputStream bis = new ByteArrayInputStream(XML_DATA.getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        while ((c = bis.read()) != -1) {
            bos.write(c);
        }
        //Print results
        System.out.println(bos.toString());

        //Close input and output stream
        bis.close();
        bos.close();
    }

    public static void FileIOStream() throws IOException {
        FileOutputStream fout1 = new FileOutputStream("D:\\f1.txt");
        FileOutputStream fout2 = new FileOutputStream("D:\\f2.txt");

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write(65);
        bout.writeTo(fout1);
        bout.writeTo(fout2);

        bout.flush();
        bout.close();//has no effect
        System.out.println("Success...");
    }

    // Scanner:
    // Scanner class is a simple text scanner that can parse primitive types and strings.
    // There is no need to close the scanner.
    // Not closing might generate some warnings although.
    // As soon as the block in which you defined Scanner object is over,
    // the garbage collection does your job for you.
    //
    // BufferedReader:
    // BufferedReader class reads text from a character-input stream, buffering characters
    // for the efficient reading of the sequence of characters
    private static void ScannerBufferedReader() throws IOException {

        // Scanner to read input from keyboard
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter an integer");

        // Using nextInt() to parse integer values
        int a = scn.nextInt();
//        long mobileNo = scn.nextLong();
//        double cgpa = scn.nextDouble();

        System.out.println("Enter a String");

        // Using nextLine() to parse string values
        String b = scn.nextLine();
        // Character input
        char c = scn.next().charAt(0);
        // Display name and age entered above
        System.out.printf("You have entered:- " + a + " "
                + "and name as " + b + " Char " + c);

        // BufferedReader
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter an integer");

        // Taking integer input
        int i = Integer.parseInt(br.readLine());

        System.out.println("Enter a String");

        String s = br.readLine();

        // Printing input entities above
        System.out.printf("You have entered:- " + i
                + " and name as " + s);
    }

    // When finished reading characters from the BufferedReader,remember to close it.
    // Closing a BufferedReader will also close the Reader instance from which
    // the BufferedReader is reading.
    private static void BufferedReaderFileReader1() throws IOException {
        FileReader reader;

        // Try block to check exceptions
        try {
            // A Reader that reads creates an input character stream
            // and reads characters from it
            reader = new FileReader("geeks.txt");

            // Creating a BufferedReader object (instance)
            // that 16Kb in buffer in the memory
            BufferedReader buffer = new BufferedReader(reader, 16384);

            // A string to store the lines
            String line = "";

            // Maintaining real time count using
            // currentTimeMillis() method to get time taken
            // to read the data
            long initialTime = System.currentTimeMillis();
            while (true) {
                // Try block to check exceptions
                try {
                    // readLine() method of BufferedReader
                    // returns
                    //  a whole line at a time
                    line = buffer.readLine();
                }
                // Catch block to handle exceptions
                catch (IOException e) {
                    // Print the line where exception
                    // occurred
                    e.printStackTrace();
                }

                // When the read head reaches the "End Of File"
                // the readLine method returns null
                if (line == null)
                    break;

                // Prints the line
                System.out.println(line);
            }

            // New line
            System.out.println();

            // Display the time taken to read the data
            System.out.println("Time taken : "
                    + (System.currentTimeMillis()
                    - initialTime));

            // Try block to check exceptions
            try {
                // Close all the streams
                buffer.close();
                reader.close();
            }
            // Catching only exceptions those occurred
            // only during closing streams
            catch (IOException e) {
                // Prints the line number where exception occurred
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) { // Catch block
            // print the exception only if the file not found
            e.printStackTrace();
        }
    }

    // Reading lines using only the FileReader
    private static void BufferedReaderFileReader2() throws IOException {
        FileReader reader;

        // Try block to check if exception occured
        try {

            // A FileReader to read data from "geeks.txt"
            // File present in local directory
            reader = new FileReader("geeks.txt");

            char ch;

            // An integer to store the integer
            // returned by FileReader#read() method
            int i = -1;

            // Stores the initial current time
            long initialTime = System.currentTimeMillis();
            while (true) {
                try {
                    // The read() method of FileReader
                    // reads one character at a time
                    // and returns it as an integer
                    i = reader.read();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                // When the "End Of File" is reached
                // the read() method returns -1
                if (i == -1)
                    break;

                ch = (char)i;
                System.out.print(ch);
            }

            // New line
            System.out.println();

            // Display and print the time taken
            System.out.println("Time taken : "
                    + (System.currentTimeMillis()
                    - initialTime));

            try {
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}