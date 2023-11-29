package org.mncomp.mmtranslator.DotParser;
import org.mncomp.mmtranslator.MM.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DotParserTest {

    @Test
    void parseDotFile() {
        // Arrange
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", new MM());

        // Act and Assert
        assertDoesNotThrow(() -> dotParser.parseDotFile("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot"));
        assertNotNull(dotParser.getMealyMachine());
    }

    @Test
    void getMealyMachine() {
        // Arrange
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", new MM());

        // Act
        MM mealyMachine = dotParser.getMealyMachine();

        // Assert
        assertNotNull(mealyMachine);
    }

    @Test
    void closeDotFile() {
        // Arrange
        DotParser dotParser = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", new MM());

        // Act and Assert
        assertDoesNotThrow(dotParser::closeDotFile);
    }
}
