package org.mncomp.mmtranslator.Kiss2Translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Kiss2Translator class.
 */
class Kiss2TranslatorTest {

    private Kiss2Translator kiss2Translator;
    private DotParser dotParser;

    @TempDir
    Path tempDir;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        dotParser = new DotParser();
        kiss2Translator = new Kiss2Translator(dotParser, new Kiss2Writer());
    }

    /**
     * Tests the parseDotFile method.
     */
    @Test
    void testParseDotFile() throws IOException {
        // Arrange
        String inputFilePath = "test.dot";
        HashMap<String, State> states = new HashMap<>();
        HashMap<Integer, Transition> transitions = new HashMap<>();

        // Prepare the content of the dot file
        String dotContent = "State1 -> State2 [label=\"0/1\"]\n";
        Path dotFile = tempDir.resolve(inputFilePath);
        Files.writeString(dotFile, dotContent);

        // Act
        kiss2Translator.parseDotFile(dotFile.toString(), states, transitions);

        // Assert
        assertEquals(2, states.size());
        assertEquals(1, transitions.size());

        State state1 = states.get("State1");
        State state2 = states.get("State2");
        Transition transition = transitions.get(0);

        assertEquals("State1", state1.getStateName());
        assertEquals("State2", state2.getStateName());
        assertEquals("0", transition.getInputSignal());
        assertEquals("1", transition.getOutputSignal());
        assertEquals(state1, transition.getFromState());
        assertEquals(state2, transition.getToState());
    }

    /**
     * Tests the writeKissFile method.
     */
    @Test
    void testWriteKissFile() throws IOException {
        // Arrange
        String outputFilePath = "output.kiss2";
        HashMap<String, State> states = new HashMap<>();
        HashMap<Integer, Transition> transitions = new HashMap<>();

        State state1 = new State("State1", 1);
        state1.setInit();
        states.put(state1.getStateName(), state1);

        State state2 = new State("State2", 2);
        states.put(state2.getStateName(), state2);

        Transition transition = new Transition(1, state1, state2, "0", "1");
        transitions.put(transition.getId(), transition);

        Path kissFile = tempDir.resolve(outputFilePath);

        // Act
        assertDoesNotThrow(() -> kiss2Translator.writeKissFile(kissFile.toString(), states, transitions));

        // Assert
        String expectedContent = ".i 1\n.o 1\n.s 2\n.r State1\n.p 1\nState1 0 State2 1\n";
        String actualContent = Files.readString(kissFile);
        assertEquals(expectedContent, actualContent);
    }
}
