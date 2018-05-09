package gr.aueb.softeng.project1804.view.main_screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.CategoryDAOMemory;
import gr.aueb.softeng.project1804.memorydao.ServiceDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.login_screen.LogInActivity;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView
{
    public static final String TYPE_CUSTOMER = "Customer";
    public static final String TYPE_TECHNICIAN = "Customer";

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
            CategoryDAOMemory.categories.add(new Category("Υδραυλικός", "Ο ανθρωπος που φτιαχνει τα υδραυλικά"));
            CategoryDAOMemory.categories.add(new Category("Ηλεκτρολόγος", "Ο ανθρωπος που φτιαχνει τα ηλεκτρολογικά"));
        }

        if(ServiceDAOMemory.services.size() == 0){
            ServiceDAOMemory.services.add(new Service("Αλλαγή Βρύσης", CategoryDAOMemory.categories.get(0)));
            ServiceDAOMemory.services.add(new Service("Αλλαγή Ηλιακού", CategoryDAOMemory.categories.get(0)));
            ServiceDAOMemory.services.add(new Service("Αλλαγή Λάμπας", CategoryDAOMemory.categories.get(1)));
            ServiceDAOMemory.services.add(new Service("Αλλαγή Μπρίζας", CategoryDAOMemory.categories.get(1)));
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
