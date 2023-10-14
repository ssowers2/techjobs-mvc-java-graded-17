package org.launchcode.techjobsmvc.models;

public class Employer extends JobField {

    public Employer(String value) {
        super(value);
    }

    public String getName() {
        return super.getValue(); // This returns the name of the employer (inherited from JobField).
    }
}