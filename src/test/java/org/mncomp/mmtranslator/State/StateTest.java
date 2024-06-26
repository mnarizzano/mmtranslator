package org.mncomp.mmtranslator.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    private State state;

    @BeforeEach
    void setUp() {
        state = new State("TestState", 1);
    }

    @Test
    void testConstructor() {
        assertNotNull(state);
    }

    @Test
    void testGetStateName() {
        assertEquals("TestState", state.getStateName());
    }

    @Test
    void testGetId() {
        assertEquals(1, state.getId());
    }

    @Test
    void testGetStateNo() {
        assertEquals(1, state.getStateNo());
    }

    @Test
    void testSetName() {
        state.setName("NewName");
        assertEquals("NewName", state.getStateName());
    }

    @Test
    void testIsInit() {
        assertFalse(state.isInit());
        state.setInit();
        assertTrue(state.isInit());
        state.unsetInit();
        assertFalse(state.isInit());
    }
}
