package com.cuelinksdemo.demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cuelinks.CuelinkListener;
import com.cuelinks.CuelinkMovementMethod;
import com.cuelinks.CuelinkSpan;

public class MainActivity extends AppCompatActivity implements CuelinkListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
        final EditText editText1 = (EditText) findViewById(R.id.editTextView2);
        final EditText subIdEditBox = (EditText)findViewById(R.id.subIdEdit);
        Button textBtn = (Button) findViewById(R.id.textBtn);
        Button htmlBtn = (Button) findViewById(R.id.htmlBtn);
        Button textBtn1 = (Button) findViewById(R.id.textBtn1);
        Button htmlBtn1 = (Button) findViewById(R.id.htmlBtn1);
        final EditText editText = (EditText)findViewById(R.id.editTextView);

        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
                String subId = null;
                if (!TextUtils.isEmpty(subIdEditBox.getText())) {
                    subId = subIdEditBox.getText().toString();
                }
                textView.setMovementMethod(CuelinkMovementMethod.getInstance(MainActivity.this, subId));
            }
        });

        textBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
                String subId = null;
                if (!TextUtils.isEmpty(subIdEditBox.getText())) {
                    subId = subIdEditBox.getText().toString();
                }
                textView.setMovementMethod(CuelinkMovementMethod.getInstance(getApplicationContext(), MainActivity.this, subId));
            }
        });


        htmlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subId = null;
                if (!TextUtils.isEmpty(subIdEditBox.getText())) {
                    subId = subIdEditBox.getText().toString();
                }
                textView1.setText(CuelinkSpan.affiliateHrefUrlsFromHtml(editText1.getText(), textView1, subId));
            }
        });

        htmlBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subId = null;
                if (!TextUtils.isEmpty(subIdEditBox.getText())) {
                    subId = subIdEditBox.getText().toString();
                }
                textView1.setText(CuelinkSpan.affiliateHrefUrlsFromHtml(editText1.getText(), textView1, MainActivity.this, subId));
            }
        });
    }

    @Override
    public void openUrl(String url, Context context) {
        Log.d("openUrl",url);
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
    }
}
