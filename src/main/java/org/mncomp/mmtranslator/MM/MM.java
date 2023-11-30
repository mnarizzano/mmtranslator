/**
 * This file contains the definition of the MM (Mealy Machine) class.
 * The MM class represents a Mealy Machine, consisting of states, transitions,
 * input signals, and output signals. It provides methods to manipulate and
 * retrieve information about the machine. This class is a core component for
 * modeling Mealy Machines in the context of the project.
 * 
 * @see DotParser for parsing Dot files and populating Mealy Machines
 * @author RominaAdhami
 */
package org.mncomp.mmtranslator.MM;

import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
import org.mncomp.mmtranslator.Signal.Signal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The MM (Mealy Machine) class represents a Mealy Machine, consisting of states, transitions,
 * input signals, and output signals. It provides methods to manipulate and retrieve information about the machine.
 * This class is a core component for modeling Mealy Machines in the context of the project.
 * 
 * @see DotParser for parsing Dot files and populating Mealy Machines
 */
public class MM {
    // Unique identifier for the Mealy Machine
    private int id;
    
    // Lists to store states, transitions, input signals, and output signals
    private List<State> states;
    private List<Transition> transitions;
    private List<Signal> inputSignals;
    private List<Signal> outputSignals;

    // Initial state for the Mealy Machine
    private State resetState;

    // Default constructor to initialize lists and reset state
    public MM() {
        id = 0;
        states = new ArrayList<>();
        transitions = new ArrayList<>();
        inputSignals = new ArrayList<>();
        outputSignals = new ArrayList<>();
        resetState = null;
    }

    /**
     * Getter method for the Mealy Machine's unique identifier.
     *
     * @return The unique identifier of the Mealy Machine.
     */
    public int getId() {
        return id;
    }

     /**
     * Setter method for the Mealy Machine's unique identifier.
     *
     * @param id The unique identifier to set for the Mealy Machine.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method to retrieve all states in the Mealy Machine.
     *
     * @return A list of all states in the Mealy Machine.
     */
    public List<State> getAllStates() {
        return states;
    }
    
    /**
     * Method to add a state to the Mealy Machine.
     *
     * @param state The state to be added to the Mealy Machine.
     */
    public void addState(State state) {
        states.add(state);
    }

    /**
     * Getter method to retrieve all transitions in the Mealy Machine.
     *
     * @return A list of all transitions in the Mealy Machine.
     */
    public List<Transition> getAllTransitions() {
        return transitions;
    }
    

 
    /**
     * Method to add a transition to the Mealy Machine.
     *
     * @param transition The transition to be added to the Mealy Machine.
     */
    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    /**
     * Getter method to retrieve all input signals in the Mealy Machine.
     *
     * @return A list of all input signals in the Mealy Machine.
     */
    public List<Signal> getInputSignals() {
        return inputSignals;
    }
    

   /**
     * Method to add an input signal to the Mealy Machine.
     *
     * @param signal The input signal to be added to the Mealy Machine.
     */
    public void addInputSignal(Signal signal) {
        inputSignals.add(signal);
    }

    /**
     * Getter method to retrieve all output signals in the Mealy Machine.
     *
     * @return A list of all output signals in the Mealy Machine.
     */
    public List<Signal> getOutputSignals() {
        return outputSignals;
    }

   /**
     * Method to add an output signal to the Mealy Machine.
     *
     * @param signal The output signal to be added to the Mealy Machine.
     */
    public void addOutputSignal(Signal signal) {
        outputSignals.add(signal);
    }

    /**
     * Getter method to retrieve the reset state of the Mealy Machine.
     *
     * @return The reset state of the Mealy Machine.
     */
    public State getResetState() {
        return resetState;
    }
    

    /**
     * Setter method to set the reset state of the Mealy Machine.
     *
     * @param state The state to be set as the reset state.
     */
    public void setResetState(State state) {
        resetState = state;
    }

    /**
     * Method to get the state number based on the state ID.
     *
     * @param id The ID of the state.
     * @return The state number corresponding to the given state ID, or -1 if the state is not found.
     */
    public int getStateNo(int id) {
        for (State state : states) {
            if (state.getId() == id) {
                return state.getStateNo();
            }
        }
        return -1; // Return -1 if the state with the given ID is not found
    }
}
