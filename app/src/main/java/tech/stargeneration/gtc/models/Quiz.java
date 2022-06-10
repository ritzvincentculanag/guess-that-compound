package tech.stargeneration.gtc.models;

import java.util.ArrayList;

public class Quiz {

    private final Compound compoundToGuess;
    private final ArrayList<String> compoundChoices;

    public Quiz(Compound compoundToGuess, ArrayList<String> compoundChoices) {
        this.compoundToGuess = compoundToGuess;
        this.compoundChoices = compoundChoices;
    }

    public Compound getCompoundToGuess() {
        return compoundToGuess;
    }

    public ArrayList<String> getCompoundChoices() {
        return compoundChoices;
    }
}
