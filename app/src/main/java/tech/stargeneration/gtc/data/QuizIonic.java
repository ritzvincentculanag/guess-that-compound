package tech.stargeneration.gtc.data;

import tech.stargeneration.gtc.models.Compound;
import tech.stargeneration.gtc.models.Quiz;

import java.util.ArrayList;

public class QuizIonic {

    private CompoundIonic ionic = new CompoundIonic();
    private ArrayList<Compound> ionicCompounds = ionic.getIonicCompounds();
    private ArrayList<Quiz> ionicQuiz = new ArrayList<>();

    Quiz quiz1 = new Quiz(
            ionicCompounds.get(0),
            ionic.mixFormula(ionicCompounds.get(0).getFormula())
    );
    Quiz quiz2 = new Quiz(
            ionicCompounds.get(1),
            ionic.mixFormula(ionicCompounds.get(1).getFormula())
    );
    Quiz quiz3 = new Quiz(
            ionicCompounds.get(2),
            ionic.mixFormula(ionicCompounds.get(2).getFormula())
    );
    Quiz quiz4 = new Quiz(
            ionicCompounds.get(3),
            ionic.mixFormula(ionicCompounds.get(3).getFormula())
    );
    Quiz quiz5 = new Quiz(
            ionicCompounds.get(4),
            ionic.mixFormula(ionicCompounds.get(4).getFormula())
    );
    Quiz quiz6 = new Quiz(
            ionicCompounds.get(5),
            ionic.mixFormula(ionicCompounds.get(5).getFormula())
    );
    Quiz quiz7 = new Quiz(
            ionicCompounds.get(6),
            ionic.mixFormula(ionicCompounds.get(6).getFormula())
    );
    Quiz quiz8 = new Quiz(
            ionicCompounds.get(7),
            ionic.mixFormula(ionicCompounds.get(7).getFormula())
    );
    Quiz quiz9 = new Quiz(
            ionicCompounds.get(8),
            ionic.mixFormula(ionicCompounds.get(8).getFormula())
    );
    Quiz quiz10 = new Quiz(
            ionicCompounds.get(9),
            ionic.mixFormula(ionicCompounds.get(9).getFormula())
    );

    public ArrayList<Quiz> getIonicQuiz() {
        ionicQuiz.add(quiz1);
        ionicQuiz.add(quiz2);
        ionicQuiz.add(quiz3);
        ionicQuiz.add(quiz4);
        ionicQuiz.add(quiz5);
        ionicQuiz.add(quiz6);
        ionicQuiz.add(quiz7);
        ionicQuiz.add(quiz8);
        ionicQuiz.add(quiz9);
        ionicQuiz.add(quiz10);

        return ionicQuiz;
    }
}
