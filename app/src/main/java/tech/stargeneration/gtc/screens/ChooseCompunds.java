package tech.stargeneration.gtc.screens;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import tech.stargeneration.gtc.R;

public class ChooseCompunds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_compunds);

        RelativeLayout btnIonic = findViewById(R.id.btnIonic);
        TextView textView = findViewById(R.id.textView);

        btnIonic.setOnClickListener(event -> {
            textView.setText("Ionic");
        });
    }
}