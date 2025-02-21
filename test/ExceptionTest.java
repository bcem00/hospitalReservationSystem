package test;

import crsystem.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    @Test
    void testDuplicateInfoException() {
        Exception exception = assertThrows(DuplicateInfoException.class, () -> {
            throw new DuplicateInfoException("Duplicate entry!");
        });
        assertEquals("Duplicate entry!", exception.getMessage());
    }


    @Test
    void testIDException() {
        Exception exception = assertThrows(IDException.class, () -> {
            throw new IDException("Invalid ID!");
        });
        assertEquals("Invalid ID!", exception.getMessage());
    }
}
