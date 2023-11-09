package org.mncomp.mmtranslator;
import org.mncomp.mmtranslator.MM.MM;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
import org.mncomp.mmtranslator.Signal.Signal;
import org.mncomp.mmtranslator.Kiss2Writer.Kiss2Writer;
import org.mncomp.mmtranslator.DotParser.DotParser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class MMTranslaltor
{

    public static void main( String[] args ) throws IOException {
        MM mealy = new MM();
        DotParser dp = new DotParser("/Users/fateme/Documents/mmtranslator/src/mmtranslator/src/dot0.dot",mealy);
        Kiss2Writer kw = new Kiss2Writer("/Users/fateme/Documents/mmtranslator/src/mmtranslator/src/bbara.kiss2",mealy);

        try {
            dp.parseDotFile("/Users/fateme/Documents/mmtranslator/src/mmtranslator/src/dot0.dot");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        kw.writeKiss2(mealy);
     //   kw.closeKiss2File();
        dp.getMealyMachine();
        dp.closeDotFile();




    }
}
