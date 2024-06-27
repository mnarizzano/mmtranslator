package org.mncomp.mmtranslator.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the State class.
 */
public class StateTest {

    private State state;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        state = new State("TestState", 1);
    }

    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        assertNotNull(state);
    }

    /**
     * Tests the getStateName method.
     */
    @Test
    void testGetStateName() {
        assertEquals("TestState", state.getStateName());
    }

    /**
     * Tests the getId method.
     */
    @Test
    void testGetId() {
        assertEquals(1, state.getId());
    }

    /**
     * Tests the getStateNo method.
     */
    @Test
    void testGetStateNo() {
        assertEquals(1, state.getStateNo());
    }

    /**
     * Tests the setName method.
     */
    @Test
    void testSetName() {
        state.setName("NewName");
        assertEquals("NewName", state.getStateName());
    }

    /**
     * Tests the isInit and setInit methods.
     */
    @Test
    void testIsInit() {
        assertFalse(state.isInit());
        state.setInit();
        assertTrue(state.isInit());
        state.unsetInit();
        assertFalse(state.isInit());
    }
}
