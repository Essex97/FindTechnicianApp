package gr.aueb.softeng.project1804.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Technician;
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

        Technician selected = TechnicianDAOMemory.technicians.get(position);

        TextView etName = findViewById(R.id.infoName);
        TextView etMail = findViewById(R.id.infoMail);
        TextView etPhone = findViewById(R.id.infoPhone);
        //TextView etCategory = findViewById(R.id.infoCategory);

        etName.setText(selected.getFirstName() + " " + selected.getLastName());
        etMail.setText(selected.getEmail());
        etPhone.setText(selected.getPhone());
        //etName.setText(category);

        ImageView image = findViewById(R.id.infoPhoto);
        TextDrawable drawable = TextDrawable.builder().buildRound(etName.getText().toString().substring(0,2), Color.RED);
        image.setImageDrawable(drawable);



    }
}
