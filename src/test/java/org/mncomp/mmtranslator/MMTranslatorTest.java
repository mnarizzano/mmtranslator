package org.mncomp.mmtranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
import org.mncomp.mmtranslator.DotParser.DotParser;  // Assuming these are the correct imports
import org.mncomp.mmtranslator.Kiss2Translator.Kiss2Writer;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MMTranslator class.
 */
class MMTranslatorTest {

    private MMTranslator translator; // Instance of MMTranslator for testing

    /**
     * Sets up the test environment.
     * Initializes the MMTranslator instance with its dependencies.
     */
    @BeforeEach
    void setUp() {
        DotParser dotParser = new DotParser();  // Initialize DotParser
        Kiss2Writer kiss2Writer = new Kiss2Writer();  // Initialize Kiss2Writer
        translator = new MMTranslator(dotParser, kiss2Writer);  // Properly initialize MMTranslator
    }


    // Tests the translate method to ensure it creates an output file correctly.

    @Test
    void translate() {
        String inputFilePath = "src/dot0.dot";
        String outputFilePath = "src/kiss0.kiss2";

        try {
            translator.translate(inputFilePath, outputFilePath);

            File outputFile = new File(outputFilePath);
            assertTrue(outputFile.exists(), "Output file should exist after translation.");

            // Additional checks can be added to validate the content of the output file
        } catch (IOException e) {
            fail("Translation threw an unexpected IOException.");
        }
    }

    // Tests the getState method to ensure it returns the correct state or null.

    @Test
    void getState() {
        State state = new State("State1", 1);
        translator.addState(state);

        State retrievedState = translator.getState("State1");
        assertNotNull(retrievedState, "Expected state not found.");
        assertEquals(state, retrievedState, "Retrieved state does not match the expected state.");

        assertNull(translator.getState("NonExistentState"), "Non-existent state should return null.");
    }

   //Tests the getTransition method to ensure it returns the correct transition or null.

    @Test
    void getTransition() {
        Transition transition = new Transition(1, new State("State1", 1), new State("State2", 2), "0", "1");
        translator.addTransition(transition);

        Transition retrievedTransition = translator.getTransition(1);
        assertNotNull(retrievedTransition, "Expected transition not found.");
        assertEquals(transition, retrievedTransition, "Retrieved transition does not match the expected transition.");

        assertNull(translator.getTransition(99), "Non-existent transition should return null.");
    }
}