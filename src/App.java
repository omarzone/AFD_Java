import Core.AFD;
import Exceptions.AutomataException;

public class App {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BOLD = "\033[1;32m"; // GREEN

    public static void main(String[] args) {

        AFD automata = new AFD();
        // String[] alphabet = { "1", "0" };
        // String[] finalStates = { "2" };
        // automata.createAlphabet(alphabet);

        // automata.addStates(3);
        // automata.addFinalStates(finalStates);
        // automata.newTransition(0, "1", 0);
        // automata.newTransition(0, "0", 1);
        // automata.newTransition(1, "0", 1);
        // automata.newTransition(1, "1", 2);
        // automata.newTransition(2, "1", 2);
        // automata.newTransition(2, "0", 2);

        // AFD que acepta las palabras en {0,1}* con un número impar de '10'
        try{
            String[] alphabet = { "1", "0" };
            String[] finalStates = { "2", "3" };
            automata.createAlphabet(alphabet);
    
            automata.addStates(4);
            automata.addFinalStates(finalStates);
            automata.newTransition(0, "0", 0);
            automata.newTransition(0, "1", 1);
            automata.newTransition(1, "1", 1);
            automata.newTransition(1, "0", 2);
            automata.newTransition(2, "0", 2);
            automata.newTransition(2, "1", 3);
            automata.newTransition(3, "1", 3);
            automata.newTransition(3, "0", 0);
    
            System.out.println(automata.evaluateWord("1111010100000010111110111111111101110")
                    ? GREEN_BOLD + "Palabra ACEPTADA" + ANSI_RESET
                    : RED_BOLD + "NO aceptada" + ANSI_RESET);
        }catch(AutomataException e){
            System.out.println(e.getMessage());
        }
    }

}
