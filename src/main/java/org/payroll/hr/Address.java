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

    public String toString() {
        return "Street: " + this.street
                +"\nCity: " + this.city
                +"\nState: " + this.state
                +"\npostCode: " + this.postCode;
    }

}





