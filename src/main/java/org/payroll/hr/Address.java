package org.payroll.hr;

public class Address {

    private String street;
    private String city;
    private String postCode;
    private String state;

    public Address(String street,String city, String postCode, String state ){
        this.state=state;
        this.city=city;
        this.street=street;
        this.postCode=postCode;
    }

    @Override

    public String toString(){
        System.out.println("Street: "+street);
        System.out.println("City: "+city);
        System.out.println("Post Code: "+postCode);
        System.out.println("State: "+state);
    }




}
