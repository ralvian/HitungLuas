package com.rapm.app.hitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                if(TextUtils.isEmpty(edtPanjang.getText()) || TextUtils.isEmpty(edtLebar.getText())){

                    Toast.makeText(getApplicationContext(),"Nilai yang dimasukkan tidak boleh kosong",Toast.LENGTH_SHORT).show();

                }else {

                    hitungluas();

                }

            }
        });
    }

    public void hitungluas() {
        try{
            double panjang = Double.valueOf(edtPanjang.getText().toString());
            double lebar = Double.valueOf(edtLebar.getText().toString());

            double luas = panjang * lebar;

            txtLuas.setText("Luas  : ="+luas);

        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
