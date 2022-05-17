package com.codes.practice.DesignPatterns.Structral;

// ProxyInternetAccess is to control user authority for access
// OfficeInternetAccess is to access
public class ProxyDemo {

    public static void main(String[] args){

        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput");
        access.grantInternetAccess();
    }
}


interface OfficeInternetAccess {
    public void grantInternetAccess();
}
class RealInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    public RealInternetAccess(String empName) {
        this.employeeName = empName;
    }

    @Override
    public void grantInternetAccess() {
        System.out.println(" \n Internet Access granted for employee: "+ employeeName);
    }
}

class ProxyInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    private RealInternetAccess  realaccess;

    public ProxyInternetAccess(String employeeName)
    {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess()
    {
        if (getRole(employeeName) > 4)
        {
            realaccess = new RealInternetAccess(employeeName);
            realaccess.grantInternetAccess();
        }
        else
        {
            System.out.println("No Internet access granted. Your job level is below 5");
        }

    }

    public int getRole(String emplName) {
        // Check role from the database based on Name and designation
        // return job level or job designation.
        // return 5; now change the job level
        return 2;
    }
}
