package test;

import crsystem.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = new Doctor("Dr. Smith", 987654321L, 1234);
    }

    @Test
    void testGetDiplomaId() {
        assertEquals(1234, doctor.getDiplomaId());
    }

    @Test
    void testSetSchedule() {
        Schedule newSchedule = new Schedule(5);
        doctor.setSchedule(newSchedule);
        assertEquals(newSchedule, doctor.getSchedule());
    }

    @Test
    void testToString() {
        assertTrue(doctor.toString().contains("Dr. Smith"));
    }
}
