package edu.miu.domain;

public class Dentist {

    private Long dentistId;
    private String firstName;
    private String lastName;

    public Dentist(Long dentistId, String firstName, String lastName) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}