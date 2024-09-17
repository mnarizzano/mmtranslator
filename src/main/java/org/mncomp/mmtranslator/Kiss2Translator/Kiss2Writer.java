package org.mncomp.mmtranslator.Kiss2Translator;

import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Kiss2Writer {
    public void writeKissFile(String filePath, HashMap<String, State> states, HashMap<Integer, Transition> transitions) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header information
            bw.write(".i 1");
            bw.newLine();
            bw.write(".o 1");
            bw.newLine();
            bw.write(".s " + states.size());
            bw.newLine();
            bw.write(".r " + states.values().stream().filter(State::isInit).findFirst().map(State::getStateName).orElse("State1"));
            bw.newLine();
            bw.write(".p " + transitions.size());
            bw.newLine();

            // Write the transitions
            for (Transition transition : transitions.values()) {
                bw.write(transition.toKissFormat());
                bw.newLine();
            }
        }
    }
}
