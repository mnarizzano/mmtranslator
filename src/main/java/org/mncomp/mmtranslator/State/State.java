/**
 * This file contains the definition of the class State.
 * The State class represents a state in a Mealy Machine, characterized by a unique name,
 * identifier (ID), and initialization status.
 * It provides methods to retrieve and manipulate these attributes.
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator.State;

public class State {
    private String name;
    private int id;
    private boolean isInit;

    /**
     * Constructs a State object with the specified name and ID.
     * The state is initially not marked as initialized.
     *
     * @param name The name of the state.
     * @param id The unique identifier of the state.
     */
    public State(String name, int id) {
        this.name = name;
        this.id = id;
        this.isInit = false;
    }

    /**
     * Retrieves the name of the state.
     *
     * @return The name of the state.
     */
    public String getStateName() {
        return name;
    }

    /**
     * Retrieves the unique identifier of the state.
     *
     * @return The ID of the state.
     */
    public int getId() {
        return id;
    }

    /**
     * Alias method for retrieving the state number (which is the same as the ID).
     *
     * @return The state number (ID).
     */
    public int getStateNo() {
        return id;
    }

    /**
     * Sets a new name for the state.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the state is initialized.
     *
     * @return true if the state is initialized, false otherwise.
     */
    public boolean isInit() {
        return isInit;
    }

    /**
     * Marks the state as initialized.
     */
    public void setInit() {
        this.isInit = true;
    }

    /**
     * Marks the state as uninitialized.
     */
    public void unsetInit() {
        this.isInit = false;
    }
}
