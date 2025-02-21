
package test;
import crsystem.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient("Alice", 111222333L);
    }

    @Test
    void testGetName() {
        assertEquals("Alice", patient.getName());
    }

    @Test
    void testToString() {
        assertTrue(patient.toString().contains("Alice"));
    }
}
