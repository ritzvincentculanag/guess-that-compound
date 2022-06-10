package tech.stargeneration.gtc.screens;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tech.stargeneration.gtc.R;

public class ShowScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        Bundle extras = getIntent().getExtras();
        TextView scoreView = findViewById(R.id.scoreView);
        TextView message = findViewById(R.id.message);
        String messageToShow;

        int score = extras.getInt("QUIZ_SCORE");

        if (score <= 5) {
            messageToShow = "Again!";
        } else if (score <=8) {
            messageToShow = "Nice!";
        } else {
            messageToShow = "Good job!";
        }

        message.setText(messageToShow);
        scoreView.setText(score + "/10");
    }
}