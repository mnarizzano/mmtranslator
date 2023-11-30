// Package declaration for the test class
package org.mncomp.mmtranslator.State;

// Import statements for required classes and methods
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the State class.
 */
class StateTest {

    /**
     * Test the getStateName method of the State class.
     */
    @Test
    void getStateName() {
        // Arrange: Create a State instance with a specific name and ID
        State state = new State("TestState", 1);

        // Act: Call the getStateName method and check the result
        String result = state.getStateName();

        // Assert: Check if the returned state name is as expected
        assertEquals("TestState", result);
    }

    /**
     * Test the getId method of the State class.
     */
    @Test
    void getId() {
        // Arrange: Create a State instance with a specific name and ID
        State state = new State("TestState", 1);

        // Act: Call the getId method and check the result
        int result = state.getId();

        // Assert: Check if the returned state ID is as expected
        assertEquals(1, result);
    }

    /**
     * Test the getStateNo method of the State class.
     */
    @Test
    void getStateNo() {
        // Arrange: Create a State instance with a specific name and ID
        State state = new State("TestState", 1);

        // Act: Call the getStateNo method and check the result
        int result = state.getStateNo();

        // Assert: Check if the returned state number is as expected
        assertEquals(0, result);
    }

    /**
     * Test the setName method of the State class.
     */
    @Test
    void setName() {
        // Arrange: Create a State instance with an initial name and ID
        State state = new State("OldName", 1);

        // Act: Call the setName method to update the name
        state.setName("NewName");

        // Assert: Check if the name has been updated
        assertEquals("NewName", state.getStateName());
    }

    /**
     * Test the isInit method of the State class.
     */
    @Test
    void isInit() {
        // Arrange: Create an initial State and a non-initial State
        State initialState = new State("InitialState", 1);
        initialState.setInit();
        State nonInitialState = new State("NonInitialState", 2);

        // Act and Assert: Check if the isInit method returns the expected values
        assertTrue(initialState.isInit());
        assertFalse(nonInitialState.isInit());
    }

    /**
     * Test the setInit method of the State class.
     */
    @Test
    void setInit() {
        // Arrange: Create a State instance
        State state = new State("TestState", 1);

        // Act: Call the setInit method
        state.setInit();

        // Assert: Check if the state is marked as initial
        assertTrue(state.isInit());
    }

    /**
     * Test the unsetInit method of the State class.
     */
    @Test
    void unsetInit() {
        // Arrange: Create an initial State and set it as non-initial
        State initialState = new State("InitialState", 1);
        initialState.setInit();

        // Act: Call the unsetInit method
        initialState.unsetInit();

        // Assert: Check if the state is marked as non-initial
        assertFalse(initialState.isInit());
    }
}
