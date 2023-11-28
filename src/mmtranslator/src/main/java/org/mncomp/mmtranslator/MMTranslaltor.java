package org.mncomp.mmtranslator;
import org.mncomp.mmtranslator.MM.MM;
import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.Kiss2Writer.*;

import java.io.IOException;
public class MMTranslaltor
{
    public static void main( String[] args ) throws IOException {
        // Create an instance of Mealy Machine
        MM mm = new MM();
        // Create a DotParser instance with the file path and the Mealy Machine instance
        DotParser dp = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot",mm);
        // Create a Kiss2Writer instance with the file path and the Mealy Machine instance
        Kiss2Writer kw = new Kiss2Writer("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/bbara.kiss2",mm);
        try {
            // Parse the Dot file to populate the Mealy Machine
            dp.parseDotFile("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot");
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
        kw.writeKiss2(mm);
        // Write the Mealy Machine to the Kiss2 file
        kw.closeKiss2File();
        dp.getMealyMachine();
        // Close the Dot file
        dp.closeDotFile();
    }
}
