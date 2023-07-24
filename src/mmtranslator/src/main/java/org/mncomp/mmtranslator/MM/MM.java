
package org.mncomp.mmtranslator.MM;
import java.io.IOException;
import org.mncomp.mmtranslator.DotParser.*;
import org.mncomp.mmtranslator.State.State;
import org.mncomp.mmtranslator.Signal.Signal;
import org.mncomp.mmtranslator.Transition.Transition;

public class MM {
    private MealyMachine mealyMachine;
    private int id;
    private int stateno;

    public MM() {
        mealyMachine = new MealyMachine();
    }

    public int getStateNom(int id) {
        return stateno;
    }

    public void loadFromDotFile(String filePath) throws IOException {
        DotParser parser = new DotParser();
        Graph graph = parser.parse(filePath);

        // Convert the Graph object into your Mealy Machine representation
        // For example, add states, transitions, and outputs to your Mealy Machine
        for (Node node : graph.getNodes()) {
            String name = node.getName();
            boolean isInit = node.isInitial();
            State state = new State(name, isInit);
            mealyMachine.addState(state);
        }

        for (Edge edge : graph.getEdges()) {
            State from = mealyMachine.getStateByName(edge.getFrom());
            State to = mealyMachine.getStateByName(edge.getTo());
            Signal[] inputSignals = new Signal[edge.getInputSignals().length];
            Signal[] outputSignals = new Signal[edge.getOutputSignals().length];

            for (int i = 0; i < edge.getInputSignals().length; i++) {
                String inputName = edge.getInputSignals()[i];
                Signal inputSignal = mealyMachine.getSignalByName(inputName);
                if (inputSignal == null) {
                    inputSignal = new Signal(inputName, SignalType.INPUT);
                    mealyMachine.addSignal(inputSignal);
                }
                inputSignals[i] = inputSignal;
            }

            for (int i = 0; i < edge.getOutputSignals().length; i++) {
                String outputName = edge.getOutputSignals()[i];
                Signal outputSignal = mealyMachine.getSignalByName(outputName);
                if (outputSignal == null) {
                    outputSignal = new Signal(outputName, SignalType.OUTPUT);
                    mealyMachine.addSignal(outputSignal);
                }
                outputSignals[i] = outputSignal;
            }

            Transition transition = new Transition(from, to, inputSignals, outputSignals);
            mealyMachine.addTransition(transition);
        }
    }
}

