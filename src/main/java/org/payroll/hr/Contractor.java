package org.payroll.hr;

public class Contractor implements Payable{

    private double partsCost;
    private int hoursWorked;
    private String name;

    public Contractor(String n, double p, int h){
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

    @Override
    public String toString() {
        return"Name: " + this.name +"\nHours Worked: " + this.hoursWorked + "\nParts : " + this.partsCost;
    }

}



}