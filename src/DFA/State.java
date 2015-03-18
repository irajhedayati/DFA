package dfa;

import java.util.ArrayList;

/**
 * Class to keep information of each state
 * <p>Each state has the following information:
 * <ul>
 *     <li>ID</li>
 *     <li>Label</li>
 *     <li>Attributes: the attribute is list of
 *     elements came from an ENUM called
 *     <code>dfa.StateAttributes</code></li>
 * </ul>
 * </p>
 * Created by iraj on 3/4/2015.
 *
 * @see StateAttributes
 */
public class State {

    public int id;
    public String label;
    private ArrayList<StateAttributes> status;

    /**
     * Instantiate an empty state of automaton.
     * <p>The ID of this state would be <code>-1</code>
     *  and with no label. It also doesn't have any
     *  attribute by default.</p>
     *
     *  @see StateAttributes
     */
    public State(){
        this.status = new ArrayList<StateAttributes>();
        this.id = -1;
        this.label = "";
    }

    /**
     * Instantiate an empty state of automaton.
     *
     * Example:<br />
     * <code>dfa.State aState = new dfa.State(1, "A", new ArrayList(){
     *                                              dfa.StateAttributes.INITIAL,
     *                                              dfa.StateAttributes.UNREACHABLE
     * })</code>
     * will create state A as initial and unreachable.
     *
     * @param id The ID of the state
     * @param label The associated label for this state
     * @param c_status List of state attributes can be associated to this state
     * @see StateAttributes
     */
    public State(int id, String label, ArrayList<StateAttributes> c_status) {
        this.status = c_status;
        this.id = id;
        this.label = label;
    }

    public ArrayList<StateAttributes> getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        String _result = "";
        _result += "ID: " + this.id + ", ";
        _result += "Label: " + this.label + ", ";
        _result += "States: ";
        if(this.status.size() > 0) {
            for (StateAttributes sa : this.status) {
                _result += sa.toString() + ";";
            }
            _result = _result.substring(0, _result.length() - 1);
        }else{
            _result += "NORMAL";
        }
        return _result;
    }
}
