package com.gupta54622.rahul.bsebmodelpapers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    //CardView hindi, english, math, science, socialScience, sanskrit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3184502253500529~6791457339");

    }

    public void onClickCardView(View view) {

        Intent intent = new Intent(this, ContentViewActivity.class);

        if(view.getId() == R.id.cardViewEnglish)
            intent.putExtra("ID", "ENGLISH");

        if(view.getId() == R.id.cardViewHindi)
            intent.putExtra("ID", "HINDI");

        if(view.getId() == R.id.cardViewMath)
            intent.putExtra("ID", "MATH");


        if(view.getId() == R.id.cardViewScience)
            intent.putExtra("ID", "SCIENCE");


        if(view.getId() == R.id.cardViewSSC)
            intent.putExtra("ID", "SSC");

        if(view.getId() == R.id.cardViewSanskrit)
            intent.putExtra("ID", "SANSKRIT");

        startActivity(intent);
    }

    public void onClickDisclaimer(View view) {

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_info_black_24dp)
                .setTitle("DISCLAIMER")
                .setMessage("Source of the contents used in this app has been taken from official website of Bihar board, and has been produced to user for free.")
                .setPositiveButton("OK", null)
                .show();

    }
}
