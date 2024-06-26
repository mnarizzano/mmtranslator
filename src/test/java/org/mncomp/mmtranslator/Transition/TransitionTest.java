package org.mncomp.mmtranslator.Transition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransitionTest {

    private State fromState;
    private State toState;
    private Transition transition;

    @BeforeEach
    void setUp() {
        fromState = new State("State1", 1);
        toState = new State("State2", 2);
        transition = new Transition(1, fromState, toState, "inputA", "outputX");
    }

    @Test
    void testConstructor() {
        assertNotNull(transition);
    }

    @Test
    void testGetId() {
        assertEquals(1, transition.getId());
    }

    @Test
    void testGetFromState() {
        assertEquals(fromState, transition.getFromState());
    }

    @Test
    void testGetToState() {
        assertEquals(toState, transition.getToState());
    }

    @Test
    void testGetInputSignal() {
        assertEquals("inputA", transition.getInputSignal());
    }

    @Test
    void testGetOutputSignal() {
        assertEquals("outputX", transition.getOutputSignal());
    }

    @Test
    void testToKissFormat() {
        assertEquals("State1 inputA State2 outputX", transition.toKissFormat());
    }
}
