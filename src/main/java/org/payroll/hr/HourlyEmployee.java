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
        return hoursWorked*getPayRate();
    }

    public String generatePayStub(String payDate){
        return "\t\t\t" + "\n\t" + "Name: " + this.getName() + " - Employee Id: " + this.getEmployeeID() +
                "\n\t" + "Pay Date \t " + payDate +
                "\n\t" + "Hours \t " + this.hoursWorked +
                "\n\t" + "Total Days Payment $" + this.calculatePay();
    }


}
