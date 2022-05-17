package com.codes.practice.DesignPatterns.Structral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeDemo2 {
    public static void main(String args[]){
        BankEmployee emp1=new Cashier(101,"Sohan Kumar", 20000.0);
        BankEmployee emp2=new Cashier(102,"Mohan Kumar", 25000.0);
        BankEmployee emp3=new Accountant(103,"Seema Mahiwal", 30000.0);
        BankManager manager1=new BankManager(100,"Ashwani Rajput",100000.0);

        manager1.add(emp1);
        manager1.add(emp2);
        manager1.add(emp3);
        manager1.print();
    }
}

// this is the Employee interface i.e. Component.
interface BankEmployee {
    public  int getId();
    public String getName();
    public double getSalary();
    public void print();

}// End of the Employee interface.


// this is the BankManager class i.e. Composite.
class BankManager implements BankEmployee {
    private int id;
    private String name;
    private double salary;
    List<BankEmployee> employees = new ArrayList<BankEmployee>();

    public BankManager(int id,String name,double salary) {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }

    public void add(BankEmployee employee) {
        employees.add(employee);
    }
    public BankEmployee getChild(int i) {
        return employees.get(i);
    }
    public void remove(BankEmployee employee) {
        employees.remove(employee);
    }
    @Override
    public int getId()  {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("==========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("==========================");

        Iterator<BankEmployee> it = employees.iterator();

        while(it.hasNext())  {
            BankEmployee employee = it.next();
            employee.print();
        }
    }
}// End of the BankManager class.
class Cashier implements BankEmployee {
    /*
         In this class,there are many methods which are not applicable to cashier because
         it is a leaf node.
     */
    private int id;
    private String name;
    private double salary;
    public Cashier(int id,String name,double salary)  {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("==========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("==========================");
    }
}

class Accountant implements BankEmployee {
    /*
        In this class,there are many methods which are not applicable to cashier because
        it is a leaf node.
    */
    private int id;
    private String name;
    private double salary;
    public Accountant(int id,String name,double salary)  {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("=========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("=========================");
    }
}