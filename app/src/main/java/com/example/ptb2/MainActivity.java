package com.example.ptb2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEquation;
    private TextView textViewKetQua;
    private double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextEquation = findViewById(R.id.editTextText);
        textViewKetQua = findViewById(R.id.textViewKetQua);
        Button buttonNhapHeSo = findViewById(R.id.button);
        Button buttonGiai = findViewById(R.id.button2);
        Button buttonThoat = findViewById(R.id.button3);


        buttonNhapHeSo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            startActivityForResult(intent, 1);
        });


        buttonGiai.setOnClickListener(v -> giaiPhuongTrinh());


        buttonThoat.setOnClickListener(v -> finish());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {

            a = data.getDoubleExtra("he_so_a", 0);
            b = data.getDoubleExtra("he_so_b", 0);
            c = data.getDoubleExtra("he_so_c", 0);


            String equation = String.format("%.1fx² %s %.1fx %s %.1f = 0",
                    a, (b >= 0 ? "+" : ""), b, (c >= 0 ? "+" : ""), c);
            editTextEquation.setText(equation);


            findViewById(R.id.button2).setEnabled(true);
        }
    }

    private void giaiPhuongTrinh() {
        double delta = b * b - 4 * a * c;
        String ketQua;

        if (delta < 0) {
            ketQua = "Phương trình vô nghiệm.";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            ketQua = String.format("Phương trình có nghiệm kép: x = %.2f", x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            ketQua = String.format("Phương trình có hai nghiệm phân biệt:\nx1 = %.2f\nx2 = %.2f", x1, x2);
        }

        textViewKetQua.setText(ketQua);
    }
}