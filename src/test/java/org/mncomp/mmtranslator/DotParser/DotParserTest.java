package org.mncomp.mmtranslator.DotParser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the DotParser class.
 */
class DotParserTest {

    private DotParser dotParser;  // Instance of DotParser used for testing
    private HashMap<String, State> states;  // Stores states parsed from the .dot file
    private HashMap<Integer, Transition> transitions;  // Stores transitions parsed from the .dot file

    /**
     * Sets up the test environment.
     * Initializes the DotParser instance and HashMaps for states and transitions.
     */
    @BeforeEach
    void setUp() {
        dotParser = new DotParser();  // Initialize DotParser
        states = new HashMap<>();  // Initialize states HashMap
        transitions = new HashMap<>();  // Initialize transitions HashMap
    }

    /**
     * Tests the parse method with a valid .dot file to ensure states and transitions are populated correctly.
     */
    @Test
    void parseValidDotFile() {
        String filePath = "src/dot0.dot";  // Ensure this file exists with valid .dot syntax

        try {
            dotParser.parse(filePath, states, transitions);  // Parse the valid .dot file
            // Assert: Check that states and transitions are populated correctly
            assertFalse(states.isEmpty(), "States should not be empty after parsing a valid .dot file.");
            assertFalse(transitions.isEmpty(), "Transitions should not be empty after parsing a valid .dot file.");

            // Additional assertions to verify specific states and transitions
            assertTrue(states.containsKey("State1"), "State 'State1' should be present.");
            assertTrue(states.containsKey("State2"), "State 'State2' should be present.");
            assertTrue(transitions.containsKey(0), "Transition with ID 0 should be present.");

        } catch (IOException e) {
            fail("Parsing threw an unexpected IOException: " + e.getMessage());
        }
    }
    /**
     * Tests the parse method with an empty .dot file to ensure no states or transitions are added.
     */
    @Test
    void parseEmptyDotFile() {
        String filePath = "src/empty.dot";  // Ensure this file is empty

        try {
            dotParser.parse(filePath, states, transitions);  // Parse the empty .dot file
            assertTrue(states.isEmpty(), "States should be empty after parsing an empty .dot file.");
            assertTrue(transitions.isEmpty(), "Transitions should be empty after parsing an empty .dot file.");

        } catch (IOException e) {
            fail("Parsing threw an unexpected IOException: " + e.getMessage());
        }
    }

}