package Core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Exceptions.AutomataException;

public class FileAutomata {

    private String RUTA_ARCHIVO = "src/automata.txt";
    private final static String SEPARATOR = "#";
    private final static String SEPARATOR_ATTRIBUTE = ",";
    private BufferedReader documentReader = null;
    private AFD automata;
    private ArrayList<String> attributes;

    public FileAutomata() {
        this.automata = new AFD();
        this.attributes = new ArrayList<>();
    }

    public void readAutomata() throws IOException {
        try {
            this.documentReader = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String line = "";
            line = documentReader.readLine();
            line = documentReader.readLine();

            String[] fileData = line.split(SEPARATOR);
            for (String data : fileData) {
                data = data.trim();

                if (data.contains(";")) {
                    data = data.substring(0, data.length() - 1);
                    // System.out.println(data);
                    attributes.add(data);
                    documentReader.close();
                    return;
                } else {
                    attributes.add(data);
                    // System.out.println(data);
                }
            }

        } catch (Exception ex) {
            System.out.println("Ocurrio un problema al parsear el archivo automata.txt, verifique la sintaxis " + ex);

        } finally {
            if (null != documentReader) {
                documentReader.close();
            }
        }
    }

    public void initializeAFD() throws AutomataException {

        String[] alphabet = attributes.get(0).split(SEPARATOR_ATTRIBUTE);
        String[] finalStates = attributes.get(1).split(SEPARATOR_ATTRIBUTE);
        String[] listTransitions = attributes.get(2).split(SEPARATOR_ATTRIBUTE+SEPARATOR_ATTRIBUTE);
        int initState = Integer.valueOf(attributes.get(3));
        int numStates = Integer.valueOf(attributes.get(4));

        automata.createAlphabet(alphabet);
        automata.addStates(numStates);
        automata.addFinalStates(finalStates);

        for(String transition: listTransitions){
            transition = transition.replaceAll("[()]", "");
            String[] transitionAttributes = transition.split(SEPARATOR_ATTRIBUTE);
            
            automata.newTransition(Integer.valueOf(transitionAttributes[0].trim()), transitionAttributes[1].trim(), Integer.valueOf(transitionAttributes[2].trim()));
            
        }
        automata.setInitialState(initState);

    }

    public AFD getAutomata() {
        return automata;
    }

    public void setAutomata(AFD automata) {
        this.automata = automata;
    }

    
}
