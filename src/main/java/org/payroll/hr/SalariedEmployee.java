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

    @Override
    public String toString() {
        return String.format("\n\tName: " + this.getName() +
                "\n\tGross Salary $" + this.salary +
                "\n\tNet Salary $%.2f", calculatePay());

    }

}
