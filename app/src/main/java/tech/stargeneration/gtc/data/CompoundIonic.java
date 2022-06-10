package tech.stargeneration.gtc.data;

import tech.stargeneration.gtc.models.Compound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CompoundIonic {

    Compound ionic1 = new Compound("NaCl", "Sodium Chloride");
    Compound ionic2 = new Compound("KBr", "Potassium Bromide");
    Compound ionic3 = new Compound("CaI2", "Calcium Iodide");
    Compound ionic4 = new Compound("CsF", "Cesium Fluoride");
    Compound ionic5 = new Compound("LiCl", "Lithium Chloride");
    Compound ionic6 = new Compound("KI", "Potassium Iodide");
    Compound ionic7 = new Compound("NaF", "Sodium Fluoride");
    Compound ionic8 = new Compound("NaHCO3", "Sodium Bicarbonate");
    Compound ionic9 = new Compound("Na2CO3", "Sodium Carbonate");
    Compound ionic10 = new Compound("NaOCl", "Sodium Hypochlorite");

    public ArrayList<String> mixFormula(String formula) {
        Random random = new Random();
        ArrayList<String> formulasToDisplay = new ArrayList<>();
        formulasToDisplay.add(formula);

        String formulaToMix = formula;
        int formulaLength = formula.length();

        for (int i = 0; i < 3; i++) {
            StringBuilder formulaMixed = new StringBuilder();
            for (int j = 0; j < formula.length(); j++) {
                char randomCharacter = formulaToMix.charAt(random.nextInt(formulaLength));
                int randomCharacterIndex = formulaToMix.indexOf(randomCharacter);
                formulaToMix = formulaToMix.substring(0, randomCharacterIndex)
                        + formulaToMix.substring(randomCharacterIndex + 1, formulaLength);

                formulaLength -= 1;
                formulaMixed.append(randomCharacter);
            }
            formulasToDisplay.add(formulaMixed.toString());
            formulaToMix = formula;
            formulaLength = formula.length();
        }
        Collections.shuffle(formulasToDisplay);
        return formulasToDisplay;
    }

    public ArrayList<Compound> getIonicCompounds() {
        ArrayList<Compound> ionicCompounds = new ArrayList<>();

        ionicCompounds.add(ionic1);
        ionicCompounds.add(ionic2);
        ionicCompounds.add(ionic3);
        ionicCompounds.add(ionic4);
        ionicCompounds.add(ionic5);
        ionicCompounds.add(ionic6);
        ionicCompounds.add(ionic7);
        ionicCompounds.add(ionic8);
        ionicCompounds.add(ionic9);
        ionicCompounds.add(ionic10);

        Collections.shuffle(ionicCompounds);
        return ionicCompounds;
    }
}
