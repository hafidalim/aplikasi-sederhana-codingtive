package com.hafid.aplikasisederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtAlas, edtTinggi;
    Button btnHitung, btnClear;
    TextView tvResult;

    private static final String state_result = "state_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlas = findViewById(R.id.edtAlas);
        edtTinggi = findViewById(R.id.edtTinggi);
        btnHitung = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        btnClear = findViewById(R.id.btnClear);


        btnHitung.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(state_result);
            tvResult.setText(hasil);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(state_result, tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate){
            String alas = edtAlas.getText().toString().trim();
            String tinggi = edtTinggi.getText().toString().trim();

            boolean isEmpty = false;

            if (TextUtils.isEmpty(alas)){
                isEmpty = true;
                edtAlas.setError("Field Panjang Tidak Boleh Kosong !");
            }
            if (TextUtils.isEmpty(tinggi)){
                isEmpty = true;
                edtTinggi.setError("Field Panjang Tidak Boleh Kosong !");
            }

            if (!isEmpty){
                double a = Double.parseDouble(alas);
                double t = Double.parseDouble(tinggi);

                double volume = 0.5 * a * t;
                tvResult.setText(String.valueOf(volume));
            }

        }
        if (v.getId() == R.id.btnClear){
            edtAlas.setText("");
            edtTinggi.setText("");
            tvResult.setText("");
        }
    }
}
