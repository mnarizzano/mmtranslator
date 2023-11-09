//
package org.mncomp.mmtranslator.Kiss2Writer;
import org.mncomp.mmtranslator.MM.MM;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Transition.Transition;
import org.mncomp.mmtranslator.Signal.Signal;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Kiss2Writer {
    private BufferedWriter fileWriter;
    private MM mealyMachine;
   /* public Kiss2Writer(String filePath) {
        try {
            fileWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public Kiss2Writer(String filePath, MM mealyMachine) {
        try {
            fileWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mealyMachine = mealyMachine;
    }
    public void writeKiss2(MM mealyMachine) {
        try {
            fileWriter.write(".i " + mealyMachine.getInputSignals().size());
            fileWriter.newLine();
            fileWriter.write(".o " + mealyMachine.getOutputSignals().size());
            fileWriter.newLine();
            fileWriter.write(".s " + mealyMachine.getAllStates().size());
            fileWriter.newLine();
//            fileWriter.write(".r " + mealyMachine.getResetState().getStateName());
            fileWriter.newLine();
            fileWriter.write(".p " + mealyMachine.getAllTransitions().size());
            fileWriter.newLine();
            for (Signal signal : mealyMachine.getInputSignals()) {
                fileWriter.write(".v " + signal.getSignalName());
                fileWriter.newLine();
            }
            for (Signal signal : mealyMachine.getOutputSignals()) {
                fileWriter.write(".v " + signal.getSignalName());
                fileWriter.newLine();
            }
            System.out.println("Input Signals: " + mealyMachine.getInputSignals().size());
            System.out.println("Output Signals: " + mealyMachine.getOutputSignals().size());
            System.out.println("Number of States: " + mealyMachine.getAllStates().size());
            System.out.println("Number of Transitions: " + mealyMachine.getAllTransitions().size());

            // Write state definitions
            for (State state : mealyMachine.getAllStates()) {
                fileWriter.write(state.getStateName());
                fileWriter.newLine();
            }
            // Write transitions
            for (Transition transition : mealyMachine.getAllTransitions()) {
                String input = String.join("", transition.getInputSignals().toString());
                String output = String.join("", transition.getOutputSignals().toString());
                String line = transition.getStateFrom().getStateName() + " " + input + " " + output + " " + transition.getStateTo().getStateName();
                fileWriter.write(line);
                fileWriter.newLine();
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeKiss2File() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
