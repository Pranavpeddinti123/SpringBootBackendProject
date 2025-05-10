package com.klef.fsd.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.sdp.model.Appointment;
import com.klef.fsd.sdp.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(String doctorId) {
        return appointmentRepository.findAll()
                .stream()
                .filter(a -> a.getDoctorId().equals(doctorId))
                .toList();
    }

    // ✅ Method to update appointment status (e.g., Accept or Reject)
    @Override
    public Appointment updateAppointmentStatus(Long id, String status) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        if (optional.isPresent()) {
            Appointment appointment = optional.get();
            appointment.setStatus(status);
            return appointmentRepository.save(appointment);
        }
        return null;
    }
}
