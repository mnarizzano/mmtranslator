/**
 * This file contains the definition of the class Signal.
 *
 * @author FatemeOzgoli
 */
package org.mncomp.mmtranslator.Signal;

/**
 * Represents a signal in a Mealy Machine.
 */
public class Signal {
    private String name; // The name of the signal
    private int value;   // The integer value associated with the signal

    /**
     * Constructs a Signal object with a name and a value.
     *
     * @param name  The name of the signal.
     * @param value The integer value associated with the signal.
     */
    public Signal(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Constructs a Signal object with a name and a default value of 0.
     *
     * @param name The name of the signal.
     */
    public Signal(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the signal.
     *
     * @return The name of the signal.
     */
    public String getSignalName() {
        return name;
    }

    /**
     * Sets the name of the signal.
     *
     * @param name The name of the signal.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the integer value associated with the signal.
     *
     * @return The integer value associated with the signal.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the integer value associated with the signal.
     *
     * @param value The integer value associated with the signal.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
