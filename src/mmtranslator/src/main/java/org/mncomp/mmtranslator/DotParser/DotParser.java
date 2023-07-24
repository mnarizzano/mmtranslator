package org.mncomp.mmtranslator.DotParser; /**
 * This file contains the definition of the class DotParser
 * @author mnarizzano
 *
 */


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.*;
import org.mncomp.mmtranslator.*;
import org.mncomp.mmtranslator.MM.MM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DotParser {
    private ArrayList<String> inputSignalList;   /* Input Signals as String of Chars */
    private ArrayList<String> outputSignalList;  /* Output Signals as String of Chars */
    private MM mm;                               /* Output MM */

    /**
     * Constructor to initialize the inputSignalList, outputSignalList, and MM objects.
     */
    public DotParser() {
        inputSignalList = new ArrayList<>();
        outputSignalList = new ArrayList<>();
        mm = new MM();
    }

    /**
     * Method to parse the DOT format file and populate the inputSignalList,
     * outputSignalList, and MM objects.
     *
     * @param filePath The path to the DOT file.
     * @throws IOException If there is an error reading the file.
     */
    public void parseDotFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            // Process the line and extract input/output signals
            parseLine(line);
        }

        reader.close();
    }

    /**
     * Method to parse a line of the DOT file and extract input/output signals.
     *
     * @param line The line to be parsed.
     */
    private void parseLine(String line) {
        // Implement the logic to extract input/output signals from the line
        // Add the extracted signals to the inputSignalList or outputSignalList
    }

    /**
     * Method to get the list of input signals.
     *
     * @return The list of input signals.
     */
    public ArrayList<String> getInputSignalList() {
        return inputSignalList;
    }

    /**
     * Method to get the list of output signals.
     *
     * @return The list of output signals.
     */
    public ArrayList<String> getOutputSignalList() {
        return outputSignalList;
    }

    /**
     * Method to get the MealyMachine object.
     *
     * @return The MealyMachine object.
     */
    public MM getMealyMachine() {
        return mm;
    }
}
