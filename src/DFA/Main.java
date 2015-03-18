package dfa;

import dfa.generator.RandomDFA;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, DFAState> dfa = RandomDFA.generate(10, 2, 0.2);

        DFAWriter.writeToFile("dfa", dfa);
    }
}

