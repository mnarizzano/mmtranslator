/**
 * This file contains the definition of the Kiss2Translator class.
 * The Kiss2Translator class coordinates the parsing of Dot files
 * and the writing of Kiss2 files using a DotParser and Kiss2Writer.
 * It facilitates the translation process between these formats.
 *
 * The class maintains instances of DotParser and Kiss2Writer to perform
 * the specific tasks of parsing Dot files and generating Kiss2 files
 * based on the parsed data.
 *
 * @author FatemeOzgoli
 * @since 2022
 */
package org.mncomp.mmtranslator.Kiss2Translator;

import org.mncomp.mmtranslator.DotParser.DotParser;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;

import java.io.IOException;
import java.util.HashMap;

public class Kiss2Translator {
    private DotParser dotParser;      // Instance of DotParser for parsing Dot files
    private Kiss2Writer kiss2Writer;  // Instance of Kiss2Writer for writing Kiss2 files

    /**
     * Constructs a Kiss2Translator object with the specified DotParser and Kiss2Writer instances.
     *
     * @param dotParser The DotParser instance used for parsing Dot files.
     * @param kiss2Writer The Kiss2Writer instance used for writing Kiss2 files.
     */
    public Kiss2Translator(DotParser dotParser, Kiss2Writer kiss2Writer) {
        this.dotParser = dotParser;        // Initialize DotParser instance
        this.kiss2Writer = kiss2Writer;    // Initialize Kiss2Writer instance
    }

    /**
     * Parses a Dot file located at the specified inputFilePath using the DotParser instance.
     * Updates the states and transitions HashMaps with parsed state and transition information.
     *
     * @param inputFilePath The path to the Dot file to parse.
     * @param states A HashMap containing states identified by their names.
     * @param transitions A HashMap containing transitions identified by their IDs.
     * @throws IOException If there is an error reading or parsing the Dot file.
     */
    public void parseDotFile(String inputFilePath, HashMap<String, State> states, HashMap<Integer, Transition> transitions) throws IOException {
        dotParser.parse(inputFilePath, states, transitions);  // Invoke parse method of DotParser
    }

    /**
     * Writes a Kiss2 file to the specified outputFilePath using the Kiss2Writer instance.
     * The file content is generated based on the provided states and transitions HashMaps.
     *
     * @param outputFilePath The path where the Kiss2 file will be written.
     * @param states A HashMap containing states identified by their names.
     * @param transitions A HashMap containing transitions identified by their IDs.
     * @throws IOException If there is an error writing the Kiss2 file.
     */
    public void writeKissFile(String outputFilePath, HashMap<String, State> states, HashMap<Integer, Transition> transitions) throws IOException {
        kiss2Writer.writeKissFile(outputFilePath, states, transitions);  // Invoke writeKissFile method of Kiss2Writer
    }
}
