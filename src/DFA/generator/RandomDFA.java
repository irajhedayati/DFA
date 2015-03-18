package dfa.generator;

import dfa.DFAState;
import dfa.StateAttributes;

import java.util.*;
import java.util.Random;
import java.util.Stack;

/**
 * This class will generate a fully random dfa.
 *
 * <p>The method used in this class is starting from
 * the initial state and create random transitions.
 * If new state has been created, it will add it
 * to the a list to explore later. The result is
 * fully connected random dfa.</p>
 *
 * <p>After generating the dfa, there is a probability
 * of not explored states. So, in order to connect them
 * to the dfa, we select one of the connected states
 * randomly and connect one of its transitions to the
 * state and try to explore new state.</p>
 *
 * The input parameters of the class are:
 * <ul>
 *     <li>States</li>
 *     <li>Alphabet Size</li>
 *     <li>Final Rate</li>
 * </ul>
 *
 * Created by iraj on 3/4/2015.
 */
public class RandomDFA {

    /**
     * Generate a random DFA
     * @param states        Number of states
     * @param alphabetSize  Size of Alphabet
     * @param finalDensity Density of final states
     * @return dfa Random generated DFA
     */
    public static HashMap<Integer, DFAState> generate(int states, int alphabetSize, double finalDensity){

        HashMap<Integer, DFAState> _dfa = new HashMap<Integer, DFAState>();
        Stack<DFAState> _todo = new Stack<DFAState>();

        // Create initial state
        _todo.push(new DFAState(0, "0", new ArrayList<StateAttributes>() {{
            add(StateAttributes.INITIAL);
        }}));
        // Generate other states
        while(!_todo.isEmpty()){
            DFAState _local = _todo.pop();

            for(int i = 0; i < alphabetSize; i++) {
                double _forward = new Random().nextDouble();
                int _targetID = 0;
                if (_forward > 0.3) {
                    _targetID = new Random().nextInt(states - _local.getId() + 1);
                    _targetID += _local.getId();
                }else{
                    _targetID = new Random().nextInt(_local.getId());
                }
                _local.addTransition(Integer.toString(i), _targetID);
                if (!exists(_targetID, _dfa) &&
                        !exists(_targetID, _todo) &&
                        _targetID != _local.id) {
                    _todo.push(new DFAState(_targetID, Integer.toString(_targetID),
                            new ArrayList<StateAttributes>() {{
                                add(StateAttributes.NORMAL);
                            }}));
                }
            }
            _dfa.put(_local.getId(), _local);
        }

        // Generate final states
        List<Integer> keys = new ArrayList<Integer>(_dfa.keySet());
        Collections.shuffle(keys);
        for (int i = 0; i < finalDensity * states; i++) {
            //noinspection SuspiciousMethodCalls
            _dfa.get(keys.get(i)).getStatus().add(StateAttributes.FINAL);
        }

        return _dfa;
    }

    /**
     * Checks if an state exists in a DFA
     * @param stateID   ID of desired state
     * @param dfa       Target DFA to search for
     * @return          True if it is there, otherwise false
     */
    protected static boolean exists(int stateID, HashMap<Integer, DFAState> dfa){
        return dfa.containsKey(stateID);
    }

    /**
     * Checks if an state exists in a DFA
     * @param stateID   ID of desired state
     * @param dfa       Target DFA to search for
     * @return          True if it is there, otherwise false
     */
    protected static boolean exists(int stateID, List<DFAState> dfa){
        boolean _result = false;

        for (DFAState state : dfa) {
            if (state.id == stateID) {
                _result = true;
                break;
            }
        }

        return _result;
    }
}
