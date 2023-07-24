package org.mncomp.mmtranslator.State; /**
 * This file contains the definition of the State class 
 * @author mnarizzano
 *
 */
import org.mncomp.mmtranslator.*;

public class State {
    private String name;       /* Name of the State */
    private boolean init;      /* Indicates if the state is an initial state (true) or not (false) */

    /**
     * Default Constructor
     */
    public State() {
    }

    /**
     * Constructor with parameters.
     * 
     * @param name The name of the state.
     * @param init Boolean value indicating whether the state is an initial state (true) or not (false).
     */
    public State(String name, boolean init) {
        this.name = name;
        this.init = init;
    }

    /**
     * Set the name of the State.
     * 
     * @param name Name of the state.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the State.
     * 
     * @return The name of the state.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the state as an initial state.
     */
    public void setInitial() {
        init = true;
    }

    /**
     * Set the state as not an initial state.
     */
    public void unsetInitial() {
        init = false;
    }

    /**
     * Check if the State is an initial state.
     * 
     * @return True if the state is an initial state, false otherwise.
     */
    public boolean isInitial() {
        return init;
    }
}
