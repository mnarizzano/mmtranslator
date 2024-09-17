package org.mncomp.mmtranslator.Kiss2Translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Kiss2Translator class.
 */
class Kiss2TranslatorTest {

    private Kiss2Translator translator;  // Instance of Kiss2Translator for testing
    private DotParser dotParser;  // Real DotParser instance
    private Kiss2Writer kiss2Writer;  // Real Kiss2Writer instance
    private HashMap<String, State> states;  // Stores states parsed from the .dot file
    private HashMap<Integer, Transition> transitions;  // Stores transitions parsed from the .dot file

    /**
     * Sets up the test environment.
     * Initializes Kiss2Translator with real DotParser and Kiss2Writer instances.
     */
    @BeforeEach
    void setUp() {
        dotParser = new DotParser();  // Initialize DotParser
        kiss2Writer = new Kiss2Writer();  // Initialize Kiss2Writer
        translator = new Kiss2Translator(dotParser, kiss2Writer);  // Initialize Kiss2Translator with real instances
        states = new HashMap<>();  // Initialize states HashMap
        transitions = new HashMap<>();  // Initialize transitions HashMap
    }

    /**
     * Tests the parseDotFile method with a valid .dot file to ensure states and transitions are populated correctly.
     */
    @Test
    void parseDotFile() {
        String inputFilePath = "src/dot0.dot";  // Ensure this file exists with valid .dot syntax

        try {
            // Act: Call the parseDotFile method
            translator.parseDotFile(inputFilePath, states, transitions);

            // Assert: Check that states and transitions are populated correctly
            assertFalse(states.isEmpty(), "States should not be empty after parsing a valid .dot file.");
            assertFalse(transitions.isEmpty(), "Transitions should not be empty after parsing a valid .dot file.");

            // Additional assertions to verify specific states and transitions
            assertTrue(states.containsKey("State1"), "State 'State1' should be present.");
            assertTrue(states.containsKey("State2"), "State 'State2' should be present.");
            assertTrue(transitions.containsKey(0), "Transition with ID 0 should be present.");

        } catch (IOException e) {
            fail("Unexpected IOException thrown during parseDotFile: " + e.getMessage());
        }
    }

    /**
     * Tests the writeKissFile method to ensure a Kiss2 file is written correctly based on the states and transitions.
     */
    @Test
    void writeKissFile() {
        String outputFilePath = "src/kiss0.kiss2";  // Path where the output .kiss2 file will be written
        // Set up some wrong states and transitions for testing
        State state1 = new State("State1", 1);
        State state2 = new State("State2", 2);
        states.put("State1", state1);
        states.put("State2", state2);
        transitions.put(0, new Transition(0, state1, state2, "0", "1"));
        try {
            //Call the writeKissFile method
            translator.writeKissFile(outputFilePath, states, transitions);

            //Verify the output file was created
            File outputFile = new File(outputFilePath);
            assertTrue(outputFile.exists(), "Output Kiss2 file should exist after writing.");

            // Additional checks can be added to validate the content of the output file
        } catch (IOException e) {
            fail("Unexpected IOException thrown during writeKissFile: " + e.getMessage());
        }
    }
}