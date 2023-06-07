/**
 * This file contains the definition of the Transition class A
 * transition is a connection with to State, a starting State and an
 * arrival State. It also contains a list of input signals and a list
 * of output Signals assigned to true or false. 
 * @author mnarizzano
 *
 */

package package org.mncomp.mmtranslator;

import main.java.org.mncorp.State;

/**
 * This Define all the methods that are necessary to store  the Transition details of a MM.
 * @see ... for more details
 * @author mnarizzano
 *
 */
public class Transition {
    
    private static final AtomicInteger count = new AtomicInteger(0);  /* Counter for Unique Name of the Transition*/
    private final int id;                                             /* Unique id of the transition. Fianl because can not be modified*/
    private State stateTo;                                                 /* Arrival State of the Transition. */
    private State stateFrom;                                               /* Starting State of the Transition. */
    private Signal[] inputSignals;                                    /* Set of input signals*/
    private Signal[] outputSignals;                                   /* Set of output signals*/

    
    /**
     * Default Constructor
     */
    public Transition() {
	id = count.incrementAndGet();
    }
	
    /**
     * Constractor with param.
     * 
     * @param from, starting state of the Transition.
     * @param to, arrival state of the transition
     * @param InputSignals, rapresent the set of assigned input signals 
     * @param InputSignals, rapresent the set of assigned output signals 
     */
    public Transition(State from, State to, Signal[] inputSignals, Signal[] outputSignals){
	this.Transition();
	setStateFrom(from);
	setStateTo(to);
	setInputSignals(inputSignals);
	setOutputSignals(outputSignals);
    }

    /**
     * 
     * @return the id(name)  of the transition
     */
    int getId(){ return id;}

    /**
     * @return the arrival state of the transition
     */
    State getStateTo(){
	return stateTo;
    }

    /**
     * @return the starting state of the transition
     */
    State getStateFrom(){
	return stateFrom;
    }

    /**
     * @return return the set of assigned input signals 
     */
    Signal[] getInputSignals(){
	return inputSignals;
    }

        /**
     * @return return the set of assigned output signals 
     */
    Signal[] getOutputSignals(){
	return outputSignals;
    }


 
    /**
     * @param to, is the arrival state of the transition
     */
    void setStateTo(State to){
	stateTo = to;
    }

    /**
     * @param from, the starting state of the transition
     */
    void setStateFrom(State from){
        stateFrom = from;
    }

    /**
     * @param input, a set of assigned input signals 
     */
    void setInputSignals(Signal[] input){
	inputSignals = input.clone();
    }
    
    /**
     * @param output, a set of assigned output signals 
     */
    void setOutputSignals(Signal[] output){
	outputSignals = output.clone();
    }

