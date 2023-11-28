package org.mncomp.mmtranslator.Kiss2Writer;
import org.mncomp.mmtranslator.MM.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Kiss2WriterTest {

    @Test
    void writeKiss2() {
        // Create an instance of MM (Mealy Machine) for testing
        // You may need to adjust this based on the actual MM class structure
        MM mm = new MM();

        // Create an instance of Kiss2Writer with a file path and the MM instance
        Kiss2Writer kiss2Writer = new Kiss2Writer("test.kiss2", mm);

        // Call the writeKiss2 method
        kiss2Writer.writeKiss2(mm);

        // Add assertions to check the expected behavior

        // Close the Kiss2 file
        kiss2Writer.closeKiss2File();
    }

    @Test
    void closeKiss2File() {
        // Create an instance of MM (Mealy Machine) for testing
        MM mm = new MM();

        // Create an instance of Kiss2Writer with a file path and the MM instance
        Kiss2Writer kiss2Writer = new Kiss2Writer("test.kiss2", mm);

        // Call the closeKiss2File method
        kiss2Writer.closeKiss2File();

        // Add assertions to check the expected behavior
    }
}
