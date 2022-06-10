package tech.stargeneration.gtc.screens;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tech.stargeneration.gtc.R;

public class ChooseCompounds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_compounds);

        Intent takeQuiz = new Intent(this, TakeQuiz.class);
        RelativeLayout btnIonic = findViewById(R.id.btnIonic);
        RelativeLayout btnCovalent = findViewById(R.id.btnCovalent);

        int takeIonic = 0;
        int takeCovalent = 1;

        btnIonic.setOnClickListener(ionic -> {
            takeQuiz.putExtra("QUIZ_TYPE", takeIonic);
            startActivity(takeQuiz);
        });
        btnCovalent.setOnClickListener(covalent -> {
            takeQuiz.putExtra("QUIZ_TYPE", takeCovalent);
            startActivity(takeQuiz);
        });
    }
}