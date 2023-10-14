package org.launchcode.techjobsmvc.models;

public class CoreCompetency extends JobField {
    private String name; // Add a name property

    public CoreCompetency(String value) {
        super(value);
    }

    // Create a getter for the name property
    public String getName() {
        return name;
    }

    // Create a setter for the name property if needed
    public void setName(String name) {
        this.name = name;
    }
}