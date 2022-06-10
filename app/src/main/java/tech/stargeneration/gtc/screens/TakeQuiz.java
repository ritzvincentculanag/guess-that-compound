package tech.stargeneration.gtc.screens;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tech.stargeneration.gtc.R;

public class TakeQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

        Bundle extras = getIntent().getExtras();
        TextView test = findViewById(R.id.test);

        int result = extras.getInt("QUIZ_TYPE");
        if (result == 0) {
            test.setText("Ionic");
        } else {
            test.setText("Covalent");
        }
    }
}