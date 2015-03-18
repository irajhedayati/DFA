package dfa;

public class Transition {

    private State source;
    private State target;
    private String alphabet;

    public Transition(){
        this.source = new State();
        this.target = new State();
        this.alphabet = "";
    }

    public Transition(State source, String alphabet, State target){
        this.source = source;
        this.alphabet = alphabet;
        this.target = target;
    }

    public State getSource() {
        return source;
    }

    public State getTarget() {
        return target;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setSource(State source) {
        this.source = source;
    }

    public void setTarget(State target) {
        this.target = target;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }
}
