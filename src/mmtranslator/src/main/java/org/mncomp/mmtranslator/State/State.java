/**
 * This file contains the definition of the State class 
 * @author mnarizzano
 *
 */

package package org.mncomp.mmtranslator;

import main.java.org.mncorp.MM;

/**
 * This Define all the methods that are necessary to store  the state details of a MM.
 * @see ... for more details
 * @author mnarizzano
 *
 */
public class State {
    private String name;       /* Name of the State*/
    private Bool   init;   /* Indicate if the state is an initial state (True) or not(False)*/

    /**
     * Default Constructor
     */
    public State() {}
	
    /**
     * Constractor with param.
     * 
     * @param name, the name of the state.
     * @param init, indicate that the state is of init. Is a boolean value, if True the state is an initial state.
     */
    public State(String name, bool init) { 
	setName(name);
	if (init) {
	    setInit();
	} else {
	    unsetInit();
	}
    }

    /**
     * Set the name of the State Object 
     * @param name, name of the state
     */
    void setName(String Name){}

    /**
     * Get the name of the State Object 
     * @return the name of the state
     */
    String getName(){
	return name;
    }


    /**
     * Set the state as an initial State
     */
    void setInitial(){
	init = true;
    }

    /**
     * Set the state as not initial. 
     */
    String unsetInitial(){
	init = false;
    }

    /**
     * Ask if the State is inisial.
     * @return True if the state is initial, False otherwise 
     */
    Bool isInitial(){
	return init;
    }

    
}
