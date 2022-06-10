package tech.stargeneration.gtc.screens;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import tech.stargeneration.gtc.R;
import tech.stargeneration.gtc.data.QuizIonic;
import tech.stargeneration.gtc.models.Compound;
import tech.stargeneration.gtc.data.CompoundIonic;
import tech.stargeneration.gtc.models.Quiz;

import java.util.ArrayList;
import java.util.Random;

public class TakeQuiz extends AppCompatActivity {

    // Additional information
    private Bundle extras;
    private int result;

    // For quiz
    private Random random;
    private QuizIonic quizIonic;
    private ArrayList<Quiz> quiz;
    private AlertDialog.Builder builder;
    private Quiz quizToShow;
    private ArrayList<String> formulasToShow;

    // For UI
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
        quizIonic = new QuizIonic();
        quiz = result == 0 ? quizIonic.getIonicQuiz() : new ArrayList<>();
        builder = new AlertDialog.Builder(this);

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

        initButtons();
        showNextQuestion();
    }

    private void initButtons() {
        for (Button button: choices) {
            button.setOnClickListener(this::checkAnswer);
        }
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
        quizToShow = quiz.get(randomQuiz);
        formulasToShow = quizToShow.getCompoundChoices();

        compoundFormula.setText(quizToShow.getCompoundToGuess().getName());
        for (int i = 0; i < formulasToShow.size(); i++) {
            choices[i].setText(formulasToShow.get(i));
        }

        quiz.remove(quizToShow);
    }

    private void checkAnswer(View view) {
        if (quiz.size() == 0) {

        }
        Button buttonPressed = findViewById(view.getId());
        String buttonPressedText = buttonPressed.getText().toString();
        String correctAnswer = quizToShow.getCompoundToGuess().getFormula();

        if (buttonPressedText.equals(correctAnswer)) {
            showAlertDialog("Result", "Correct!");
        } else {
            showAlertDialog("Result", "Better luck next time!");
        }
    }
}