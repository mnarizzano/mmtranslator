package org.mncomp.mmtranslator.MM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Signal.Signal;
import org.mncomp.mmtranslator.Transition.Transition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MM class.
 */
class MMTest {

    private MM mealyMachine;  // Instance of MM for testing
    /**
     * Sets up the test environment.
     * Initializes an instance of MM before each test.
     */
    @BeforeEach
    void setUp() {
        mealyMachine = new MM();  // Initialize MM
    }
    /**
     * Tests the addState and getAllStates methods to ensure states are added and retrieved correctly.
     */
    @Test
    void testAddStateAndGetAllStates() {
        State state1 = new State("State1", 1);
        mealyMachine.addState(state1);
        List<State> states = mealyMachine.getAllStates();
        assertEquals(1, states.size(), "There should be exactly one state in the machine.");
        assertEquals(state1, states.get(0), "The retrieved state should match the added state.");
    }
    /**
     * Tests the addTransition and getAllTransitions methods to ensure transitions are added and retrieved correctly.
     */
    @Test
    void testAddTransitionAndGetAllTransitions() {
        State state1 = new State("State1", 1);
        State state2 = new State("State2", 2);
        Transition transition = new Transition(0, state1, state2, "0", "1");
        mealyMachine.addTransition(transition);
        List<Transition> transitions = mealyMachine.getAllTransitions();
        assertEquals(1, transitions.size(), "There should be exactly one transition in the machine.");
        assertEquals(transition, transitions.get(0), "The retrieved transition should match the added transition.");
    }
    /**
     * Tests the addInputSignal and getInputSignals methods to ensure input signals are added and retrieved correctly.
     */
    @Test
    void testAddInputSignalAndGetInputSignals() {
        Signal inputSignal = new Signal("0");
        mealyMachine.addInputSignal(inputSignal);
        List<Signal> inputSignals = mealyMachine.getInputSignals();
        assertEquals(1, inputSignals.size(), "There should be exactly one input signal in the machine.");
        assertEquals(inputSignal, inputSignals.get(0), "The retrieved input signal should match the added input signal.");
    }
    /**
     * Tests the addOutputSignal and getOutputSignals methods to ensure output signals are added and retrieved correctly.
     */
    @Test
    void testAddOutputSignalAndGetOutputSignals() {
        Signal outputSignal = new Signal("1");
        mealyMachine.addOutputSignal(outputSignal);
        List<Signal> outputSignals = mealyMachine.getOutputSignals();
        assertEquals(1, outputSignals.size(), "There should be exactly one output signal in the machine.");
        assertEquals(outputSignal, outputSignals.get(0), "The retrieved output signal should match the added output signal.");
    }
    /**
     * Tests the setResetState and getResetState methods to ensure the reset state is set and retrieved correctly.
     */
    @Test
    void testSetAndGetResetState() {
        State resetState = new State("ResetState", 0);
        mealyMachine.setResetState(resetState);
        assertEquals(resetState, mealyMachine.getResetState(), "The retrieved reset state should match the set reset state.");
    }
    /**
     * Tests the getStateNo method to ensure it returns the correct state number for a given state ID.
     */
    @Test
    void testGetStateNo() {
        State state1 = new State("State1", 1);
        mealyMachine.addState(state1);
        assertEquals(1, mealyMachine.getStateNo(1), "getStateNo should return the correct state number for the given state ID.");
        assertEquals(-1, mealyMachine.getStateNo(99), "getStateNo should return -1 for a non-existent state ID.");
    }
    /**
     * Tests the setId and getId methods to ensure the ID is set and retrieved correctly.
     */
    @Test
    void testSetAndGetId() {
        mealyMachine.setId(10);
        assertEquals(10, mealyMachine.getId(), "The retrieved ID should match the set ID.");
    }
}