package tech.stargeneration.gtc.screens;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

    // For timer
    private final long START_TIME_IN_MILLIS = 16000;
    private TextView timer;
    private Color timerColor;
    private CountDownTimer countDownTimer;
    private boolean timerIsRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    // For quiz
    private Random random;
    private QuizIonic quizIonic;
    private ArrayList<Quiz> quiz;
    private AlertDialog.Builder builder;
    private Quiz quizToShow;
    private ArrayList<String> formulasToShow;
    private int score = 0;

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

        timer = findViewById(R.id.timer);

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
        for (Button button : choices) {
            button.setOnClickListener(this::checkAnswer);
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis = l;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                timerIsRunning = false;
            }
        }.start();

        timerIsRunning = true;
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerIsRunning = false;
    }

    private void resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateTimerText();
    }

    private void updateTimerText() {
        int timeLeft = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.valueOf(timeLeft);

        if (timeLeft == 0) {
            pauseTimer();
            showAlertDialog("Result", "Time's up!");
        } else if (timeLeft <= 10) {
            if (timeLeft % 2 == 0) {
                timer.setTextColor(ContextCompat.getColor(TakeQuiz.this, R.color.red_500));
            } else {
                timer.setTextColor(ContextCompat.getColor(TakeQuiz.this, R.color.black_500));
            }
        } else {
            timer.setTextColor(ContextCompat.getColor(TakeQuiz.this, R.color.black_500));
        }

        timer.setText(timeLeftFormatted);
    }

    private void showAlertDialog(String title, String message) {
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Ok!", (dialogInterface, i) -> {
            resetTimer();
            showNextQuestion();
        });
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
        startTimer();
    }

    private void checkAnswer(View view) {
        if (timerIsRunning) {
            pauseTimer();

            if (quiz.size() == 0) {
                Intent showScore = new Intent(this, ShowScore.class);
                showScore.putExtra("QUIZ_SCORE", score);
                startActivity(showScore);
            } else {
                Button buttonPressed = findViewById(view.getId());
                String buttonPressedText = buttonPressed.getText().toString();
                String correctAnswer = quizToShow.getCompoundToGuess().getFormula();

                if (buttonPressedText.equals(correctAnswer)) {
                    score += 1;
                    showAlertDialog("Result", "Correct!");
                } else {
                    showAlertDialog("Result", "Better luck next time!");
                }
            }
        }
    }
}