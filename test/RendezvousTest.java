package test;

import crsystem.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class RendezvousTest {
    private Rendezvous rendezvous;
    private Patient patient;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        patient = new Patient("John Doe", 123456789L);
        doctor = new Doctor("Dr. Alice", 987654321L, 5555);
        rendezvous = new Rendezvous(new Date(), patient, doctor);
    }

    @Test
    void testGetPatient() {
        assertEquals(patient, rendezvous.getPatient());
    }

    @Test
    void testGetDoctor() {
        assertEquals(doctor, rendezvous.getDoctor());
    }
}
