// Package declaration for the test class
package org.mncomp.mmtranslator.Signal;

// Import statements for required classes and methods
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Signal class.
 */
class SignalTest {

    /**
     * Test the getSignalName method of the Signal class.
     */
    @Test
    void getSignalName() {
        // Arrange: Create a Signal instance with a specific name
        Signal signal = new Signal("ExampleSignal");

        // Act: Call the getSignalName method and check the result
        assertEquals("ExampleSignal", signal.getSignalName());
    }

    /**
     * Test the setName method of the Signal class.
     */
    @Test
    void setName() {
        // Arrange: Create a Signal instance with an initial name
        Signal signal = new Signal("InitialSignal");

        // Act: Call the setName method to update the name
        signal.setName("UpdatedSignal");

        // Assert: Check if the name has been updated
        assertEquals("UpdatedSignal", signal.getSignalName());
    }
}
