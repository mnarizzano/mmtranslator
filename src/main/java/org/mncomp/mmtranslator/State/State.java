/**
 * This file contains the definition of the State class.
 *
 * @author RominaAdhami
 */
package org.mncomp.mmtranslator.State;

/**
 * This class defines all the methods necessary to store the state details of a Mealy Machine.
 * 
 */
public class State {
    // Name of the State
    private String name;

    // Indicates if the state is an initial state (True) or not (False)
    private boolean init;

    // State number (not currently used in the provided code)
    private int statenumber;

    // Unique identifier for the state
    private int id;

    /**
     * Default Constructor
     */
    public State() {
        // Default constructor
    }

      /**
     * Constructor with parameters.
     *
     * @param name Name of the state.
     * @param init Indicates whether the state is an initial state. 
     *             If true, the state is an initial state; otherwise, it is not.
     */
    public State(String name, int id) {
        this.name = name;
        this.id = id;
    }

     /**
     * Getter method to retrieve the name of the state.
     *
     * @return The name of the state.
     */
    public String getStateName() {
        return name;
    }

    /**
     * Getter method to retrieve the unique identifier of the state.
     *
     * @return The unique identifier of the state.
     */
    public int getId() {
        return id;
    }
    
   /**
     * Getter method to retrieve the state number (not currently used).
     *
     * @return The state number.
     */
    public int getStateNo() {
        return statenumber;
    }

    /**
     * Setter method to set the name of the state.
     *
     * @param name Name to set for the state.
     */
    public void setName(String name) {
        this.name = name;
    }

     /**
     * Getter method to check if the state is an initial state.
     *
     * @return True if the state is an initial state, false otherwise.
     */
    public boolean isInit() {
        return init;
    }

    /**
     * Setter method to set the state as an initial state.
     */
    public void setInit() {
        init = true;
    }

    /**
     * Setter method to set the state as not an initial state.
     */
    public void unsetInit() {
        init = false;
    }
}
