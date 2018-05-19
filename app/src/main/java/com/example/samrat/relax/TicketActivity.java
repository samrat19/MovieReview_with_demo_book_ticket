package com.example.samrat.relax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TicketActivity extends AppCompatActivity {

    TextView movname,confirm;
    EditText uname,ticket,contact;
    DatabaseReference databaseReference;
   // String regname,regticket,regcontact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        databaseReference= FirebaseDatabase.getInstance().getReference("user");

        movname = (TextView)findViewById(R.id.textView4);
        uname = (EditText)findViewById(R.id.editText);
        ticket = (EditText)findViewById(R.id.editText2);
        contact=(EditText)findViewById(R.id.editText3);
        confirm = (TextView)findViewById(R.id.textView8);


        Intent intent=getIntent();
        final String name=intent.getStringExtra("NAME");
        movname.setText(""+name);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final String regname = uname.getText().toString().trim();
               final String regticket = ticket.getText().toString().trim();
               final String regcontact = contact.getText().toString().trim();

                String id=databaseReference.push().getKey();

                User user = new User(regname,id,regcontact,regticket,name);

                databaseReference.child(id).setValue(user);
                Toast.makeText(TicketActivity.this,"DONE ",Toast.LENGTH_LONG).show();
            }
        });
    }
}
