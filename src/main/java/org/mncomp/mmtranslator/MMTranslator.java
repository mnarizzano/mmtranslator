/**
 * This file contains the definition of the MMTranslator class.
 * The MMTranslator class is responsible for translating a Mealy Machine
 * defined in a Dot file into a Kiss2 file format. It uses instances of
 * DotParser and Kiss2Writer for parsing Dot files and generating Kiss2 files
 * based on the structure of a Mealy Machine.
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator;

import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.Kiss2Translator.Kiss2Writer;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.util.HashMap;

public class MMTranslator {
    private DotParser dotParser;
    private Kiss2Writer kiss2Writer;
    private HashMap<String, State> states;
    private HashMap<Integer, Transition> transitions;

    /**
     * Constructor for MMTranslator class.
     *
     * @param dotParser   Instance of DotParser to parse Dot files.
     * @param kiss2Writer Instance of Kiss2Writer to write Kiss2 files.
     */
    public MMTranslator(DotParser dotParser, Kiss2Writer kiss2Writer) {
        this.dotParser = dotParser;         // Initialize DotParser instance
        this.kiss2Writer = kiss2Writer;     // Initialize Kiss2Writer instance
        this.states = new HashMap<>();      // Initialize HashMap for states
        this.transitions = new HashMap<>(); // Initialize HashMap for transitions
    }

    /**
     * Translates a Dot file into a Kiss2 file.
     *
     * @param inputFilePath  Path to the input Dot file.
     * @param outputFilePath Path to the output Kiss2 file.
     * @throws IOException If an error occurs during file parsing or writing.
     */
    public void translate(String inputFilePath, String outputFilePath) throws IOException {
        dotParser.parse(inputFilePath, states, transitions);        // Parse Dot file
        kiss2Writer.writeKissFile(outputFilePath, states, transitions); // Write Kiss2 file
    }

    /**
     * Adds a state to the internal states HashMap.
     *
     * @param state The State object to add.
     */
    public void addState(State state) {
        states.put(state.getStateName(), state); // Add state to HashMap
    }

    /**
     * Adds a transition to the internal transitions HashMap.
     *
     * @param transition The Transition object to add.
     */
    public void addTransition(Transition transition) {
        transitions.put(transition.getId(), transition); // Add transition to HashMap
    }

    /**
     * Retrieves a state from the internal states HashMap based on its name.
     *
     * @param name The name of the state to retrieve.
     * @return The State object corresponding to the given name, or null if not found.
     */
    public State getState(String name) {
        return states.get(name); // Retrieve state from HashMap by name
    }

    /**
     * Retrieves a transition from the internal transitions HashMap based on its ID.
     *
     * @param id The ID of the transition to retrieve.
     * @return The Transition object corresponding to the given ID, or null if not found.
     */
    public Transition getTransition(int id) {
        return transitions.get(id); // Retrieve transition from HashMap by ID
    }

    /**
     * Main method to execute the MMTranslator functionality.
     * It translates a Dot file to a Kiss2 file based on the provided command-line arguments.
     *
     * @param args Command-line arguments containing input and output file paths.
     */
    public static void main(String[] args) {
        String inputFilePath;
        String outputFilePath;

        // Check if command-line arguments are provided
        if (args.length == 2) {
            inputFilePath = args[0];    // First argument is input Dot file path
            outputFilePath = args[1];   // Second argument is output Kiss2 file path
        } else {
            // Print usage instructions if arguments are not provided
            System.out.println("Usage: MMTranslator from dot to kiss2");
            // For testing purposes, use default file paths (change as needed)
            inputFilePath = "src/dot1.dot";
            outputFilePath = "src/kiss1.kiss2";
        }

        // Create MMTranslator instance with default DotParser and Kiss2Writer
        MMTranslator translator = new MMTranslator(new DotParser(), new Kiss2Writer());

        // Perform translation and handle potential IOException
        try {
            translator.translate(inputFilePath, outputFilePath);
            System.out.println("Translation completed successfully.");
        } catch (IOException e) {
            System.err.println("Error during translation: " + e.getMessage());
        }
    }
}
