package gr.aueb.softeng.project1804.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.CategoryDAOMemory;
import gr.aueb.softeng.project1804.memorydao.ServiceDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.login.LogInActivity;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView
{
    public static final String TYPE_CUSTOMER = "Customer";
    public static final String TYPE_TECHNICIAN = "Technician";

    @Override
    public void startCustomerOption() {
        Intent i = new Intent(MainScreenActivity.this, LogInActivity.class);
        i.putExtra("TYPE" , TYPE_TECHNICIAN);
        startActivity(i);
    }

    @Override
    public void startTechnicianOption() {
        Intent i = new Intent(MainScreenActivity.this, LogInActivity.class);
        i.putExtra("TYPE" , TYPE_CUSTOMER);
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

        if(CategoryDAOMemory.categories.size() == 0){
            CategoryDAOMemory.categories.add(new Category("Plumber",
                    "A plumber is a tradesperson who specializes in installing and maintaining systems used for potable (drinking) water, sewage and drainage in plumbing systems."));
            CategoryDAOMemory.categories.add(new Category("Electrician", "An electrician is a tradesman specializing in electrical wiring of buildings, stationary machines, and related equipment."));
        }

        if(ServiceDAOMemory.services.size() == 0){
            ServiceDAOMemory.services.add(new Service("Faucet Repair", CategoryDAOMemory.categories.get(0)));
            ServiceDAOMemory.services.add(new Service("Change Solar Panel", CategoryDAOMemory.categories.get(0)));
            ServiceDAOMemory.services.add(new Service("Change Lamp", CategoryDAOMemory.categories.get(1)));
            ServiceDAOMemory.services.add(new Service("Change The Socket", CategoryDAOMemory.categories.get(1)));
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
