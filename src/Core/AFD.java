package Core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Exceptions.AutomataException;
import Model.Alphabet;
import Model.Transition;

public class AFD {
    private Alphabet alphabet;
    private List<Integer> states;
    private List<Transition> transitions;
    private Set<Integer> finalStates;
    private int statePosition;
    private int initialState;

    public AFD() {
        setStates(new ArrayList<Integer>());
        setFinalStates(new HashSet<Integer>());
        setTransitions(new ArrayList<Transition>());

    }

    public void addStates(int numStates) {
        for (int i = 0; i < numStates; i++) {
            states.add(i);
        }
    }

    public void createAlphabet(String[] symbols) throws AutomataException {
        this.alphabet = new Alphabet();
        this.alphabet.addSymbols(symbols);
    }

    public boolean belongsToStatesList(int state) {
        return states.contains(state);
    }

    public boolean belongsToAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!alphabet.belongs(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidWord(String word) {
        if (belongsToAlphabet(word)) {
            return true;
        } else {
            return false;
        }
    }

    public void setInitialState(int initState) throws AutomataException{
        if(belongsToStatesList(initState)){
            setStatePosition(initState);
            this.initialState = initState;
        }else{
            throw new AutomataException("El estado " + initState + " no pertenece a los estados del automata");
        }
    };

    public void newTransition(int state, String symbol, int nextState) throws AutomataException {

        if (belongsToStatesList(nextState)) {
            this.transitions.add(new Transition(state, symbol, nextState));
        } else {
            throw new AutomataException("El estado " + nextState + " no pertenece a los estados del automata");
        }
    }

    public void addFinalStates(String[] finalStates) throws AutomataException {
        for (String finalState : finalStates) {
            int finalStateNumber = Integer.parseInt(finalState);

            if (finalStateNumber > 0 && finalStateNumber < getStates().size()) {
                if (belongsToStatesList(finalStateNumber)) {
                    this.finalStates.add(finalStateNumber);
                } else {
                    throw new AutomataException(
                            "El estado " + finalStateNumber + " no pertenece a los estados del automata");
                }
            } else {
                throw new AutomataException("El estado " + finalStateNumber + "  no es valido");
            }
        }
    }

    protected int nextState(int currentPosition, String symbol) {
        for (Transition transition : transitions) {
            if (transition.getCurrentState() == currentPosition && transition.getSymbol().equals(symbol)) {
                return transition.getNextState();
            }
        }
        return 0;
    }

    public boolean acceptWord(int statePosition) {
        return finalStates.contains(statePosition);
    };

    public boolean evaluateWord(String word) throws AutomataException {

        if (!isValidWord(word)) {
            throw new AutomataException("Verifique la cadena");
        }
        setStatePosition(initialState);

        String currentSymbol;

        for (int i = 0; i < word.length(); i++) {
            currentSymbol = String.valueOf(word.charAt(i));

            this.statePosition = nextState(this.statePosition, currentSymbol);

        }
        if (acceptWord(this.statePosition)) {
            return true;
        }

        return false;
    };

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public List<Integer> getStates() {
        return states;
    }

    public void setStates(List<Integer> states) {
        this.states = states;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public Set<Integer> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(Set<Integer> finalStates) {
        this.finalStates = finalStates;
    }

    public int getStatePosition() {
        return statePosition;
    }

    public void setStatePosition(int statePosition) {
        this.statePosition = statePosition;
    }

}