package org.payroll.hr;

public class Company {

    private String name;
    private Address address;

    public Company(String name, Address address){
        this.name=name;
        this.address=address;
    }

    public String getAddress(){
        return name;
    }

    public void printAddress(){
        this.address.toString();
    }

}
