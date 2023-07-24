package org.mncomp.mmtranslator.Signal; /**
 * This file contains the definition of the variables that are added
 * to each transition/mealy machine. A variables is called Signal, and
 * other than names it has also a value defining if it is positive
 * signal or a negative signal.
 * @author mnarizzano
 *
 */
import java.util.*;
import java.*;

/**
 * This Define all the methods that are necessary to store the Signal
 * labelling Transitions
 * @see ... for more details
 * @author mnarizzano
 *
 */
public class Signal {
    private String name;
    private SignalType type;

    public Signal(String name, SignalType type) {
        this.name = name;
        this.type = type;
    }

    // Getter and Setter methods for name and type
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SignalType getType() {
        return type;
    }

    public void setType(SignalType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Signal [name=" + name + ", type=" + type + "]";
    }
}
