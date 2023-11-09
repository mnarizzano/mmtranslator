// package org.mncomp.mmtranslator.Signal; /**
//  * This file contains the definition of the variables that are added
//  * to each transition/mealy machine. A variables is called Signal, and
//  * other than names it has also a value defining if it is positive
//  * signal or a negative signal.
//  * @author mnarizzano
//  *
//  */

// import java.util.*;
// import java.*;

// /**
//  * This Define all the methods that are necessary to store the Signal
//  * labelling Transitions
//  * @see ... for more details
//  * @author mnarizzano
//  *
//  */
// public class Signal {
//     private String name;
//     private int value;

// }
package org.mncomp.mmtranslator.Signal;
public class Signal {
    private String name;
    private int value;
    public Signal(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public Signal(String name){
        this.name = name;
    }
    public String getSignalName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
