package org.launchcode.techjobsmvc.models;

public class Location extends JobField {
    private String name; // Add a name property

    public Location(String value) {
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
