package com.codes.practice.rmi;

import java.rmi.Naming;
import java.util.List;

// The RMI (Remote Method Invocation) is an API that provides a mechanism
// to create distributed application in java.
// The RMI allows an object to invoke methods on an object running in another JVM.
public class MyRMIClient {
    public static void main(String args[])throws Exception{
        BankRMI b=(BankRMI) Naming.lookup("rmi://localhost:6666/javatpoint");

        List<Customer> list=b.getCustomers();
        for(Customer c:list){
            System.out.println(c.getAcc_no()+" "+c.getFirstname()+" "+c.getLastname()+" "+c.getEmail()+" "+c.getAmount());
        }
    }
}
