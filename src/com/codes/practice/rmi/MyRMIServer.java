package com.codes.practice.rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// The RMI (Remote Method Invocation) is an API that provides a mechanism
// to create distributed application in java.
// The RMI allows an object to invoke methods on an object running in another JVM.
public class MyRMIServer {
    public static void main(String args[])throws Exception{
        Remote r=new BankImpl();
        Naming.rebind("rmi://localhost:6666/javatpoint",r);
    }
}
interface BankRMI extends Remote{
    public List<Customer> getCustomers()throws RemoteException;
}
class BankImpl extends UnicastRemoteObject implements BankRMI {
    BankImpl()throws RemoteException {}

    public List<Customer> getCustomers(){
        List<Customer> list=new ArrayList<Customer>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            PreparedStatement ps=con.prepareStatement("select * from customer400");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Customer c=new Customer();
                c.setAcc_no(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAmount(rs.getFloat(5));
                list.add(c);
            }

            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }//end of getCustomers()
}

class Customer implements java.io.Serializable{
    private int acc_no;
    private String firstname,lastname,email;
    private float amount;

    public int getAcc_no() {
        return acc_no;
    }
    public void setAcc_no(int accNo) {
        acc_no = accNo;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
