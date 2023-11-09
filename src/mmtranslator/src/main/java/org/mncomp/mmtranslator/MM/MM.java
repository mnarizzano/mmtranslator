package org.mncomp.mmtranslator.MM;
import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
import org.mncomp.mmtranslator.Signal.Signal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class MM {
    private int id;
    private List<State> states;
    private List<Transition> transitions;
    private List<Signal> inputSignals;
    private List<Signal> outputSignals;
    private State resetState;

    public MM() {
        id = 0;
        states = new ArrayList<>();
        transitions = new ArrayList<>();
        inputSignals = new ArrayList<>();
        outputSignals = new ArrayList<>();
        resetState = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<State> getAllStates() {
        return states;
    }

    public void addState(State state) {
        states.add(state);
    }

    public List<Transition> getAllTransitions() {
        return transitions;
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public List<Signal> getInputSignals() {
        return inputSignals;
    }

    public void addInputSignal(Signal signal) {
        inputSignals.add(signal);
    }

    public List<Signal> getOutputSignals() {
        return outputSignals;
    }

    public void addOutputSignal(Signal signal) {
        outputSignals.add(signal);
    }

    public State getResetState() {
        return resetState;
    }

    public void setResetState(State state) {
        resetState = state;
    }

    public int getStateNo(int id) {
        for (State state : states) {
            if (state.getId() == id) {
                return state.getStateNo();
            }
        }
        return -1; // Return -1 if the state with the given ID is not found
    }
}
