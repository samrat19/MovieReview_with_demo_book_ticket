package com.example.samrat.relax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView,moviename,date,ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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


        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),TicketActivity.class);
                intent1.putExtra("NAME",name);
                startActivity(intent1);
            }
        });
    }
}
