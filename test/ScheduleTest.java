package test;
import crsystem.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ScheduleTest {
    private Schedule schedule;

    @BeforeEach
    void setUp() {
        schedule = new Schedule(2);
    }

    @Test
    void testAddRendezvous_Success() {
        Doctor doctor = new Doctor("Dr. Max", 123456L, 1111);
        Patient patient = new Patient("John", 999999999L);
        Date date = new Date();
        assertTrue(schedule.addRendezvous(patient, date, doctor));
    }

    @Test
    void testAddRendezvous_Fail_MaxPatients() {
        Doctor doctor = new Doctor("Dr. Max", 123456L, 1111);
        Date date = new Date();
        schedule.addRendezvous(new Patient("John1", 1L), date, doctor);
        schedule.addRendezvous(new Patient("John2", 2L), date, doctor);
        assertFalse(schedule.addRendezvous(new Patient("John3", 3L), date, doctor));
    }
}
