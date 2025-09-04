package com.example.ptb2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        EditText editTextA = findViewById(R.id.editTextA);
        EditText editTextB = findViewById(R.id.editTextB);
        EditText editTextC = findViewById(R.id.editTextC);
        Button buttonQuayLai = findViewById(R.id.button4);


        buttonQuayLai.setOnClickListener(v -> {
            String aStr = editTextA.getText().toString();
            String bStr = editTextB.getText().toString();
            String cStr = editTextC.getText().toString();


            if (aStr.isEmpty() || bStr.isEmpty() || cStr.isEmpty()) {
                Toast.makeText(ResultActivity.this, "Vui lòng nhập đầy đủ các hệ số!", Toast.LENGTH_SHORT).show();
                return;
            }

            double a = Double.parseDouble(aStr);
            if (a == 0) {
                Toast.makeText(ResultActivity.this, "Hệ số a phải khác 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            double b = Double.parseDouble(bStr);
            double c = Double.parseDouble(cStr);


            Intent resultIntent = new Intent();
            resultIntent.putExtra("he_so_a", a);
            resultIntent.putExtra("he_so_b", b);
            resultIntent.putExtra("he_so_c", c);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}