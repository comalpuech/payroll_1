package org.payroll.hr;

public class Contractor implements Payable{

    private double partsCost;
    private int hoursWorked;
    private String name;

    public Contractor(String n, int h, double p){
        partsCost=p;
        hoursWorked=h;
        name=n;
    }

    public void setPartsCost(double partsCost){
        this.partsCost=partsCost;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked=hoursWorked;
    }

    public double calculatePay() {
        return 0;
    }


    public String generatePayStub(String s){
        return "";
    }

    @Override
    public String toString() {
        return"Name: " + this.name +"\nHours Worked: " + this.hoursWorked + "\nParts : " + this.partsCost;
    }

}



