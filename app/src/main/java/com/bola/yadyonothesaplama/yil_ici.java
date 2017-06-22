package com.bola.yadyonothesaplama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bola.yadyonothesaplama.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import static android.app.ProgressDialog.show;
import static com.bola.yadyonothesaplama.R.id.a1;
import static com.bola.yadyonothesaplama.R.id.a2;
import static com.bola.yadyonothesaplama.R.id.a3;
import static com.bola.yadyonothesaplama.R.id.a4;
import static com.bola.yadyonothesaplama.R.id.p1;
import static com.bola.yadyonothesaplama.R.id.p2;
import static com.bola.yadyonothesaplama.R.id.p3;
import static com.bola.yadyonothesaplama.R.id.p4;
import static com.bola.yadyonothesaplama.R.id.sonuc;

public class yil_ici extends AppCompatActivity implements View.OnClickListener {

    private Button hesapla, temizle;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yil_ici);

        hesapla = (Button) findViewById(R.id.hesapla);
        temizle = (Button) findViewById(R.id.temizle);

        hesapla.setOnClickListener(this);
        temizle.setOnClickListener(this);
        reklamiyukle();

    }

    private void reklamiyukle() {
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.reklam_kimliği));

        LinearLayout layout = (LinearLayout) findViewById(R.id.ad);
        layout.addView(adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        adView.loadAd(adRequest);
    }

    @Override
    public void onClick(View v){
        int id=v.getId();
        double ort1, ort11, ort2, ort21, p, pq, p0, finall;

        final EditText a1=(EditText)findViewById(R.id.a1);
        final EditText a2=(EditText)findViewById(R.id.a2);
        final EditText a3=(EditText)findViewById(R.id.a3);
        final EditText a4=(EditText)findViewById(R.id.a4);
        final EditText p1=(EditText)findViewById(R.id.p1);
        final EditText p2=(EditText)findViewById(R.id.p2);
        final EditText p3=(EditText)findViewById(R.id.p3);
        final EditText p4=(EditText)findViewById(R.id.p4);
        final TextView sonuc=(TextView)findViewById(R.id.sonuc);

        double sınav1=0;
        if((a1.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            sınav1=Double.parseDouble(a1.getText().toString());
        }

        double sınav2=0;
        if((a2.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            sınav2=Double.parseDouble(a2.getText().toString());
        }

        double sınav3=0;
        if((a3.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            sınav3=Double.parseDouble(a3.getText().toString());
        }

        double sınav4=0;
        if((a4.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            sınav4=Double.parseDouble(a4.getText().toString());
        }

        double portfolyo1=0;
        if((a1.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            portfolyo1=Double.parseDouble(p1.getText().toString());
        }

        double portfolyo2=0;
        if((a1.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            portfolyo2=Double.parseDouble(p2.getText().toString());
        }

        double portfolyo3=0;
        if((a1.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            portfolyo3=Double.parseDouble(p3.getText().toString());
        }

        double portfolyo4=0;
        if((a1.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            portfolyo4=Double.parseDouble(p4.getText().toString());
        }

        ort1 = ((sınav1 + sınav2) / 2);
        ort11 = ((ort1 * 40) / 100);
        ort2 = ((sınav3 + sınav4) / 2);
        ort21 = ((ort2 * 60) / 100);
        p = ((ort11 + ort21));
        pq = ((portfolyo1 + portfolyo2 + portfolyo3 + portfolyo4) / 4);
        p0 = ((p * 70) / 100);
        finall = (pq + p0);

        switch (id){
            case R.id.hesapla:
                sonuc.setText(String.valueOf(finall));
                break;
            case R.id.temizle:
                a1.setText("");
                a2.setText("");
                a3.setText("");
                a4.setText("");
                p1.setText("");
                p2.setText("");
                p3.setText("");
                p4.setText("");
                sonuc.setText("");
                break;
        }
    }
}