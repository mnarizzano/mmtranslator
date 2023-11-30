
/**
 * This file contains the definition of the class DotParser.
 *
 * @author FatemeOzgoli
 */
package org.mncomp.mmtranslator.DotParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mncomp.mmtranslator.MM.MM;
import org.mncomp.mmtranslator.Signal.Signal;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
/**
 * This class parses a Dot file representing a Mealy Machine and populates
 * an MM (Mealy Machine) object.
 */
public class DotParser {
    // Input Stream for reading the Dot file
    private BufferedReader fileDot;
    // Lists to store input and output signals extracted from the Dot file
    private List<String> inputSignalList;
    private List<String> outputSignalList;
    // Output MM (Mealy Machine)
    private MM mm;
    // Arrays to store input and output signals
    private Signal[] outputSignalsArray;
    private Signal[] inputSignalsArray;
    // List to store states
    private List<State> states;
    // Default reset state
    private State resetState = new State("reset", 0);

    /**
     * Constructor to initialize the DotParser with a file path and an MM object.
     *
     * @param filePath Path to the Dot file.
     * @param mm       Mealy Machine object to populate.
     */
    public DotParser(String filePath, MM mm) {
        try {
            // Initialize a BufferedReader to read from the Dot file using the provided file path
            fileDot = new BufferedReader(new FileReader(filePath));

            // Initialize lists to store input and output signals extracted from the Dot file
            inputSignalList = new ArrayList<>();
            outputSignalList = new ArrayList<>();
        } catch (IOException e) {
            // Print stack trace if an IOException occurs during file initialization
            e.printStackTrace();
        }
        // Set the Mealy Machine instance to process
        this.mm = mm;
    }

    /**
     * Method to parse the Dot file and populate the MM object.
     *
     * @param filePath Path to the Dot file.
     * @throws IOException If an IO error occurs during file reading.
     */
   public void parseDotFile(String filePath) throws IOException {
        try (BufferedReader fileDot = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileDot.readLine()) != null) {
                // Check if the line contains an arrow "->" indicating a transition
                if (line.contains("->")) {
                    processTransition(line);
                }
                // Check if the line contains "State" indicating a state
                else if (line.contains("State")) {
                    stateDetection(line);
                }
                // Check if the line contains "rank" indicating a reset state
                else if (line.contains("rank")) {
                    resetState(line);
                }
            }
        }
    }

     /**
     * Method to detect and process state information from a line.
     *
     * @param line Line containing state information.
     */
    private void stateDetection(String line) {
        // Split the line at "[" to separate the state name from additional information
        String[] fullState = line.split("\\[");

        // Extract the state name from the split parts and trim any leading/trailing whitespaces
        String stateName = fullState[0].trim();

        // Extract the state number from the state name using regular expression and parse it as an integer
        int fromStateNumber = Integer.parseInt(stateName.replaceAll("\\D+", ""));

        // Create a new State object with the extracted name and number
        State myState = new State(stateName, fromStateNumber);

        // Add the state to the Mealy Machine
        mm.addState(myState);
    }

    /**
     * Method to set the reset state based on a line containing "rank".
     *
     * @param line Line containing reset state information.
     */
    private void resetState(String line) {
        // Extract the state number from the line using regular expression and parse it as an integer
        int toStateNumber = Integer.parseInt(line.replaceAll("\\D+", ""));

        // Create a new State object with the name "reset" and the extracted state number
        String reset = "reset";
        resetState = new State(reset, toStateNumber);

        // Set the reset state in the Mealy Machine
        mm.setResetState(resetState);
    }

    /**
     * Method to process a transition line and add it to the Mealy machine.
     *
     * @param line Line containing transition information.
     */
    private void processTransition(String line) {
        // Split the line into parts using the "->" separator
        String[] parts = line.split("->");
        // Check if the line is a valid transition with two parts
        if (parts.length == 2) {
            // Extract the source state and destination state with labels
            String fromState = parts[0].trim();
            String toStateWithLabel = parts[1].trim();
            // Extract state numbers from the state names using regular expressions
            int fromStateNumber = Integer.parseInt(fromState.replaceAll("\\D+", ""));
            int indexOfBracket = toStateWithLabel.indexOf('[');
            String toState = (indexOfBracket != -1) ? toStateWithLabel.substring(0, indexOfBracket).trim() : toStateWithLabel;
            int toStateNumber = Integer.parseInt(toState.replaceAll("\\D+", ""));
            // Create State objects for the source and destination states
            State from = new State(fromState, fromStateNumber);
            State to = new State(toState, toStateNumber);
            // Process signal labels for the transition
            processSignalLabels(line);
            // Create a Transition object with the extracted information
            Transition transition = new Transition(from, to, inputSignalsArray, outputSignalsArray);
            // Add the transition to the Mealy Machine
            mm.addTransition(transition);
            // Print information about the transition for debugging purposes
            System.out.println("From State: " + fromState);
            System.out.println("To State: " + toState);
        }
    }

     /**
     * Method to process signal labels from a line.
     *
     * @param line Line containing signal labels.
     */
    private void processSignalLabels(String line) {
        // Extract the label part from the line
        String label = line.substring(line.indexOf("label") + 6).trim();

        // Split the label into individual labels using "/"
        String[] labels = label.split("/");

        // Lists to store input and output signal names
        List<String> inputSignalList = new ArrayList<>();
        List<String> outputSignalList = new ArrayList<>();

        // Iterate through each label and categorize them as input or output signals
        for (String l : labels) {
            if (l.contains("input")) {
                // Extract and process input signals
                String[] inputSignals = l.replace("input", "").trim().split(",");
                for (String signal : inputSignals) {
                    inputSignalList.add(signal.trim());
                }
            } else if (l.contains("output")) {
                // Extract and process output signals
                String[] outputSignals = l.replaceAll("output|;|]", "").trim().split(",");
                for (String signal : outputSignals) {
                    outputSignalList.add(signal.trim());
                }
            }
        }

        // Create Signal objects for input and output signals
        inputSignalsArray = new Signal[inputSignalList.size()];
        outputSignalsArray = new Signal[outputSignalList.size()];
        for (int i = 0; i < inputSignalList.size(); i++) {
            inputSignalsArray[i] = new Signal(inputSignalList.get(i));
        }
        for (int i = 0; i < outputSignalList.size(); i++) {
            outputSignalsArray[i] = new Signal(outputSignalList.get(i));
        }

        // Add input and output signals to the Mealy Machine
        for (int i = 0; i < inputSignalList.size(); i++) {
            mm.addInputSignal(inputSignalsArray[i]);
        }
        for (int i = 0; i < outputSignalList.size(); i++) {
            mm.addOutputSignal(outputSignalsArray[i]);
        }

        // Print information about input and output signals for debugging purposes
        System.out.println("Input Signals from Labels: " + Arrays.toString(inputSignalList.toArray()));
        System.out.println("Output Signals from Labels: " + Arrays.toString(outputSignalList.toArray()));
    }

      /**
     * Getter method to retrieve the MM object.
     *
     * @return Mealy Machine object.
     */
    public MM getMealyMachine() {
        return mm;
    }

    **
     * Method to close the Dot file.
     * Closes the FileInputStream used for reading the Dot file.
     */
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
