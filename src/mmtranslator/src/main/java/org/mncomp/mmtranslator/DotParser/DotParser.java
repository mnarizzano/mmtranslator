/**
 * This file contains the definition of the class DotParser
 * @author mnarizzano
 *
 */
if (l.contains("input")) {
                System.out.println("Processing input label");
                String[] inputSignals = l.replace("input", "").trim().split(",");
                for (String signal : inputSignals) {
                    inputSignalList.add(signal.trim());
                }
            } else if (l.contains("output")) {
                System.out.println("Processing output label");
                String[] outputSignals = l.replaceAll("output|;|]", "").trim().split(",");


                for (String signal : outputSignals) {
                    outputSignalList.add(signal.trim());
                }
            }
        }

        System.out.println("Input Signals from Labels: " + Arrays.toString(inputSignalList.toArray()));
        System.out.println("Output Signals from Labels: " + Arrays.toString(outputSignalList.toArray()));


    }
    public List<String> getInputSignalList() {
        return inputSignalList;
    }
    public List<String> getOutputSignalList() {
        return outputSignalList;
    }
    public MM getMealyMachine() {
        return mm;
    }
    public void closeDotFile() {
        try {
            if (fileDot != null) {
                fileDot.close();
            }
        } catch (IOException e) {
            // Handle file closing error
            e.printStackTrace();
        }
    }
}

// package org.mncomp.mmtranslator.DotParser; /**
//  * This file contains the definition of the class DotParser
//  * @author mnarizzano
//  *
//  */


// import java.io.FileInputStream;
// import java.util.ArrayList;
// import java.util.*;
// import org.mncomp.mmtranslator.*;
// import org.mncomp.mmtranslator.MM.MM;


// /**
//  * This Define all the methods that are necessary to parse a dot file.
//  * @see ... for more details
//  * @author mnarizzano
//  *
//  */
// public class DotParser {
//     private FileInputStream fileDot = null;      /* Input Stream*/
//     private ArrayList<String> inputSignaiList;   /* Input Signals as String of Chars*/
//     private ArrayList<String> outputSignalList;  /* Output Signals as String of Chars*/
//     private MM mm;                               /* Output MM */

// }
