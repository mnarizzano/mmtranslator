/**
 * This file contains the definition of the DotParser class.
 * The DotParser class parses a Dot file containing state and transition information
 * and populates HashMaps of states and transitions accordingly.
 *
 * The DotParser assumes a specific format for transition lines in the Dot file,
 * where transitions are defined as "State1 -> State2 [label=\"input/output\"]".
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator.DotParser;

import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class DotParser {

    /**
     * Parses the Dot file located at filePath and updates the states and transitions HashMaps.
     *
     * @param filePath The path to the Dot file to parse.
     * @param states A HashMap containing states identified by their names.
     * @param transitions A HashMap containing transitions identified by their IDs.
     * @throws IOException If there is an error reading or parsing the Dot file.
     */
    public void parse(String filePath, HashMap<String, State> states, HashMap<Integer, Transition> transitions) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));  // Read all lines from the Dot file

        // Iterate through each line in the Dot file
        for (String line : lines) {
            if (line.contains("->")) {
                // Parse transition line: "State1 -> State2 [label=\"input/output\"]"
                String[] parts = line.split("->");
                String fromStateName = parts[0].trim();

                // Split the second part to get toStateName and signals
                String[] toParts = parts[1].split("\\[label=\"");
                String toStateName = toParts[0].trim();

                // Extract inputSignal and outputSignal from the signals part
                String[] signals = toParts[1].replace("\"]", "").trim().split("/");
                String inputSignal = signals[0].trim();
                String outputSignal = signals[1].trim();

                // Ensure both states exist in the states HashMap
                states.putIfAbsent(fromStateName, new State(fromStateName, states.size()));
                states.putIfAbsent(toStateName, new State(toStateName, states.size()));

                // Create a new Transition object and add it to the transitions HashMap
                Transition transition = new Transition(transitions.size(), states.get(fromStateName), states.get(toStateName), inputSignal, outputSignal);
                transitions.put(transition.getId(), transition);
            }
        }
    }
}
