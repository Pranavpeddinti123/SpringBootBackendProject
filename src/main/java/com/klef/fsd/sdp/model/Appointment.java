package com.klef.fsd.sdp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status = "Pending"; // default value

    @Column(nullable = false)
    private String doctorId;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String speciality;

    @Column(nullable = false)
    private String slotTime; // Example: "10:30 AM"

    @Column(nullable = false)
    private LocalDateTime slotDateTime; // Full date and time

    // Constructors
    public Appointment() {
        // Default constructor
    }

    public Appointment(String doctorId, String doctorName, String speciality, String slotTime, LocalDateTime slotDateTime) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.slotTime = slotTime;
        this.slotDateTime = slotDateTime;
        this.status = "Pending";
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public LocalDateTime getSlotDateTime() {
        return slotDateTime;
    }

    public void setSlotDateTime(LocalDateTime slotDateTime) {
        this.slotDateTime = slotDateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", slotTime='" + slotTime + '\'' +
                ", slotDateTime=" + slotDateTime +
                '}';
    }
}
