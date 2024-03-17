
import static org.junit.Assert.*;

/*
 * Class: CMSC203-32689
 * Instructor: Professor Grigoriy Grinberg
 * Description: A Cryptography Encode/Decode
 * Due: 03/16/2024
 * Platform/compiler:Java Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Min Hein Khant
*/

/**
 * This class represents the JUNIT tests for CryptoManager.
 * 
 * @author Min Hein Khant
 * @version 3/17/2024
 * 
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {

    @BeforeEach
    public void setUp() throws Exception {
        // Setup before each test, if needed
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Cleanup after each test, if needed
    }

    @Test
    public void testStringOutOfBounds() {
        assertFalse(CryptoManager.isStringInBounds("Unterstützung")); // German, contains characters outside the ASCII range
        assertFalse(CryptoManager.isStringInBounds("猫はかわいいです")); // Japanese, non-ASCII
        assertFalse(CryptoManager.isStringInBounds("1234567890")); // Numeric, test if these are within bounds
    }

    @Test
    public void testCaesarEncryptionErrors() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("cats", 5));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("Unterstützung", 3));
    }

    @Test
    public void testBellasoEncryptionErrors() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("Überraschung", "SECRET"));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("😊", "SMILE"));
    }

    @Test
    public void testCaesarDecryptionErrors() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("cats", 5));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("Unterstützung", 3));
    }

    @Test
    public void testBellasoDecryptionErrors() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("Überraschung", "SECRET"));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("😊", "SMILE"));
    }
}
