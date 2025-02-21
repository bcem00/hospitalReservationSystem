package test;
import crsystem.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {
    private Hospital hospital;

    @BeforeEach
    void setUp() {
        hospital = new Hospital(1, "Central Hospital");
    }

    @Test
    void testAddSection() {
        Section section = new Section(1, "Radiology");
        hospital.addSection(section);
        assertEquals(1, hospital.getSections().size());
    }

    @Test
    void testGetSectionById_Success() {
        Section section = new Section(1, "Radiology");
        hospital.addSection(section);
        assertEquals(section, hospital.getSection(1));
    }

    @Test
    void testToString() {
        assertTrue(hospital.toString().contains("Central Hospital"));
    }
}
