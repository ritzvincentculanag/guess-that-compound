package tech.stargeneration.gtc.screens;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tech.stargeneration.gtc.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button startBtn = findViewById(R.id.btnStart);
        final Button learnBtn = findViewById(R.id.btnLearn);

        final Intent chooseCompounds = new Intent(this, ChooseCompunds.class);
        final Intent learnSection = new Intent(this, ChooseCompunds.class);

        startBtn.setOnClickListener(action -> {
            startActivity(chooseCompounds);
        });
    }
}