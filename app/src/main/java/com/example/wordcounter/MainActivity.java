package com.example.wordcounter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button enter;
    Spinner choicesSpinner;
    TextCounter counter = new TextCounter();

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.input);
        enter = findViewById(R.id.countButton);
        choicesSpinner = findViewById(R.id.spinner);
        result = findViewById(R.id.result);

        // Array adapter used because spinner choices are in an array
        // The adapter allows the user interface element "spinner" to understand an array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_choices,
                android.R.layout.simple_spinner_item // defines selections appearance.
        );
        // Choose layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // apply the adapter to our spinner
        choicesSpinner.setAdapter(adapter);

        enter.setOnClickListener(v -> {
            String enteredText = text.getText().toString();
            String spinnerSetting = choicesSpinner.getSelectedItem().toString();

            if (enteredText.isEmpty()) {
                Toast.makeText(this, R.string.enter_text, Toast.LENGTH_SHORT).show();
                return;
            }

            int num = 0;

            switch (spinnerSetting) {
                case "Sentences":
                    num = counter.countSent(enteredText);
                    break;
                case "Words":
                    num = counter.countWords(enteredText);
                    break;
                case "Chars":
                    num = counter.countChars(enteredText);
                    break;
                case "Numbers":
                    num = counter.countNums(enteredText);
                    break;
            }
            result.setText(getString(R.string.result_text, num, spinnerSetting));
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraint), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}