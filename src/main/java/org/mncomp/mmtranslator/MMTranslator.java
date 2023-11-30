/**
 * This file contains the definition of the MMTranslator class.
 * The MMTranslator class is the entry point for the Mealy Machine translation process.
 * It creates instances of the Mealy Machine, DotParser, and Kiss2Writer to parse Dot files
 * and generate Kiss2 files based on the provided Mealy Machine.
 * 
 * @author RominaAdhami
 */

package org.mncomp.mmtranslator;

import org.mncomp.mmtranslator.MM.MM;
import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.Kiss2Writer.*;

import java.io.IOException;

public class MMTranslator {
    public static void main(String[] args) throws IOException {
        // Create an instance of the Mealy Machine
        MM mm = new MM();

        // Create a DotParser instance with the Dot file path and the Mealy Machine instance
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", mm);

        // Create a Kiss2Writer instance with the Kiss2 file path and the Mealy Machine instance
        Kiss2Writer kiss2Writer = new Kiss2Writer("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/bbara.kiss2", mm);

        try {
            // Parse the Dot file to populate the Mealy Machine
            dotParser.parseDotFile("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot");
        } catch (IOException e) {
            // Handle IOException gracefully or log the error
            throw new RuntimeException(e);
        }

        // Print information about the Mealy Machine
        System.out.println("Input Signals: " + mm.getInputSignals().size());
        System.out.println("Output Signals: " + mm.getOutputSignals().size());
        System.out.println("Number of States: " + mm.getAllStates().size());
        System.out.println("Number of Transitions: " + mm.getAllTransitions().size());

        // Write the Mealy Machine to the Kiss2 file
        kiss2Writer.writeKiss2(mm);

        // Close the Kiss2 file
        kiss2Writer.closeKiss2File();

        // Retrieve the Mealy Machine from the DotParser (not currently used in the provided code)
        dotParser.getMealyMachine();

        // Close the Dot file
        dotParser.closeDotFile();
    }
}
