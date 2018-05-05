package gr.aueb.softeng.project1804.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1804.R;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Button signUp = findViewById(R.id.signUpButton);

        Bundle extradata = getIntent().getExtras();
        if(extradata == null)
        {
            return;
        }

        final String type = extradata.getString("TYPE");

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(type.equals("Technician")){
                    Intent i = new Intent(SignUp.this, SignUpCategories.class);
                    //i.putExtra("TYPE", type);
                    startActivity(i);
                }else{
                    //Intent i = new Intent(SignUp.this, HOme.class);
                    //startActivity(i);
                }

            }
        });
    }
}
