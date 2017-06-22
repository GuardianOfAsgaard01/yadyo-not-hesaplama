package com.bola.yadyonothesaplama;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class AnaSayfa extends ActionBarActivity {
    Button btn1, btn2;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        btn1 = (Button)findViewById(R.id.yil_ici_btn);
        btn2 = (Button)findViewById(R.id.yil_sonu_btn);

        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intocan1 = new Intent(AnaSayfa.this, yil_ici.class);
                startActivity(intocan1);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intocan2 = new Intent(AnaSayfa.this, yil_sonu.class);
                startActivity(intocan2);
            }
        });
        
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
}