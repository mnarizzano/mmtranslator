/**
 * Represents a signal used in a Mealy Machine.
 * Signals are characterized by their names and an optional integer value.
 * Provides methods to retrieve and manipulate these attributes.
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator.Signal;

public class Signal {
    private String name;  // Name of the signal
    private int value;    // Optional integer value associated with the signal

    /**
     * Constructs a signal with the specified name and value.
     *
     * @param name  The name of the signal.
     * @param value The integer value associated with the signal.
     */
    public Signal(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Constructs a signal with the specified name.
     * The value is initialized to 0.
     *
     * @param name The name of the signal.
     */
    public Signal(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the signal.
     *
     * @return The name of the signal.
     */
    public String getSignalName() {
        return name;
    }

    /**
     * Sets a new name for the signal.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the integer value associated with the signal.
     *
     * @return The integer value of the signal.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets a new integer value for the signal.
     *
     * @param value The new integer value to set.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
