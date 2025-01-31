package zig.ziganshin.fanil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import zig.ziganshin.fanil.R;

public class Second extends AppCompatActivity {

    private EditText afield, bfield, cfield;
    private TextView reslaba, reslabb, reslabc;
    private Button calculateButton, Nazad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        afield = findViewById(R.id.afield);
        bfield = findViewById(R.id.bfield);
        cfield = findViewById(R.id.cfield);
        reslaba = findViewById(R.id.reslaba);
        reslabb = findViewById(R.id.reslabb);
        reslabc = findViewById(R.id.reslabc);
        Nazad = findViewById(R.id.calculateButton2);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonOnClick();
            }
        });

        Nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ButtonOnClick() {
        try {
            float A = Float.parseFloat(afield.getText().toString());
            float B = Float.parseFloat(bfield.getText().toString());
            float C = Float.parseFloat(cfield.getText().toString());

            reslaba.setText(String.valueOf(C));
            reslabb.setText(String.valueOf(A));
            reslabc.setText(String.valueOf(B));
        } catch (NumberFormatException e) {
            reslaba.setText("Ошибка ввода");
            reslabb.setText("Ошибка ввода");
            reslabc.setText("Ошибка ввода");
        }
    }
}
