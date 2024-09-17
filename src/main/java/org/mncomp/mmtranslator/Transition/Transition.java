/**
 * This file contains the definition of the class Transition.
 * The Transition class represents a transition between states in a Mealy Machine.
 * It encapsulates information about the transition ID, the source and destination states,
 * input and output signals associated with the transition.
 * The class also provides methods to retrieve these attributes and format the transition
 * in the KISS2 format.
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator.Transition;

import org.mncomp.mmtranslator.State.State;

public class Transition {
    private int id;
    private State fromState;
    private State toState;
    private String inputSignal;
    private String outputSignal;

    /**
     * Constructs a Transition object with the specified ID, source state, destination state,
     * input signal, and output signal.
     *
     * @param id The unique identifier for the transition.
     * @param fromState The source state from which the transition originates.
     * @param toState The destination state to which the transition leads.
     * @param inputSignal The input signal triggering the transition.
     * @param outputSignal The output signal produced by the transition.
     */
    public Transition(int id, State fromState, State toState, String inputSignal, String outputSignal) {
        this.id = id;
        this.fromState = fromState;
        this.toState = toState;
        this.inputSignal = inputSignal;
        this.outputSignal = outputSignal;
    }

    /**
     * Retrieves the unique identifier of the transition.
     *
     * @return The ID of the transition.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the source state from which the transition originates.
     *
     * @return The source State object.
     */
    public State getFromState() {
        return fromState;
    }

    /**
     * Retrieves the destination state to which the transition leads.
     *
     * @return The destination State object.
     */
    public State getToState() {
        return toState;
    }

    /**
     * Retrieves the input signal associated with the transition.
     *
     * @return The input signal string.
     */
    public String getInputSignal() {
        return inputSignal;
    }

    /**
     * Retrieves the output signal produced by the transition.
     *
     * @return The output signal string.
     */
    public String getOutputSignal() {
        return outputSignal;
    }

    /**
     * Converts the transition to the KISS2 format string representation.
     * The format is "fromState inputSignal toState outputSignal".
     *
     * @return The transition formatted as a KISS2 string.
     */
    public String toKissFormat() {
        return fromState.getStateName() + " " + inputSignal + " " + toState.getStateName() + " " + outputSignal;
    }
}
