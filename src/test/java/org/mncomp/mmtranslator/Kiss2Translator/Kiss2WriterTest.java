package org.mncomp.mmtranslator.Kiss2Translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Kiss2Writer class.
 */
class Kiss2WriterTest {

    private Kiss2Writer kiss2Writer;
    private HashMap<String, State> states;
    private HashMap<Integer, Transition> transitions;

    @TempDir
    Path tempDir;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        kiss2Writer = new Kiss2Writer();
        states = new HashMap<>();
        transitions = new HashMap<>();
    }

    /**
     * Tests the writeKissFile method.
     */
    @Test
    void testWriteKissFile() throws IOException {
        // Arrange
        State state1 = new State("State1", 1);
        state1.setInit();
        states.put(state1.getStateName(), state1);

        State state2 = new State("State2", 2);
        states.put(state2.getStateName(), state2);

        Transition transition = new Transition(1, state1, state2, "0", "1");
        transitions.put(transition.getId(), transition);

        Path kissFile = tempDir.resolve("output.kiss2");

        // Act
        kiss2Writer.writeKissFile(kissFile.toString(), states, transitions);

        // Assert
        String expectedContent = ".i 1\n.o 1\n.s 2\n.r State1\n.p 1\nState1 0 State2 1\n";
        String actualContent = Files.readString(kissFile);
        assertEquals(expectedContent, actualContent);
    }
}
