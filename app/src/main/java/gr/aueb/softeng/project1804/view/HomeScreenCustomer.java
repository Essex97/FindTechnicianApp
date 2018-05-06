package gr.aueb.softeng.project1804.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;

public class HomeScreenCustomer extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_customer);
        final TextView test = findViewById(R.id.test);
        ArrayList<Technician> testlist  = ((TechnicianDAOMemory) getApplication()).getTechnicians();
        String x ="";
        for(Technician tech : testlist)
        {
            x = x + " " +tech.getFirstName();
        }
        test.setText(x);
    }
}
