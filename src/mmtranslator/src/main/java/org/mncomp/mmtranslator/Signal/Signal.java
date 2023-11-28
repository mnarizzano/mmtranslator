
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
