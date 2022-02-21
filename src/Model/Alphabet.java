package Model;

import java.util.HashMap;
import java.util.Map;

import Exceptions.AutomataException;

public class Alphabet {

    private Map<String, String> symbols;

    public Alphabet() {
        this.symbols = new HashMap<String, String>();
    }

    public void addSymbols(String[] symbols) throws AutomataException {
        for (String symbol : symbols) {
            if (symbol.length() == 1) {
                addSymbol(symbol.toLowerCase());
            } else {
                throw new AutomataException("No puede insertar simbolos con esa longitud");
            }
        }
    }

    public boolean belongs(char symbol) {
        return symbols.containsKey(String.valueOf(symbol));
    }

    public void addSymbol(String symbol) {
        symbols.put(symbol, symbol);
    };

    @Override
    public String toString() {
        return symbols.toString();
    }

}