package org.mncomp.mmtranslator.State;

public class State {
    // Name of the State
    private String name;

    // Indicates if the state is an initial state (True) or not (False)
    private boolean init;

    // State number (not currently used in the provided code)
    private int statenumber;

    // Unique identifier for the state
    private int id;

    // Default constructor (not currently used in the provided code)
    public State() {
        // Default constructor
    }

    // Parameterized constructor to set the state name and ID
    public State(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter method to retrieve the name of the state
    public String getStateName() {
        return name;
    }

    // Getter method to retrieve the unique identifier of the state
    public int getId() {
        return id;
    }

    // Getter method to retrieve the state number (not currently used)
    public int getStateNo() {
        return statenumber;
    }

    // Setter method to set the name of the state
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to check if the state is an initial state
    public boolean isInit() {
        return init;
    }

    // Setter method to set the state as an initial state
    public void setInit() {
        init = true;
    }

    // Setter method to set the state as not an initial state
    public void unsetInit() {
        init = false;
    }
}
