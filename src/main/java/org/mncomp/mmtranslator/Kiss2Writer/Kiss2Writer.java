/**
 * This file contains the definition of the Kiss2Writer class.
 *
 * @author mnarizzano
 */
package org.mncomp.mmtranslator.Kiss2Writer;

// Import statements for required classes
import org.mncomp.mmtranslator.MM.MM;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
import org.mncomp.mmtranslator.Signal.Signal;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Kiss2Writer class is responsible for writing a Mealy Machine to a Kiss2 file.
 */
public class Kiss2Writer {
    // BufferedWriter for writing to the Kiss2 file
    private BufferedWriter fileWriter;

    // Reference to the Mealy Machine
    private MM mm;

    /**
     * Constructor for the Kiss2Writer class.
     *
     * @param filePath Path to the Kiss2 file.
     * @param mm       Mealy Machine object to be written.
     */
    public Kiss2Writer(String filePath, MM mm) {
        try {
            // Initialize the BufferedWriter with the specified file path
            fileWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            // Handle IOException if file initialization fails
            e.printStackTrace();
        }
        this.mm = mm; // Set the reference to the Mealy Machine
    }



    /**
     * Method to write the Mealy Machine to a Kiss2 file.
     *
     * @param mm Mealy Machine object to be written.
     */
    public void writeKiss2(MM mm) {
        try {
            // Check if the fileWriter is not null
            if (fileWriter != null) {
                // Write the number of input signals to the file
                fileWriter.write(".i " + mm.getInputSignals().size());
                fileWriter.newLine();

                // Write the number of output signals to the file
                fileWriter.write(".o " + mm.getOutputSignals().size());
                fileWriter.newLine();

                // Write the number of states to the file
                fileWriter.write(".s " + mm.getAllStates().size());
                fileWriter.newLine();

                // Write the ID of the reset state to the file
                fileWriter.write(".r " + mm.getResetState().getId());
                fileWriter.newLine();

                // Write the number of transitions to the file
                fileWriter.write(".p " + mm.getAllTransitions().size());
                fileWriter.newLine();

                // Write the names of input signals to the file
                for (Signal signal : mm.getInputSignals()) {
                    fileWriter.write(".v " + signal.getSignalName());
                    fileWriter.newLine();
                }

                // Write the names of output signals to the file
                for (Signal signal : mm.getOutputSignals()) {
                    fileWriter.write(".v " + signal.getSignalName());
                    fileWriter.newLine();
                }

                // Write state definitions to the file
                for (State state : mm.getAllStates()) {
                    fileWriter.write(Integer.toString(state.getId()));
                    fileWriter.newLine();
                }

                // Write transitions to the file
                for (Transition transition : mm.getAllTransitions()) {
                    String input = transition.getInputSignals().getSignalName();
                    String output = transition.getOutputSignals().getSignalName();
                    String line = transition.getStateFrom().getId() + " " + input + " " + output + " " + transition.getStateTo().getId();
                    fileWriter.write(line);
                    fileWriter.newLine();
                }

                // Flush the BufferedWriter
                fileWriter.flush();
            }

            // Close the BufferedWriter
            fileWriter.close();
        } catch (IOException e) {
            // Handle IOException if an error occurs during writing
            e.printStackTrace();
        } finally {
            try {
                // Close the BufferedWriter in the finally block
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                // Handle IOException if an error occurs during closing
                e.printStackTrace();
            }
        }
    }

    
    /**
     * Method to close the Kiss2 file.
     * Closes the BufferedWriter used for writing to the Kiss2 file.
     */
    public void closeKiss2File() {
        try {
            // Close the BufferedWriter if it is not null
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            // Handle IOException if an error occurs during closing
            e.printStackTrace();
        }
    }
}
