package org.payroll.hr;


public class SalariedEmployee extends Employee{

    private double salary;

    public SalariedEmployee(String name){
        super(name);
    }

    public SalariedEmployee(String name, double salary){
        super(name);
        this.salary=salary;
    }

}
