import java.util.ArrayList;
import java.util.List;

/**
 * Class to keep information of each state
 * <p>Each state has the following information:
 * <ul>
 *     <li>ID</li>
 *     <li>Label</li>
 *     <li>Attributes: the attribute is list of
 *     elements came from an ENUM called
 *     <code>StateAttributes</code></li>
 * </ul>
 * </p>
 * Created by iraj on 3/4/2015.
 *
 * @see StateAttributes
 */
public class State {

    public int C_id;
    public String C_label;
    private ArrayList<StateAttributes> C_status;

    /**
     * Instantiate an empty state of automaton.
     * <p>The ID of this state would be <code>-1</code>
     *  and with no label. It also doesn't have any
     *  attribute by default.</p>
     *
     *  @see StateAttributes
     */
    public State(){
        this.C_status = new ArrayList<StateAttributes>();
        this.C_id = -1;
        this.C_label = "";
    }

    /**
     * Instantiate an empty state of automaton.
     *
     * Example:<br />
     * <code>State aState = new State(1, "A", new ArrayList(){
     *                                              StateAttributes.INITIAL,
     *                                              StateAttributes.UNREACHABLE
     * })</code>
     * will create state A as initial and unreachable.
     *
     * @param id
     * @param label
     * @param c_status
     * @see StateAttributes
     */
    public State(int id, String label, ArrayList<StateAttributes> c_status) {
        this.C_status = c_status;
        this.C_id = id;
        this.C_label = label;
    }

    @Override
    public String toString(){
        String _result = "";
        _result += "ID: " + this.C_id + ", ";
        _result += "Label: " + this.C_label + ", ";
        _result += "States: ";
        if(this.C_status.size() > 0) {
            for (StateAttributes sa : this.C_status) {
                _result += sa.toString() + ";";
            }
            _result = _result.substring(0, _result.length() - 1);
        }else{
            _result += "NORMAL";
        }
        return _result;
    }
}
