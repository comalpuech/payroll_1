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

    public double calculatePay(){
        return 0;
    }

    public String generatePayStub(String s){
        return "";
    }


    public String toString() {
        return "\t\t\t" + "\n\t" + "Name: " + this.getName() +
                "\n\t" + "Hours \t " + this.hoursWorked +
                "\n\t" + "Total Days Payment $" + this.calculatePay();
    }


}
