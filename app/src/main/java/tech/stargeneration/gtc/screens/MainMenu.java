package tech.stargeneration.gtc.screens;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tech.stargeneration.gtc.R;
import tech.stargeneration.gtc.utils.PlaySound;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button startBtn = findViewById(R.id.btnStart);
        final Button learnBtn = findViewById(R.id.btnLearn);

        final Intent chooseCompounds = new Intent(this, ChooseCompounds.class);
        final Intent learnSection = new Intent(this, ChooseCompounds.class);

        final PlaySound playSound = new PlaySound();
        final int btnMenuSound = PlaySound.soundPool.load(this, R.raw.sound_btn_menu, 1);

        // Disable default button sound effect
        startBtn.setSoundEffectsEnabled(false);

        startBtn.setOnClickListener(action -> {
            PlaySound.play(btnMenuSound);
            startActivity(chooseCompounds);
        });
    }
}