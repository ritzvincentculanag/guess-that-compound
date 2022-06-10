package tech.stargeneration.gtc.screens;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import tech.stargeneration.gtc.R;
import tech.stargeneration.gtc.models.Compound;
import tech.stargeneration.gtc.data.CompoundIonic;

import java.util.ArrayList;
import java.util.Random;

public class TakeQuiz extends AppCompatActivity {

    // Additional information
    private Bundle extras;
    private int result;

    // For quiz
    private Random random;
    private CompoundIonic ionic;
    private ArrayList<Compound> quiz;
    private AlertDialog.Builder builder;

    // For UI
    private TextView timer;
    private TextView compoundFormula;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private Button[] choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

        extras = getIntent().getExtras();
        result = extras.getInt("QUIZ_TYPE");

        random = new Random();
        ionic = new CompoundIonic();
        quiz = result == 0 ? ionic.getIonicCompounds() : new ArrayList<>();
        builder = new AlertDialog.Builder(this);

        timer = findViewById(R.id.timer);
        compoundFormula = findViewById(R.id.compoundFormula);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        choices = new Button[]{
                choice1,
                choice2,
                choice3,
                choice4,
        };

        showNextQuestion();
    }

    private void showAlertDialog(String title, String message) {
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Nice!", (dialogInterface, i) -> showNextQuestion());
        builder.setCancelable(false);
        builder.show();
    }

    private void showNextQuestion() {
        int randomQuiz = random.nextInt(quiz.size());
        Compound quizToShow = quiz.get(randomQuiz);
        ArrayList<String> formulasToShow = ionic.mixFormula(quizToShow.getFormula());

        compoundFormula.setText(quizToShow.getName());
        for (int i = 0; i < formulasToShow.size(); i++) {
            choices[i].setText(formulasToShow.get(i));
        }

        quiz.remove(quizToShow);
    }

    private void checkAnswer(View view) {
        Button buttonPressed = findViewById(view.getId());
        String buttonPressedText = String.valueOf(buttonPressed.getText());
    }
}