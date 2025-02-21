package test;
import crsystem.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SectionTest {
    private Section section;

    @BeforeEach
    void setUp() {
        section = new Section(1, "Pediatrics");
    }

    @Test
    void testAddDoctor() {
        Doctor doctor = new Doctor("Dr. Sam", 222333444L, 5678);
        section.addDoctor(doctor);
        assertEquals(1, section.getDoctorCount());
    }

    @Test
    void testListDoctors() {
        section.addDoctor(new Doctor("Dr. Chris", 333444555L, 9999));
        assertTrue(section.listDoctors().contains("Dr. Chris"));
    }
}
