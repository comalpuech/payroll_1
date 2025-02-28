package org.payroll.hr;

public class HourlyEmployee extends Employee {


    private int hoursWorked = 0;

    public HourlyEmployee(String name){
        super(name);
    }

    public HourlyEmployee(String name, int hoursWorked){
        super(name);
        this.hoursWorked=hoursWorked;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked=hoursWorked;
    }


}
