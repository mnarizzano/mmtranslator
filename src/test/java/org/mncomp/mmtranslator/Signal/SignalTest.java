package org.mncomp.mmtranslator.Signal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Signal class.
 */
public class SignalTest {

    private Signal signal;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        signal = new Signal("TestSignal", 42);
    }

    /**
     * Tests the constructor with value.
     */
    @Test
    void testConstructorWithValue() {
        assertNotNull(signal);
        assertEquals("TestSignal", signal.getSignalName());
        assertEquals(42, signal.getValue());
    }

    /**
     * Tests the constructor without value.
     */
    @Test
    void testConstructorWithoutValue() {
        Signal signalWithoutValue = new Signal("SignalWithoutValue");
        assertNotNull(signalWithoutValue);
        assertEquals("SignalWithoutValue", signalWithoutValue.getSignalName());
        assertEquals(0, signalWithoutValue.getValue()); // Default value should be 0
    }

    /**
     * Tests the getSignalName method.
     */
    @Test
    void testGetSignalName() {
        assertEquals("TestSignal", signal.getSignalName());
    }

    /**
     * Tests the setName method.
     */
    @Test
    void testSetName() {
        signal.setName("NewName");
        assertEquals("NewName", signal.getSignalName());
    }

    /**
     * Tests the getValue method.
     */
    @Test
    void testGetValue() {
        assertEquals(42, signal.getValue());
    }

    /**
     * Tests the setValue method.
     */
    @Test
    void testSetValue() {
        signal.setValue(100);
        assertEquals(100, signal.getValue());
    }
}
