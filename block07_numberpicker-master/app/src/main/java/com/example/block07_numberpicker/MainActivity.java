package com.example.block07_numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] options = {"Google", "Facebook", "Aliexpress", "Empty"};


        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.mypicker);
        WebView webView = (WebView) findViewById(R.id.mywebview);
        Button button = (Button) findViewById(R.id.mybutton);

        numberPicker.setDisplayedValues(options);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(options.length-1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choice = numberPicker.getValue();
                webView.setWebViewClient(new WebViewClient());
                switch (choice) {
                    case 0:
                        webView.loadUrl("https://www.google.com/");
                        break;
                    case 1:
                        webView.loadUrl("https://www.facebook.com/");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/aliexpress.html");
                        break;
                }
            }
        });
    }
}