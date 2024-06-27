package org.mncomp.mmtranslator.DotParser;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

class DotParserTest {

    private DotParser dotParser;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        dotParser = new DotParser();
    }

    @Test
    void testParse() throws IOException {
        // Arrange
        String inputFilePath = "test.dot";
        HashMap<String, State> states = new HashMap<>();
        HashMap<Integer, Transition> transitions = new HashMap<>();

        // Prepare the content of the dot file
        String dotContent = "State1 -> State2 [label=\"0/1\"]\n";
        Path dotFile = tempDir.resolve(inputFilePath);
        Files.writeString(dotFile, dotContent);

        // Act
        dotParser.parse(dotFile.toString(), states, transitions);

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

    @Test
    void testParseWithMultipleTransitions() throws IOException {
        // Arrange
        String inputFilePath = "testMultiple.dot";
        HashMap<String, State> states = new HashMap<>();
        HashMap<Integer, Transition> transitions = new HashMap<>();

        // Prepare the content of the dot file with multiple transitions
        String dotContent = "State1 -> State2 [label=\"0/1\"]\n" +
                "State2 -> State3 [label=\"1/0\"]\n" +
                "State3 -> State1 [label=\"1/1\"]\n";
        Path dotFile = tempDir.resolve(inputFilePath);
        Files.writeString(dotFile, dotContent);

        // Act
        dotParser.parse(dotFile.toString(), states, transitions);

        // Assert
        assertEquals(3, states.size());
        assertEquals(3, transitions.size());

        // Check state names
        assertTrue(states.containsKey("State1"));
        assertTrue(states.containsKey("State2"));
        assertTrue(states.containsKey("State3"));

        // Check transitions
        assertEquals("0", transitions.get(0).getInputSignal());
        assertEquals("1", transitions.get(0).getOutputSignal());
        assertEquals("1", transitions.get(1).getInputSignal());
        assertEquals("0", transitions.get(1).getOutputSignal());
        assertEquals("1", transitions.get(2).getInputSignal());
        assertEquals("1", transitions.get(2).getOutputSignal());
    }
}
