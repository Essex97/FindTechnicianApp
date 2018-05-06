package gr.aueb.softeng.project1804.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;

public class ServicesAssign extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    private ArrayList servicesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_assign);
        parentLinearLayout = findViewById(R.id.parent_linear_layout);

        Bundle extradata = getIntent().getExtras();
        if(extradata == null)
        {
            return;
        }
        final String type = extradata.getString("TYPE");
        final int category = extradata.getInt("CATEGORY");
        final Technician technician = (Technician)extradata.getSerializable("TECHNICIAN");
        System.out.println(technician.getEmail() + "Service");

        final Button technicianSignUp = findViewById(R.id.techniciannSignUp);
        final EditText etValue = findViewById(R.id.value);
        final EditText etValue1 = findViewById(R.id.value1);
        final EditText etValue2 = findViewById(R.id.value2);
        final EditText etValue3 = findViewById(R.id.value3);
        final EditText etValue4 = findViewById(R.id.value4);


        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = null;
        Spinner spinner1 = findViewById(R.id.type_spinner1);
        ArrayAdapter<CharSequence> adapter1 = null;
        Spinner spinner2 = findViewById(R.id.type_spinner2);
        ArrayAdapter<CharSequence> adapter2 = null;
        Spinner spinner3 = findViewById(R.id.type_spinner3);
        ArrayAdapter<CharSequence> adapter3 = null;
        Spinner spinner4 = findViewById(R.id.type_spinner4);
        ArrayAdapter<CharSequence> adapter4 = null;

        if(category == 0){
            adapter = ArrayAdapter.createFromResource(this, R.array.ydraylikos_services, android.R.layout.simple_spinner_item);
            adapter1 = ArrayAdapter.createFromResource(this, R.array.ydraylikos_services, android.R.layout.simple_spinner_item);
            adapter2 = ArrayAdapter.createFromResource(this, R.array.ydraylikos_services, android.R.layout.simple_spinner_item);
            adapter3 = ArrayAdapter.createFromResource(this, R.array.ydraylikos_services, android.R.layout.simple_spinner_item);
            adapter4 = ArrayAdapter.createFromResource(this, R.array.ydraylikos_services, android.R.layout.simple_spinner_item);
        }else if(category == 1){
            adapter = ArrayAdapter.createFromResource(this, R.array.hlektrologos_services, android.R.layout.simple_spinner_item);
            adapter1 = ArrayAdapter.createFromResource(this, R.array.hlektrologos_services, android.R.layout.simple_spinner_item);
            adapter2 = ArrayAdapter.createFromResource(this, R.array.hlektrologos_services, android.R.layout.simple_spinner_item);
            adapter3 = ArrayAdapter.createFromResource(this, R.array.hlektrologos_services, android.R.layout.simple_spinner_item);
            adapter4 = ArrayAdapter.createFromResource(this, R.array.hlektrologos_services, android.R.layout.simple_spinner_item);
        }else if(category == 2){
            adapter = ArrayAdapter.createFromResource(this, R.array.xilokopos_services, android.R.layout.simple_spinner_item);
            adapter1 = ArrayAdapter.createFromResource(this, R.array.xilokopos_services, android.R.layout.simple_spinner_item);
            adapter2 = ArrayAdapter.createFromResource(this, R.array.xilokopos_services, android.R.layout.simple_spinner_item);
            adapter3 = ArrayAdapter.createFromResource(this, R.array.xilokopos_services, android.R.layout.simple_spinner_item);
            adapter4 = ArrayAdapter.createFromResource(this, R.array.xilokopos_services, android.R.layout.simple_spinner_item);
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);

        technicianSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Service service = new Service();
                service.setDescription(spinner.getSelectedItem().toString());
                service.setCategories(new ArrayList<Category>());
                OfferedService ofsv = new OfferedService(technician, service, Double.parseDouble(etValue.getText().toString()));
                List<OfferedService> ofsvList = new ArrayList<OfferedService>();
                ofsvList.add(ofsv);
                technician.setServices(ofsvList);

                Intent i = new Intent(ServicesAssign.this, LogIn.class);
                startActivity(i);

            }
        });

    }

}
