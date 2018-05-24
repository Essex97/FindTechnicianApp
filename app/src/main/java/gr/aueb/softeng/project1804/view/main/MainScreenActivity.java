package gr.aueb.softeng.project1804.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Resource;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.CategoryDAOMemory;
import gr.aueb.softeng.project1804.memorydao.InitializeDAO;
import gr.aueb.softeng.project1804.memorydao.ResourceDAOMemory;
import gr.aueb.softeng.project1804.memorydao.ServiceDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.login.LogInActivity;

public class MainScreenActivity extends AppCompatActivity implements MainScreenView
{
    public static final String TYPE_CUSTOMER = "Customer";
    public static final String TYPE_TECHNICIAN = "Technician";

    /**
     * this method is responsible for defining the user as a customer
     */
    @Override
    public void startCustomerOption() {
        Intent i = new Intent(MainScreenActivity.this, LogInActivity.class);
        i.putExtra("TYPE" , TYPE_TECHNICIAN);
        startActivity(i);
    }

    /**
     * this method is responsible for defining the user as a technician
     */
    @Override
    public void startTechnicianOption() {
        Intent i = new Intent(MainScreenActivity.this, LogInActivity.class);
        i.putExtra("TYPE" , TYPE_CUSTOMER);
        startActivity(i);
    }

    /**
     * In this method the activity connects with the layout and gets called first every time the activity launches.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeDAO initializer = new InitializeDAO();
        initializer.initialize();

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
