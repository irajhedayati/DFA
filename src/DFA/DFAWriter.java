package dfa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by iraj on 3/4/2015.
 */
public class DFAWriter {

    public static void writeToFile(String filename, HashMap<Integer, DFAState> dfa) {

        try {
            File file = new File(filename);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Map.Entry<Integer, DFAState> state : dfa.entrySet()) {
                int source = state.getKey();
                DFAState dfaState = state.getValue();
                for (Map.Entry<String, Integer> transition : dfaState.getTransitions().entrySet()) {
                    String alphabet = transition.getKey();
                    int target = transition.getValue();
                    String line = source + "\t" + alphabet + "\t" + target;
                    line += "\t" + (dfaState.getStatus().contains(StateAttributes.FINAL) ? 1 : 0);
                    line += "\t" + (dfa.get(target).getStatus().contains(StateAttributes.FINAL) ? 1 : 0);
                    bw.write(line);
                    bw.newLine();
                }
            }

            bw.close(); fw.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
