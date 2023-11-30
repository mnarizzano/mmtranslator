// Package declaration for the test class
package org.mncomp.mmtranslator.Transition;

// Import statements for required classes and methods 
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Signal.Signal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Transition class.
 */
class TransitionTest {

    /**
     * Test the getId method of the Transition class.
     * It checks if the generated ID for a transition is greater than 0.
     */
    @Test
    void getId() {
        // Arrange: Create a Transition instance
        Transition transition = new Transition();

        // Act: Call the getId method
        int id = transition.getId();

        // Assert: Check if the generated ID is greater than 0
        assertTrue(id > 0);
    }

    /**
     * Test the getStateTo method of the Transition class.
     * It verifies if the getStateTo method returns the correct destination state.
     */
    @Test
    void getStateTo() {
        // Arrange: Create a Transition instance and a destination State
        Transition transition = new Transition();
        State stateTo = new State("ToState", 1);
        transition.setStateTo(stateTo);

        // Act: Call the getStateTo method
        State result = transition.getStateTo();

        // Assert: Check if the returned destination state is as expected
        assertEquals(stateTo, result);
    }

    /**
     * Test the setStateTo method of the Transition class.
     * It ensures that the destination state can be set correctly.
     */
    @Test
    void setStateTo() {
        // Arrange: Create a Transition instance and a destination State
        Transition transition = new Transition();
        State stateTo = new State("ToState", 1);

        // Act: Call the setStateTo method
        transition.setStateTo(stateTo);

        // Assert: Check if the destination state has been set correctly
        assertEquals(stateTo, transition.getStateTo());
    }

    /**
     * Test the getInputSignals method of the Transition class.
     * It validates if the getInputSignals method returns the correct input signal.
     */
    @Test
    void getInputSignals() {
        // Arrange: Create a Transition instance and an input Signal
        Transition transition = new Transition();
        Signal inputSignals = new Signal("InputSignal");
        transition.setInputSignals(inputSignals);

        // Act: Call the getInputSignals method
        Signal result = transition.getInputSignals();

        // Assert: Check if the returned input signal is as expected
        assertEquals(inputSignals, result);
    }

    /**
     * Test the setInputSignals method of the Transition class.
     * It tests if the input signal can be set correctly for a transition.
     */
    @Test
    void setInputSignals() {
        // Arrange: Create a Transition instance and an input Signal
        Transition transition = new Transition();
        Signal inputSignals = new Signal("InputSignal");

        // Act: Call the setInputSignals method
        transition.setInputSignals(inputSignals);

        // Assert: Check if the input signal has been set correctly
        assertEquals(inputSignals, transition.getInputSignals());
    }

    /**
     * Test the getOutputSignals method of the Transition class.
     * It verifies if the getOutputSignals method returns the correct output signal.
     */
    @Test
    void getOutputSignals() {
        // Arrange: Create a Transition instance and an output Signal
        Transition transition = new Transition();
        Signal outputSignals = new Signal("OutputSignal");
        transition.setOutputSignals(outputSignals);

        // Act: Call the getOutputSignals method
        Signal result = transition.getOutputSignals();

        // Assert: Check if the returned output signal is as expected
        assertEquals(outputSignals, result);
    }

    /**
     * Test the setOutputSignals method of the Transition class.
     * It checks if the output signal can be set correctly for a transition.
     */
    @Test
    void setOutputSignals() {
        // Arrange: Create a Transition instance and an output Signal
        Transition transition = new Transition();
        Signal outputSignals = new Signal("OutputSignal");

        // Act: Call the setOutputSignals method
        transition.setOutputSignals(outputSignals);

        // Assert: Check if the output signal has been set correctly
        assertEquals(outputSignals, transition.getOutputSignals());
    }
}
