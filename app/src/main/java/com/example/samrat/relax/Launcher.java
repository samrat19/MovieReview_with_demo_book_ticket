package com.example.samrat.relax;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Launcher extends AppCompatActivity {

    private static  int SPALSH = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_launcher);

        GifImageView gifImageView = (GifImageView)findViewById(R.id.gifImageView);

        try{
            InputStream inputStream = getAssets().open("sp.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Launcher.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPALSH);
    }
}
