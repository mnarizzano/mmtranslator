package org.mncomp.mmtranslator.Kiss2Translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Kiss2Writer class.
 */
class Kiss2WriterTest {

    private Kiss2Writer kiss2Writer;  // Instance of Kiss2Writer for testing
    private HashMap<String, State> states;  // Stores states used for generating .kiss2 file
    private HashMap<Integer, Transition> transitions;  // Stores transitions used for generating .kiss2 file

    /**
     * Sets up the test environment.
     * Initializes Kiss2Writer and HashMaps for states and transitions.
     */
    @BeforeEach
    void setUp() {
        kiss2Writer = new Kiss2Writer();  // Initialize Kiss2Writer
        states = new HashMap<>();  // Initialize states HashMap
        transitions = new HashMap<>();  // Initialize transitions HashMap
    }

    /**
     * Tests the writeKissFile method to ensure it correctly writes the Kiss2 file.
     */
    @Test
    void writeKissFile() {
        String outputFilePath = "src/kiss0.kiss2";  // Path where the output .kiss2 file will be written
        // Set up states and transitions for the test
        State state1 = new State("State1", 1);
        State state2 = new State("State2", 2);
        states.put("State1", state1);
        states.put("State2", state2);

        Transition transition1 = new Transition(0, state1, state2, "0", "1");
        transitions.put(0, transition1);

        try {
            //Call the writeKissFile method
            kiss2Writer.writeKissFile(outputFilePath, states, transitions);
            // Verify the output file was created
            File outputFile = new File(outputFilePath);
            assertTrue(outputFile.exists(), "Output Kiss2 file should exist after writing.");
            try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
                assertEquals(".i 1", reader.readLine(), "First line should specify input count.");
                assertEquals(".o 1", reader.readLine(), "Second line should specify output count.");
                assertEquals(".s 2", reader.readLine(), "Third line should specify state count.");
                assertEquals(".r State1", reader.readLine(), "Fourth line should specify the initial state.");
                assertEquals(".p 1", reader.readLine(), "Fifth line should specify the number of transitions.");
                assertEquals(transition1.toKissFormat(), reader.readLine(), "Transition line should match expected format.");
            }

        } catch (IOException e) {
            fail("Unexpected IOException thrown during writeKissFile: " + e.getMessage());
        } finally {
            new File(outputFilePath).delete();
        }
    }
}