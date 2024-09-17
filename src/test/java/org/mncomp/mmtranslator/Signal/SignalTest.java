package org.mncomp.mmtranslator.Signal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


 // Unit tests for the Signal class.

class SignalTest {


   //   Tests the constructor with both name and value to ensure it initializes correctly.

    @Test
    void testConstructorWithNameAndValue() {
        Signal signal = new Signal("Signal1", 5);  // Create a Signal with name and value

        assertEquals("Signal1", signal.getSignalName(), "Signal name should be 'Signal1'.");
        assertEquals(5, signal.getValue(), "Signal value should be 5.");
    }

    /**
     * Tests the constructor with only the name to ensure it initializes correctly.
     * The value should default to 0.
     */
    @Test
    void testConstructorWithNameOnly() {
        Signal signal = new Signal("Signal2");  // Create a Signal with only name

        assertEquals("Signal2", signal.getSignalName(), "Signal name should be 'Signal2'.");
        assertEquals(0, signal.getValue(), "Signal value should default to 0.");
    }


    // Tests the setName and getSignalName methods to ensure the name is updated and retrieved correctly.

    @Test
    void testSetNameAndGetSignalName() {
        Signal signal = new Signal("Signal3");  // Create a Signal

        signal.setName("NewSignalName");  // Update the name
        assertEquals("NewSignalName", signal.getSignalName(), "Signal name should be updated to 'NewSignalName'.");
    }


     //Tests the setValue and getValue methods to ensure the value is updated and retrieved correctly.

    @Test
    void testSetValueAndGetValue() {
        Signal signal = new Signal("Signal4");  // Create a Signal

        signal.setValue(10);  // Update the value
        assertEquals(10, signal.getValue(), "Signal value should be updated to 10.");
    }
}