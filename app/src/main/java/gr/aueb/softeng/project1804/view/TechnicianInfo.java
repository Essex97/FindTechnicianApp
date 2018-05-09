package gr.aueb.softeng.project1804.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.CustomerDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;

public class TechnicianInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_info);

        Bundle extradata = getIntent().getExtras();
        if(extradata == null)
        {
            return;
        }
        //final String type = extradata.getString("TYPE");
        //final int category = extradata.getInt("CATEGORY");
        final int position = extradata.getInt("POSITION");

        final Technician selectedTechnician = TechnicianDAOMemory.technicians.get(position);

        TextView etName = findViewById(R.id.infoName);
        TextView etMail = findViewById(R.id.infoMail);
        TextView etPhone = findViewById(R.id.infoPhone);
        //TextView etCategory = findViewById(R.id.infoCategory);

        final Spinner hours = findViewById(R.id.spinner2);
        final Spinner days = findViewById(R.id.spinner3);
        final Spinner services = findViewById(R.id.spinner4);

        final ArrayAdapter<String> adapterHours = new  ArrayAdapter(this, android.R.layout.simple_spinner_item, selectedTechnician.getAvailableHours());
        final ArrayAdapter<String> adapterDays = new  ArrayAdapter(this, android.R.layout.simple_spinner_item, selectedTechnician.getAvailableDays());



        ArrayList<String> descrpiptions = new ArrayList<>();
        for(int i = 0; i < selectedTechnician.getServices().size(); i++){
            descrpiptions.add(selectedTechnician.getServices().get(i).getService().getDescription());
        }

        final ArrayAdapter<String> adapterOffered = new ArrayAdapter(this, android.R.layout.simple_spinner_item, descrpiptions);

        adapterHours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hours.setAdapter(adapterHours);
        adapterDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        days.setAdapter(adapterDays);
        adapterOffered.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        services.setAdapter(adapterOffered);

        etName.setText(selectedTechnician.getFirstName() + " " + selectedTechnician.getLastName());
        etMail.setText(selectedTechnician.getEmail());
        etPhone.setText(selectedTechnician.getPhone());

        ImageView image = findViewById(R.id.infoPhoto);
        TextDrawable drawable = TextDrawable.builder().buildRound(etName.getText().toString().substring(0,2), Color.RED);
        image.setImageDrawable(drawable);

        findViewById(R.id.requaet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Request request = new Request();
                String date = adapterDays.getItem(days.getSelectedItemPosition());
                String time = adapterHours.getItem(hours.getSelectedItemPosition());

                String service = adapterOffered.getItem(services.getSelectedItemPosition());

                ArrayList<OfferedService> offeredServices = new ArrayList<>();
                offeredServices.add(selectedTechnician.getServices().get(services.getSelectedItemPosition()));

                Request request = new Request(date, time,  selectedTechnician, CustomerDAOMemory.logedInCustomer, offeredServices);

                System.out.println(request.getCustomer().getFirstName() + " " +request.getTechnician().getFirstName());
            }
        });



    }
}
