package org.mncomp.mmtranslator.Signal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignalTest {

    @Test
    void getSignalName() {
        Signal signal = new Signal("ExampleSignal");
        assertEquals("ExampleSignal", signal.getSignalName());
    }

    @Test
    void setName() {
        Signal signal = new Signal("InitialSignal");
        signal.setName("UpdatedSignal");
        assertEquals("UpdatedSignal", signal.getSignalName());
    }
}
