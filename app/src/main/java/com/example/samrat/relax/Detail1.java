package com.example.samrat.relax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail1 extends AppCompatActivity {

    TextView textView,moviename,date,ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);

        ticket=(TextView)findViewById(R.id.textView3);

        textView = (TextView)findViewById(R.id.details);
        moviename= (TextView)findViewById(R.id.mname);
        date     = (TextView)findViewById(R.id.rdate);
        TextView rat = (TextView)findViewById(R.id.textView2);

        final Intent intent = getIntent();
        String plot= intent.getStringExtra("PLOT");
        final String name= intent.getStringExtra("NAME");
        String redate=intent.getStringExtra("DATE");
        String rateing=intent.getStringExtra("RATING");

        textView.setText(""+plot);
        moviename.setText(""+name);
        date.setText("Release Date:- "+""+redate);
        rat.setText("Rating:- "+""+rateing);
    }
}
