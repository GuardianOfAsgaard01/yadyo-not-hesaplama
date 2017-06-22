package com.bola.yadyonothesaplama;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class yil_sonu extends AppCompatActivity implements View.OnClickListener {

    private Button hesapla, temizle;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yil_sonu);

        hesapla = (Button) findViewById(R.id.hesapla);
        temizle = (Button) findViewById(R.id.temizle);

        hesapla.setOnClickListener(this);
        temizle.setOnClickListener(this);
        reklamiyükle();
    }

    private void reklamiyükle() {
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.reklam_kimliği));

        LinearLayout layout = (LinearLayout) findViewById(R.id.ad);
        layout.addView(adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        adView.loadAd(adRequest);
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        double part1, part2, finall;

        final EditText a1=(EditText)findViewById(R.id.yil_içi_ort);
        final EditText a2=(EditText)findViewById(R.id.yeterlilik_sinavi);
        final TextView sonuc=(TextView)findViewById(R.id.sonuc);
        final TextView last=(TextView)findViewById(R.id.last);

        double yil_ici=0;
        if((a1.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            yil_ici=Double.parseDouble(a1.getText().toString());
        }

        double yeterlilik=0;
        if((a2.getText().toString()).equals("")){
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            yeterlilik=Double.parseDouble(a2.getText().toString());
        }

        part1 = ((yil_ici * 50) / 100);
        part2 = ((yeterlilik * 50) / 100);
        finall = (part1 + part2);
        switch (id){
            case R.id.hesapla:
                sonuc.setText(String.valueOf(finall));
                if (finall >= 59.5){
                    last.setText("Başarılı oldunuz.");
                }
                else{
                    last.setText("Başarısız oldunuz.");
                }
                break;
            case R.id.temizle:
                a1.setText("");
                a2.setText("");
                sonuc.setText("");
                last.setText("");
                break;
        }
    }
}