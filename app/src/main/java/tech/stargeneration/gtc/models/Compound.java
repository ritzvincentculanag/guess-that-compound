package tech.stargeneration.gtc.models;

public class Compound {

    private final String formula;
    private final String name;

    public Compound(String formula, String name) {
        this.formula = formula;
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public String getName() {
        return name;
    }
}
