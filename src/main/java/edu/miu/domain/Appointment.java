package edu.miu.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private Long appointmentId;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private Patient patient;

    private Dentist dentist;

    private Surgery surgery;

    public Appointment(Long appointmentId, LocalDate appointmentDate, LocalTime appointmentTime, Patient patient, Dentist dentist, Surgery surgery) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
    }


    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public Surgery getSurgery() {
        return surgery;
    }
}
