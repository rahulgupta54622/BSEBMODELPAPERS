package com.gupta54622.rahul.bsebmodelpapers;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ContentViewActivity extends AppCompatActivity {

    private String englishUrl = "https://drive.google.com/open?id=1XgJdwGpHOF0FrhHB-XZmGnifEHILd5k7",
            hindiUrl = "https://drive.google.com/open?id=1NBQcHBci2fBcPiNiabVT1F-OduMfYWif",
            mathUrl = "https://drive.google.com/open?id=1kwGRuFm7zq-yAw_r1J4rt2t6hoQnvELW",
            scienceUrl = "https://drive.google.com/open?id=1pHswwiAZxQ0bcHu87PDmMsqZIp7rrlTF",
            socialScienceUrl = "https://drive.google.com/open?id=1VXgxuhh0o0zsvvWhjj8WWDPkb9rASw32",
            sanskritUrl = "https://drive.google.com/open?id=136iiaC2W0PefdujEQtQDtpWfk8b_yyNQ";


    private WebView webView;
    private ProgressDialog progressDialog;

    private InterstitialAd interstitialAd;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3184502253500529/6195140088");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        adView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setMessage("खुल रहा है कृपया प्रतीक्षा करें...");

        String id = "";
        try {
            id = getIntent().getExtras().getString("ID");
        } catch (Exception e) {
            Log.i("EROOR", e.getMessage());
        }


        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);


        // open in app itself
        webView.setWebViewClient(new WebViewClient());

        if (id.equals("ENGLISH"))
            webView.loadUrl(englishUrl);

        else if (id.equals("HINDI"))
            webView.loadUrl(hindiUrl);

        else if (id.equals("MATH"))
            webView.loadUrl(mathUrl);

        else if (id.equals("SCIENCE"))
            webView.loadUrl(scienceUrl);

        else if (id.equals("SSC"))
            webView.loadUrl(socialScienceUrl);


        else webView.loadUrl(sanskritUrl);


    }


    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);

            progressDialog.cancel();

            if(interstitialAd.isLoaded()){
                interstitialAd.show();
            }

        }

    }
}
