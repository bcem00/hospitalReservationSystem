package test;
import crsystem.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person = new Patient("Jane Doe", 123456789L);

    @Test
    void testGetNationalId() {
        assertEquals(123456789L, person.getNationalId());
    }

    @Test
    void testToString() {
        assertTrue(person.toString().contains("Jane Doe"));
    }
}
