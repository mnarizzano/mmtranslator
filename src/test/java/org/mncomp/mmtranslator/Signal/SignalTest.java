package org.mncomp.mmtranslator.Signal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignalTest {

    private Signal signal;

    @BeforeEach
    void setUp() {
        signal = new Signal("TestSignal", 42);
    }

    @Test
    void testConstructorWithValue() {
        assertNotNull(signal);
        assertEquals("TestSignal", signal.getSignalName());
        assertEquals(42, signal.getValue());
    }

    @Test
    void testConstructorWithoutValue() {
        Signal signalWithoutValue = new Signal("SignalWithoutValue");
        assertNotNull(signalWithoutValue);
        assertEquals("SignalWithoutValue", signalWithoutValue.getSignalName());
        assertEquals(0, signalWithoutValue.getValue()); // Default value should be 0
    }

    @Test
    void testGetSignalName() {
        assertEquals("TestSignal", signal.getSignalName());
    }

    @Test
    void testSetName() {
        signal.setName("NewName");
        assertEquals("NewName", signal.getSignalName());
    }

    @Test
    void testGetValue() {
        assertEquals(42, signal.getValue());
    }

    @Test
    void testSetValue() {
        signal.setValue(100);
        assertEquals(100, signal.getValue());
    }
}
