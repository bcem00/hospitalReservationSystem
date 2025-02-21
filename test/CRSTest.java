package test;

import crsystem.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class CRSTest {
    private CRS crs;

    @BeforeEach
    void setUp() {
        crs = new CRS();
    }

    @Test
    void testAddPatient_Success() {
        Patient patient = new Patient("John Doe", 123456789L);
        crs.addPatient(patient);
        assertEquals(patient, crs.getPatient(123456789L));
    }

    @Test
    void testAddHospital_Success() {
        Hospital hospital = new Hospital(1, "City Hospital");
        crs.addHospital(hospital);
        assertEquals(hospital, crs.getHospital(1));
    }

    @Test
    void testMakeRendezvous_Success() {
        Patient patient = new Patient("Jane Doe", 111111111L);
        crs.addPatient(patient);
        Hospital hospital = new Hospital(1, "General Hospital");
        crs.addHospital(hospital);

        Section section = new Section(1, "Orthopedics");
        hospital.addSection(section);
        Doctor doctor = new Doctor("Dr. Williams", 987654321L, 1001);
        section.addDoctor(doctor);

        Date appointmentDate = new Date();
        assertTrue(crs.makeRendezvous(1, 111111111L, 1, 1001, appointmentDate));
    }

    @Test
    void testListHospitals() {
        crs.addHospital(new Hospital(1, "Hospital A"));
        crs.addHospital(new Hospital(2, "Hospital B"));
        String result = crs.listHospitals();
        assertTrue(result.contains("Hospital A") && result.contains("Hospital B"));
    }

    @Test
    void testLoadFromFile() throws Exception {
        crs.saveToFile("test.ser");
        CRS newCRS = new CRS();
        newCRS.loadFromFile("test.ser");
        assertEquals(crs.getHospitals().size(), newCRS.getHospitals().size());
    }
}
