package gr.aueb.softeng.project1804.view.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.ServiceDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.main.MainScreenActivity;

public class ServicesAssignActivity extends AppCompatActivity implements ServiceAssignView{

    private LinearLayout parentLinearLayout;
    private ArrayList servicesList;
    private String type;
    private String category;
    private int size;
    private Technician tech;

    public void customActivity(){
        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;

        type = extradata.getString("TYPE");
        category = extradata.getString("CATEGORY");
        size = ((TechnicianDAOMemory)getApplication()).getTechnicians().size();
        tech = ((TechnicianDAOMemory) getApplication()).getTechnicians().get(size-1);
    }

    @Override
    public void startSignUpOption() {

        List<OfferedService> ofsvList = new ArrayList<>();

        EditText [] values = new EditText[5];
        values[0] = findViewById(R.id.value);
        values[1] = findViewById(R.id.value1);
        values[2] = findViewById(R.id.value2);
        values[3] = findViewById(R.id.value3);
        values[4] = findViewById(R.id.value4);

        Spinner [] spinners = new Spinner[5];
        spinners[0] = findViewById(R.id.spinner);
        spinners[1] = findViewById(R.id.type_spinner1);
        spinners[2] = findViewById(R.id.type_spinner2);
        spinners[3] = findViewById(R.id.type_spinner3);
        spinners[4] = findViewById(R.id.type_spinner4);

        for(int i = 0; i < 5; i++){
            if(spinners[i].getSelectedItemPosition() != 0 && !values[i].getText().toString().equals("")){
                String serviceDescription = (String) spinners[i].getSelectedItem();
                double price;

                try{
                    price = Double.parseDouble(values[i].getText().toString());
                    price = price >= 0.0f ? price : 0.0f;
                }catch (NumberFormatException nfe)
                {
                    Toast.makeText(getApplicationContext(), "The value of your service was sett to 0", Toast.LENGTH_SHORT).show();
                    price = 0;
                }
                ofsvList.add(new OfferedService(tech, ServiceDAOMemory.findServiceByTitle(serviceDescription), price));
            }
        }

        tech.setServices(ofsvList);
        TechnicianDAOMemory.technicians.get(TechnicianDAOMemory.technicians.size()-1).setServices(ofsvList);

        Intent i = new Intent(ServicesAssignActivity.this, MainScreenActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_assign);
        parentLinearLayout = findViewById(R.id.parent_linear_layout);

        customActivity();

        ArrayList<Service> servicesByCategory = ServiceDAOMemory.getServicesByCategory(category);
        ArrayList<String> servicesTitlesByCategory = new ArrayList<>();
        servicesTitlesByCategory.add("--Choose a service--"); //Default value on spinner
        for(Service s : servicesByCategory)
        {
            servicesTitlesByCategory.add(s.getDescription());
        }
        ArrayAdapter<String> adapter = new  ArrayAdapter(this, android.R.layout.simple_spinner_item, servicesTitlesByCategory);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)findViewById(R.id.spinner)).setAdapter(adapter);
        ((Spinner)findViewById(R.id.type_spinner1)).setAdapter(adapter);
        ((Spinner)findViewById(R.id.type_spinner2)).setAdapter(adapter);
        ((Spinner)findViewById(R.id.type_spinner3)).setAdapter(adapter);
        ((Spinner)findViewById(R.id.type_spinner4)).setAdapter(adapter);

        final ServiceAssignPresenter presenter = new ServiceAssignPresenter(this);

        findViewById(R.id.techniciannSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickSignUp();
            }
        });

    }

}
