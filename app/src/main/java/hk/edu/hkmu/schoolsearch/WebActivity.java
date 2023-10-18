package hk.edu.hkmu.schoolsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.HashMap;

public class WebActivity extends AppCompatActivity {
    static String Position = "Position";
    private WebView wv;
    private String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Intent intent = getIntent();
        String position = intent.getStringExtra(InputActivity.Position);
        int position1 = Integer.parseInt(position);
        HashMap<String, String> school = SchoolInfo.schoolList.get(position1);
        //to refer to WEBSITE element in the list in SchoolInfo.java just use : school.get(SchoolInfo.WEBSITE)
        url = school.get(SchoolInfo.WEBSITE);
        wv = findViewById(R.id.wv);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        if (!TextUtils.isEmpty(url)) {
            wv.loadUrl(url);
            wv.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        } else {
            Toast.makeText(WebActivity.this, "url is empty", Toast.LENGTH_LONG).show();
           startActivity( new Intent(WebActivity.this,FunctionActivity.class));
           finish();
        }
    }


}
