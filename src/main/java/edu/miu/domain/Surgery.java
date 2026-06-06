package edu.miu.domain;

public class Surgery {

    private Long surgeryId;
    private String name;
    private String address;
    private String phoneNumber;

    public Surgery(Long surgeryId, String name, String address, String phoneNumber) {
        this.surgeryId = surgeryId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getSurgeryId() {
        return surgeryId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}