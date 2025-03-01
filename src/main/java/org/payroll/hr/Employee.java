package org.payroll.hr;


public abstract class Employee implements Payable {

    private String name;
    private double payRate;
    private final int EMPLOYEE_ID;
    private Address address;
    private static int nextID = 1000;
    private final static double STARTING_PAY_RATE =7.75;

    public Employee(String name){
        this.name = name;
        EMPLOYEE_ID = getNextID();
        payRate = STARTING_PAY_RATE;
    }

    public Employee(String name, double payRate){
        this.name = name;
        this.payRate = payRate;
        EMPLOYEE_ID = getNextID();
    }



    public String getName(){
        return name;
    }

    public int getEmployeeID(){
        return EMPLOYEE_ID;
    }

    public double getPayRate(){
        return payRate;
    }

    public void displayAddress(){
        this.address.toString();
    }

    public static int getNextID(){
        int id = nextID;
        nextID++;
        return id;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPayRate(double payRate){
        this.payRate=payRate;
    }


    @Override
    public String toString(){
        return "Employee ID - " + this.EMPLOYEE_ID + "\nName - " +this.name + "\n" + this.address.toString();
    }

}
