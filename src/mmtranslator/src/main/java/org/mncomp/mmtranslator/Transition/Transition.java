package org.mncomp.mmtranslator.Transition;

import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Signal.Signal;

import java.util.concurrent.atomic.AtomicInteger;

public class Transition {
    // Counter to generate unique identifiers for transitions
    private static final AtomicInteger count = new AtomicInteger(0);

    // Unique identifier for the transition
    private final int id;

    // State to which the transition leads
    private State stateTo;

    // State from which the transition originates
    private State stateFrom;

    // Input signal for the transition
    private Signal inputSignals;

    // Output signal for the transition
    private Signal outputSignals;

    // Default constructor to initialize the unique identifier
    public Transition() {
        id = count.incrementAndGet();
    }

    // Parameterized constructor to create a transition with specified states, input, and output signals
    public Transition(State from, State to, Signal[] inputSignals, Signal[] outputSignals) {
        // Call the default constructor to set the unique identifier
        this();

        // Set the originating and destination states, input, and output signals for the transition
        setStateFrom(from);
        setStateTo(to);
        setInputSignals(inputSignals[0]);
        setOutputSignals(outputSignals[0]);
    }

    // Getter method to retrieve the unique identifier of the transition
    public int getId() {
        return id;
    }

    // Getter method to retrieve the state to which the transition leads
    public State getStateTo() {
        return stateTo;
    }

    // Getter method to retrieve the state from which the transition originates
    public State getStateFrom() {
        return stateFrom;
    }

    // Getter method to retrieve the input signal for the transition
    public Signal getInputSignals() {
        return inputSignals;
    }

    // Getter method to retrieve the output signal for the transition
    public Signal getOutputSignals() {
        return outputSignals;
    }

    // Setter method to set the state to which the transition leads
    public void setStateTo(State to) {
        stateTo = to;
    }

    // Setter method to set the state from which the transition originates
    public void setStateFrom(State from) {
        stateFrom = from;
    }

    // Setter method to set the input signal for the transition
    public void setInputSignals(Signal input) {
        inputSignals = input;
    }

    // Setter method to set the output signal for the transition
    public void setOutputSignals(Signal output) {
        outputSignals = output;
    }
}
