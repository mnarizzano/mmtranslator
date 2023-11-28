// This package represents the Signal module in the mmtranslator project
package org.mncomp.mmtranslator.Signal;


public class Signal {

    // Name of the signal
    private String name;

    // Value of the signal indicating positivity/negativity (
    private int value;

    
     // Constructs a Signal with a given name and value.
    public Signal(String name, int value) {
        this.name = name;
        // this.value = value; // Commented out as value is not currently used
    }

    
    // Constructs a Signal with a given name.
    public Signal(String name){
        this.name = name;
    }

    
     //Gets the name of the signal.
    public String getSignalName() {
        return name;
    }


     //Sets the name of the signal.
    public void setName(String name) {
        this.name = name;
    }
}
