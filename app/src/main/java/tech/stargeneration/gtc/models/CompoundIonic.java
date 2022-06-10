package tech.stargeneration.gtc.models;

import java.util.ArrayList;
import java.util.Random;

public class CompoundIonic {

    Compound ionic1 = new Compound("NaCl", "sodium chloride");
    Compound ionic2 = new Compound("KBr", "potassium bromide");
    Compound ionic3 = new Compound("CaI2", "calcium iodide");
    Compound ionic4 = new Compound("CsF", "cesium fluoride");
    Compound ionic5 = new Compound("LiCl", "lithium chloride");

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
//        Random random = new Random();
//        ArrayList<String> formulasToDisplay = new ArrayList<>();
//        String formulaToMix = formula;
//        formulasToDisplay.add(formula);
//
//        for (int i = 0; i < 3; i++) {
//            StringBuilder mixedFormula = new StringBuilder();
//            int formulaLength = formula.length();
//            for (int j = 0; j < formula.length(); j++) {
//                char randomElement = formula.charAt(random.nextInt(formulaLength));
//                formulaToMix = formulaToMix.substring(0, )
//                mixedFormula.append(randomElement);
//                formulaLength -= 1;
//            }
//            formulasToDisplay.add(mixedFormula.toString());
//        }
        return formulasToDisplay;
    }
}
