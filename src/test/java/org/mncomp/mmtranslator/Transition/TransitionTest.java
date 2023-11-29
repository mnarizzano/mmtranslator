package org.mncomp.mmtranslator.Transition;

import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Signal.Signal;

import static org.junit.jupiter.api.Assertions.*;

class TransitionTest {

    @Test
    void getId() {
        // Arrange
        Transition transition = new Transition();

        // Act
        int id = transition.getId();

        // Assert
        assertTrue(id > 0);
    }

    @Test
    void getStateTo() {
        // Arrange
        Transition transition = new Transition();
        State stateTo = new State("ToState", 1);
        transition.setStateTo(stateTo);

        // Act
        State result = transition.getStateTo();

        // Assert
        assertEquals(stateTo, result);
    }

    @Test
    void getStateFrom() {
        // Arrange
        Transition transition = new Transition();
        State stateFrom = new State("FromState", 1);
        transition.setStateFrom(stateFrom);

        // Act
        State result = transition.getStateFrom();

        // Assert
        assertEquals(stateFrom, result);
    }

    @Test
    void getInputSignals() {
        // Arrange
        Transition transition = new Transition();
        Signal inputSignals = new Signal("InputSignal");
        transition.setInputSignals(inputSignals);

        // Act
        Signal result = transition.getInputSignals();

        // Assert
        assertEquals(inputSignals, result);
    }

    @Test
    void getOutputSignals() {
        // Arrange
        Transition transition = new Transition();
        Signal outputSignals = new Signal("OutputSignal");
        transition.setOutputSignals(outputSignals);

        // Act
        Signal result = transition.getOutputSignals();

        // Assert
        assertEquals(outputSignals, result);
    }

    @Test
    void setStateTo() {
        // Arrange
        Transition transition = new Transition();
        State stateTo = new State("ToState", 1);

        // Act
        transition.setStateTo(stateTo);

        // Assert
        assertEquals(stateTo, transition.getStateTo());
    }

    @Test
    void setStateFrom() {
        // Arrange
        Transition transition = new Transition();
        State stateFrom = new State("FromState", 1);

        // Act
        transition.setStateFrom(stateFrom);

        // Assert
        assertEquals(stateFrom, transition.getStateFrom());
    }

    @Test
    void setInputSignals() {
        // Arrange
        Transition transition = new Transition();
        Signal inputSignals = new Signal("InputSignal");

        // Act
        transition.setInputSignals(inputSignals);

        // Assert
        assertEquals(inputSignals, transition.getInputSignals());
    }

    @Test
    void setOutputSignals() {
        // Arrange
        Transition transition = new Transition();
        Signal outputSignals = new Signal("OutputSignal");

        // Act
        transition.setOutputSignals(outputSignals);

        // Assert
        assertEquals(outputSignals, transition.getOutputSignals());
    }
}
