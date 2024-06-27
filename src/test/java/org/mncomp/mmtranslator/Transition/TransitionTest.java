package org.mncomp.mmtranslator.Transition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Transition class.
 */
public class TransitionTest {

    private State fromState;
    private State toState;
    private Transition transition;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        fromState = new State("State1", 1);
        toState = new State("State2", 2);
        transition = new Transition(1, fromState, toState, "inputA", "outputX");
    }

    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        assertNotNull(transition);
    }

    /**
     * Tests the getId method.
     */
    @Test
    void testGetId() {
        assertEquals(1, transition.getId());
    }

    /**
     * Tests the getFromState method.
     */
    @Test
    void testGetFromState() {
        assertEquals(fromState, transition.getFromState());
    }

    /**
     * Tests the getToState method.
     */
    @Test
    void testGetToState() {
        assertEquals(toState, transition.getToState());
    }

    /**
     * Tests the getInputSignal method.
     */
    @Test
    void testGetInputSignal() {
        assertEquals("inputA", transition.getInputSignal());
    }

    /**
     * Tests the getOutputSignal method.
     */
    @Test
    void testGetOutputSignal() {
        assertEquals("outputX", transition.getOutputSignal());
    }

    /**
     * Tests the toKissFormat method.
     */
    @Test
    void testToKissFormat() {
        assertEquals("State1 inputA State2 outputX", transition.toKissFormat());
    }
}
