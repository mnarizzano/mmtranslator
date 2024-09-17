/**
 * This file contains the definition of the class Kiss2Writer.
 * The Kiss2Writer class is responsible for writing Kiss2 files
 * based on the provided states and transitions of a Mealy Machine.
 * It outputs a Kiss2 formatted file containing information about
 * states, transitions, and signals for simulation or further processing.
 *
 * The class uses a BufferedWriter to efficiently write to the file system
 * and formats the output according to the Kiss2 file format specification.
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator.Kiss2Translator;

import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
/**
 * The Kiss2Writer class provides functionality to write Kiss2 files
 * based on the states and transitions provided.
 */
public class Kiss2Writer {
    /**
     * Writes a Kiss2 file to the specified file path based on the states and transitions.
     * The file content is formatted according to the Kiss2 file format specification,
     * which includes the input/output signals, states, initial state, and transitions.
     *
     * @param filePath The path where the Kiss2 file will be written.
     * @param states A HashMap containing states identified by their names.
     * @param transitions A HashMap containing transitions identified by their IDs.
     * @throws IOException If there is an error writing the Kiss2 file.
     */
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
