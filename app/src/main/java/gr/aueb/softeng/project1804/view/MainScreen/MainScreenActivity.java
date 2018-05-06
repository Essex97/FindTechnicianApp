package gr.aueb.softeng.project1804.view.MainScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.view.LogIn;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView
{

    @Override
    public void strartCustomerOprion() {
        Intent i = new Intent(MainScreenActivity.this, LogIn.class);
        i.putExtra("TYPE" , "Technician");
        startActivity(i);
    }

    @Override
    public void strartTechnicianOprion() {
        Intent i = new Intent(MainScreenActivity.this, LogIn.class);
        i.putExtra("TYPE" , "Customer");
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button technician = findViewById(R.id.techbutton);
        Button customer = findViewById(R.id.customerButton);

        final MainScreenPresenter presenter = new MainScreenPresenter(this);

        technician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickCustomer();
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickTechnician();
            }
        });


    }




}
