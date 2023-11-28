package org.mncomp.mmtranslator;
import org.mncomp.mmtranslator.MM.*;
import org.mncomp.mmtranslator.DotParser.*;
import org.mncomp.mmtranslator.Kiss2Writer.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MMTranslatorTest {

    @Test
    void main() {
        // Create an instance of MM (Mealy Machine) for testing
        // You may need to adjust this based on the actual MM class structure
        MM mm = new MM();

        // Create an instance of DotParser for testing
        DotParser dp = new DotParser("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot", mm);

        // Create an instance of Kiss2Writer for testing
        Kiss2Writer kw = new Kiss2Writer("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/bbara.kiss2", mm);

        try {
            // Parse the Dot file to populate the Mealy Machine
            dp.parseDotFile("/Users/fateme/Downloads/mmtranslator 3/src/mmtranslator/src/dot0.dot");
        } catch (IOException e) {
            // Handle IOException gracefully or log the error
            throw new RuntimeException(e);
        }

        // Call the main method with the test parameters
        try {
            MMTranslaltor.main(new String[0]);
        } catch (IOException e) {
            // Handle IOException gracefully or log the error
            throw new RuntimeException(e);
        }

        // Add assertions to check the expected behavior

        // Close resources if necessary
        dp.closeDotFile();
    }
}
