package com.codes.practice;

import java.io.*;

public class SerializableTransientTest implements Serializable {
    // Normal variables
    int i = 10, j = 20;

    // Transient variables
    transient int k = 30;

    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;

    public static void main(String[] args) throws Exception
    {
        SerializableTransientTest input = new SerializableTransientTest();
        String filename = "file.ser";
        FileOutputStream fos ;
        ObjectOutputStream oos;
        // serialization
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(input);
            fos.close();
            oos.close();
            System.out.println("Object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        FileInputStream fis ;
        ObjectInputStream ois ;

        // de-serialization
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            SerializableTransientTest output = (SerializableTransientTest)ois.readObject();
            fis.close();
            ois.close();
            System.out.println("Object has been deserialized");
            System.out.println("i = " + output.i);
            System.out.println("j = " + output.j);
            System.out.println("k = " + output.k);
            System.out.println("l = " + output.l);
            System.out.println("m = " + output.m);

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
//Output :
//
//i = 10
//j = 20
//k = 0
//l = 40
//m = 50
