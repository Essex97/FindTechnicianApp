package gr.aueb.softeng.project1804.view.HomePage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.view.LogIn;
import gr.aueb.softeng.project1804.view.SignUp;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button technician = findViewById(R.id.techbutton);
        Button customer = findViewById(R.id.customerButton);

        technician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LogIn.class);
                i.putExtra("TYPE" , "Technician");
                startActivity(i);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LogIn.class);
                i.putExtra("TYPE" , "Customer");
                startActivity(i);
            }
        });
    }




}
