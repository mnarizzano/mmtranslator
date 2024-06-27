package org.mncomp.mmtranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.Kiss2Translator.Kiss2Writer;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MMTranslator class.
 */
class MMTranslatorTest {

    private MMTranslator translator;
    private State state1;
    private State state2;
    private Transition transition1;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        DotParser dotParser = new DotParser();
        Kiss2Writer kiss2Writer = new Kiss2Writer();
        translator = new MMTranslator(dotParser, kiss2Writer);
        state1 = new State("TestState1", 1);
        state2 = new State("TestState2", 2);
        transition1 = new Transition(1, state1, state2, "signal1", "signal2");
    }

    /**
     * Tests the translate method.
     */
    @Test
    void testTranslate() {
        String inputFilePath = "/Users/fateme/Downloads/mmtranslator-main6/src/dot0.dot";
        String outputFilePath = "/Users/fateme/Downloads/mmtranslator-main6/src/kiss0.kiss2";
        try {
            translator.translate(inputFilePath, outputFilePath);
            // Optionally add assertions to verify output file content if needed
        } catch (IOException e) {
            fail("IOException was thrown during translate.");
        }
    }

    /**
     * Tests the addState method.
     */
    @Test
    void testAddState() {
        translator.addState(state1);
        State retrievedState = translator.getState("TestState1");
        assertEquals(state1, retrievedState);
    }

    /**
     * Tests the addTransition method.
     */
    @Test
    void testAddTransition() {
        translator.addTransition(transition1);
        Transition retrievedTransition = translator.getTransition(1);
        assertEquals(transition1, retrievedTransition);
    }

    /**
     * Tests the getState method.
     */
    @Test
    void testGetState() {
        translator.addState(state1);
        State retrievedState = translator.getState("TestState1");
        assertEquals(state1, retrievedState);
    }

    /**
     * Tests the getTransition method.
     */
    @Test
    void testGetTransition() {
        translator.addTransition(transition1);
        Transition retrievedTransition = translator.getTransition(1);
        assertEquals(transition1, retrievedTransition);
    }

    /**
     * Tests the main method.
     * Note: This test assumes dot0.dot and kiss0.kiss2 exist in src/test/resources
     */
    @Test
    void testMain() {
        String[] args = {"/Users/fateme/Downloads/mmtranslator-main6/src/dot0.dot", "/Users/fateme/Downloads/mmtranslator-main6/src/kiss0.kiss2"};
        MMTranslator.main(args);
        // Optionally add assertions to verify console output if needed
    }
}
