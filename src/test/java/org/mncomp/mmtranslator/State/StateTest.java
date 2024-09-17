package org.mncomp.mmtranslator.State;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Unit tests for the State class.

class StateTest {


    //Tests the constructor to ensure it initializes the name, ID, and initialization status correctly.

    @Test
    void testConstructor() {
        State state = new State("State1", 1);  // Create a State with name and ID

        assertEquals("State1", state.getStateName(), "State name should be 'State1'.");
        assertEquals(1, state.getId(), "State ID should be 1.");
        assertFalse(state.isInit(), "State should not be initialized by default.");
    }


     // Tests the getStateName and setName methods to ensure the name is retrieved and updated correctly.

    @Test
    void testSetNameAndGetStateName() {
        State state = new State("State1", 1);  // Create a State

        state.setName("NewStateName");  // Update the state name
        assertEquals("NewStateName", state.getStateName(), "State name should be updated to 'NewStateName'.");
    }


     // Tests the getId method to ensure the ID is retrieved correctly.

    @Test
    void testGetId() {
        State state = new State("State1", 1);  // Create a State

        assertEquals(1, state.getId(), "State ID should be 1.");
    }


    // Tests the getStateNo method to ensure it returns the correct state number (ID).

    @Test
    void testGetStateNo() {
        State state = new State("State1", 1);  // Create a State

        assertEquals(1, state.getStateNo(), "State number should be the same as the ID, which is 1.");
    }


     // Tests the setInit, unsetInit, and isInit methods to ensure the initialization status is managed correctly.

    @Test
    void testInitializationStatus() {
        State state = new State("State1", 1);  // Create a State

        assertFalse(state.isInit(), "State should not be initialized by default.");  // Initial state should not be initialized

        state.setInit();  // Set the state as initialized
        assertTrue(state.isInit(), "State should be initialized after calling setInit().");

        state.unsetInit();  // Unset the state initialization
        assertFalse(state.isInit(), "State should not be initialized after calling unsetInit().");
    }
}