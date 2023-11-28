
// This package represents the Signal module in the mmtranslator project
package org.mncomp.mmtranslator.Signal;

/**
 * Represents a signal associated with transitions/mealy machines.
 * A signal has a name and an optional value indicating its positivity/negativity.
 * @author mnarizzano
 */
public class Signal {

    // Name of the signal
    private String name;

    // Value of the signal indicating positivity/negativity (not currently used)
    private int value;

    /**
     * Constructs a Signal with a given name and value.
     * @param name The name of the signal.
     * @param value The value of the signal (not currently used).
     */
    public Signal(String name, int value) {
        this.name = name;
        // this.value = value; // Commented out as value is not currently used
    }

    /**
     * Constructs a Signal with a given name.
     * @param name The name of the signal.
     */
    public Signal(String name){
        this.name = name;
    }

    /**
     * Gets the name of the signal.
     * @return The name of the signal.
     */
    public String getSignalName() {
        return name;
    }

    /**
     * Sets the name of the signal.
     * @param name The new name for the signal.
     */
    public void setName(String name) {
        this.name = name;
    }
}
