package org.payroll.hr;


public abstract class Employee {

    private String name;
    private double payRate;
    private int EMPLOYEE_ID;
    private Address address;
    private final int nextID = 1000;
    private final double STARTING_PAY_RATE =7.75;

    public Employee(String name){
        this.name=name;
        this.payRate=0;

    }

    public Employee(String name, double payRate){
        this.name=name;
        this.payRate=payRate;
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

    public final int getNextID(){
        return nextID;
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

    }

}
