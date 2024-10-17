package com.test;

public class Address {
    String city;
    String Street;
    int pincode;

    public Address(String city, String street, int pincode) {
        this.city = city;
        Street = street;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", Street='" + Street + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
