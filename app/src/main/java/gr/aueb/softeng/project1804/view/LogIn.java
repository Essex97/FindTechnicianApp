package gr.aueb.softeng.project1804.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.view.HomePage.MainActivity;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final AutoCompleteTextView etEmail = findViewById(R.id.userEmail);
        final AutoCompleteTextView etPassword = findViewById(R.id.userPassword);
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
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                String userDetails = preferences.getString(email + password + "data", "Email or Password is Incorrect");

                if(userDetails.equals(password + "/n")){
                    Toast.makeText(getApplicationContext(), "LogingIn", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Email or Password is Incorrect", Toast.LENGTH_SHORT).show();
                }

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
