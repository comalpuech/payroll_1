package org.payroll.hr;


public abstract class Employee  {

    private String name;
    private double payRate;
    private int EMPLOYEE_ID;
    private final int nextID = 1000;
    private final double STARTING_PAY_RATE =7.75;

    public Employee(String name){
        this.name=name;
        this.payRate=0;

    }

}
