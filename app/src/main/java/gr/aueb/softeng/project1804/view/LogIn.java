package gr.aueb.softeng.project1804.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.view.HomePage.MainActivity;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final AutoCompleteTextView email = findViewById(R.id.userEmail);
        final AutoCompleteTextView  passwod = findViewById(R.id.userPassword);
        final Button logIn = findViewById(R.id.button2);
        final Button signUp = findViewById(R.id.button3);
        final  Button visitor = findViewById(R.id.button4);

        Bundle extradata = getIntent().getExtras();
        if(extradata == null)
        {
            return;
        }

        final String type = extradata.getString("TYPE");

        if(type.equals("Technician")){
            visitor.setVisibility(View.INVISIBLE);
        }


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogIn.this, SignUp.class);
                i.putExtra("TYPE", type);
                startActivity(i);
            }
        });

        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
