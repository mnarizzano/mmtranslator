package org.mncomp.mmtranslator.Kiss2Translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class Kiss2WriterTest {

    private Kiss2Writer kiss2Writer;

    @Mock
    private BufferedWriter mockBufferedWriter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        kiss2Writer = new Kiss2Writer();
    }

    @Test
    void testWriteKissFile() throws IOException {
        String filePath = "test.kiss2";
        HashMap<String, State> states = new HashMap<>();
        State state1 = new State("State1", 1);
        State state2 = new State("State2", 2);
        state1.setInit(); // Set State1 as initial state
        states.put("State1", state1);
        states.put("State2", state2);

        HashMap<Integer, Transition> transitions = new HashMap<>();
        Transition transition1 = new Transition(1, state1, state2, "input1", "output1");
        Transition transition2 = new Transition(2, state2, state1, "input2", "output2");
        transitions.put(1, transition1);
        transitions.put(2, transition2);

        // Mock FileWriter and BufferedWriter
        FileWriter mockFileWriter = mock(FileWriter.class);
        when(mockFileWriter.getBufferedWriter()).thenReturn(mockBufferedWriter);
        whenNew(FileWriter.class).withArguments(filePath).thenReturn(mockFileWriter);

        kiss2Writer.writeKissFile(filePath, states, transitions);

        // Verify header information
        verify(mockBufferedWriter).write(".i 1");
        verify(mockBufferedWriter).newLine();
        verify(mockBufferedWriter).write(".o 1");
        verify(mockBufferedWriter).newLine();
        verify(mockBufferedWriter).write(".s 2"); // Two states in the HashMap
        verify(mockBufferedWriter).newLine();
        verify(mockBufferedWriter).write(".r State1"); // Initial state is State1
        verify(mockBufferedWriter).newLine();
        verify(mockBufferedWriter).write(".p 2"); // Two transitions in the HashMap
        verify(mockBufferedWriter, times(2)).newLine();

        // Verify transitions
        verify(mockBufferedWriter).write("State1 input1 State2 output1");
        verify(mockBufferedWriter).newLine();
        verify(mockBufferedWriter).write("State2 input2 State1 output2");
        verify(mockBufferedWriter).newLine();

        // Close resources
        verify(mockBufferedWriter).close();
    }
}
