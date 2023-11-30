// Package declaration for the test class 
package org.mncomp.mmtranslator.DotParser;

// Import statements for required classes and methods
import org.mncomp.mmtranslator.MM.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the DotParser class.
 */
class DotParserTest {

     /**
     * Test the parseDotFile method of the DotParser class.
     */
    @Test
    void parseDotFile() {
        // Arrange
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", new MM());

        // Act and Assert
        assertDoesNotThrow(() -> dotParser.parseDotFile("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot"));
        assertNotNull(dotParser.getMealyMachine());
    }
    **
     * Test the getMealyMachine method of the DotParser class.
     */
    @Test
    void getMealyMachine() {
        // Arrange
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", new MM());

        // Act
        MM mealyMachine = dotParser.getMealyMachine();

        // Assert
        assertNotNull(mealyMachine);
    }
    
    /**
     * Test the closeDotFile method of the DotParser class.
     */
    @Test
    void closeDotFile() {
        // Arrange
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", new MM());

        //Act and Assert
        assertDoesNotThrow(dotParser::closeDotFile);
    }
}
