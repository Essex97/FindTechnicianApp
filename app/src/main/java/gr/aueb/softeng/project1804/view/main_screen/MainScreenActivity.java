package gr.aueb.softeng.project1804.view.main_screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.login_screen.LogInActivity;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView
{

    @Override
    public void startCustomerOption() {
        Intent i = new Intent(MainScreenActivity.this, LogInActivity.class);
        i.putExtra("TYPE" , "Technician");
        startActivity(i);
    }

    @Override
    public void startTechnicianOption() {
        Intent i = new Intent(MainScreenActivity.this, LogInActivity.class);
        i.putExtra("TYPE" , "Customer");
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Technicians
        if(TechnicianDAOMemory.technicians.size() == 0){
            TechnicianDAOMemory.technicians.add(new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com"));
            TechnicianDAOMemory.technicians.add(new Technician("Dimitris", "Staratzis", "xxxxx", "xxxxx"));
        }


        final MainScreenPresenter presenter = new MainScreenPresenter(this);

        findViewById(R.id.techbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickCustomer();
            }
        });

        findViewById(R.id.customerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickTechnician();
            }
        });


    }




}
