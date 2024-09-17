package org.mncomp.mmtranslator.Transition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the Transition class.

class TransitionTest {

    private State fromState;  // Source state for the transition
    private State toState;    // Destination state for the transition
    private Transition transition;  // Instance of Transition for testing

    /**
     * Sets up the test environment.
     * Initializes states and a transition before each test.
     */
    @BeforeEach
    void setUp() {
        fromState = new State("State1", 1);  // Initialize fromState
        toState = new State("State2", 2);    // Initialize toState
        transition = new Transition(0, fromState, toState, "input1", "output1");  // Initialize Transition
    }

    // Tests the constructor to ensure it initializes the ID, states, input, and output signals correctly.

    @Test
    void testConstructor() {
        assertEquals(0, transition.getId(), "Transition ID should be 0.");
        assertEquals(fromState, transition.getFromState(), "From state should be 'State1'.");
        assertEquals(toState, transition.getToState(), "To state should be 'State2'.");
        assertEquals("input1", transition.getInputSignal(), "Input signal should be 'input1'.");
        assertEquals("output1", transition.getOutputSignal(), "Output signal should be 'output1'.");
    }

    // Tests the getId method to ensure it retrieves the correct transition ID.

    @Test
    void testGetId() {
        assertEquals(0, transition.getId(), "Transition ID should be 0.");
    }

    // Tests the getFromState method to ensure it retrieves the correct source state.

    @Test
    void testGetFromState() {
        assertEquals(fromState, transition.getFromState(), "From state should be 'State1'.");
    }

    // Tests the getToState method to ensure it retrieves the correct destination state.

    @Test
    void testGetToState() {
        assertEquals(toState, transition.getToState(), "To state should be 'State2'.");
    }

    //Tests the getInputSignal method to ensure it retrieves the correct input signal.

    @Test
    void testGetInputSignal() {
        assertEquals("input1", transition.getInputSignal(), "Input signal should be 'input1'.");
    }

    //Tests the getOutputSignal method to ensure it retrieves the correct output signal.

    @Test
    void testGetOutputSignal() {
        assertEquals("output1", transition.getOutputSignal(), "Output signal should be 'output1'.");
    }

    //Tests the toKissFormat method to ensure it returns the correctly formatted KISS2 string.

    @Test
    void testToKissFormat() {
        String expectedFormat = "State1 input1 State2 output1";  // Expected KISS2 format
        assertEquals(expectedFormat, transition.toKissFormat(), "KISS2 format should match the expected format.");
    }
}