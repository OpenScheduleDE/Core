package de.openschedule.core.config;

public class Address {

    public String addressee;
    public String addition;
    public String street;
    public String zip;
    public String city;

    public Address() {
    }

    public Address(String addressee, String street, String zip, String city) {
        this.addressee = addressee;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public Address(String addressee, String addition, String street, String zip, String city) {
        this.addressee = addressee;
        this.addition = addition;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
