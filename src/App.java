import java.util.Scanner;


import Core.FileAutomata;

public class App {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BOLD = "\033[1;32m"; // GREEN

    public static void main(String[] args) {

        FileAutomata file = new FileAutomata();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        try {
            file.readAutomata();
            file.initializeAFD();

            // file.getAutomata().evaluateWord("10");

            // System.out.println("Inserte una cadena: ");
            // String cadena = scanner.nextLine();

            // System.out.println("================RESULTADO===============");
            // System.out.println(" Cadena: "+ cadena);
            // System.out.println(file.getAutomata().evaluateWord(cadena)
            // ? GREEN_BOLD + " CADENA ACEPTADA" + ANSI_RESET
            // : RED_BOLD + " CADENA RECHAZADA" + ANSI_RESET);
            // System.out.println("========================================");
            // System.out.println("Desea comprobar otra cadena? (S/N)");

            // String salida = scanner.nextLine();
            // if (salida == "N" ) {

            // System.exit(0);

            // }else{
            // System.out.println(salida);
            // System.exit(0);
            // }
            // 1scanner.close();

            do {
                System.out.println("===============PROBAR AFD===============");
                Scanner sd = new Scanner(System.in);
                System.out.println("Inserte la cadena");
                String cadena = sd.nextLine();
                System.out.println("================RESULTADO===============");
                System.out.println(" Cadena: " + cadena);
                System.out.println(file.getAutomata().evaluateWord(cadena)
                        ? GREEN_BOLD + " CADENA ACEPTADA" + ANSI_RESET
                        : RED_BOLD + " CADENA RECHAZADA" + ANSI_RESET);
                System.out.println("========================================");

                cadena = "";

                System.out.println("Desea comprobar otra cadena? (S/N)");
                String option = sd.nextLine();
                switch (option) {
                    case "N":
                        exit = true;
                        break;
                    case "n":
                        exit = true;
                        break;
                }
            } while (!exit);

        } catch (Exception e) {
            System.out.println("Ocurrio un problema al parsear el archivo automata.txt, verifique la sintaxis " + e);
        }

        // AFD automata = new AFD();
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
        // try{
        // String[] alphabet = { "1", "0" };
        // String[] finalStates = { "2", "3"};
        // automata.createAlphabet(alphabet);

        // automata.addStates(4);
        // automata.addFinalStates(finalStates);
        // automata.newTransition(0, "0", 0);
        // automata.newTransition(0, "1", 1);
        // automata.newTransition(1, "1", 1);
        // automata.newTransition(1, "0", 2);
        // automata.newTransition(2, "0", 2);
        // automata.newTransition(2, "1", 3);
        // automata.newTransition(3, "1", 3);
        // automata.newTransition(3, "0", 0);

        // automata.setInitialState(0);

        // System.out.println(automata.evaluateWord("101010")
        // ? GREEN_BOLD + "Palabra ACEPTADA" + ANSI_RESET
        // : RED_BOLD + "NO aceptada" + ANSI_RESET);
        // }catch(AutomataException e){
        // System.out.println(e.getMessage());
        // }
    }

}
