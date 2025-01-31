package zig.ziganshin.fanil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import zig.ziganshin.fanil.R;

public class MainActivity extends AppCompatActivity {

    EditText Afield;
    EditText Bfield;
    TextView Otvet;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Otvet = findViewById(R.id.textView);
        Afield = findViewById(R.id.Afield);
        Bfield = findViewById(R.id.Bfield);
        Button calculateButton = findViewById(R.id.calculateButton);
        next = findViewById(R.id.button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResults();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Second.class);
                startActivity(intent);
            }
        });
    }

    private void calculateResults() {
        String aText = Afield.getText().toString();
        String bText = Bfield.getText().toString();

        if (aText.isEmpty() || bText.isEmpty()) {
            Otvet.setText("Ошибка, введите значения");
            return;
        }

        float A = Float.parseFloat(aText);
        float B = Float.parseFloat(bText);

        String result = "A+B=" + (A + B) +
                "\nA-B=" + (A - B) +
                "\nA*B=" + Math.abs(A * B) +
                "\nA/B=" + (B != 0 ? Math.abs(A / B) : "Ошибка: деление на ноль");

        Otvet.setText(result);
    }
}
