package dfa;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by iraj on 3/4/2015.
 */
public class DFAState extends State {

    private HashMap<String, Integer> transitions;

    public DFAState(){
        super();
        transitions = new HashMap<String, Integer>();
    }

    public DFAState(int id, String label, ArrayList<StateAttributes> status) {
        super(id, label,  status);
        transitions = new HashMap<String, Integer>();
    }

    public DFAState(int id, String label, ArrayList<StateAttributes> status, HashMap<String, Integer> transitions) {
        super(id, label,  status);
        this.transitions = transitions;
    }

    public void addTransition(String alphabet, Integer targetID){
        this.transitions.put(alphabet, targetID);
    }

    public HashMap<String, Integer> getTransitions() {
        return transitions;
    }
}
