package gr.aueb.softeng.project1804.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Address;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.Technician;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText etName = findViewById(R.id.customerFirstName);
        final EditText etPassword = findViewById(R.id.customerLastName);
        final EditText etEmail = findViewById(R.id.customerEmail);
        final EditText etPhone = findViewById(R.id.customerPhone);
        final EditText etStreet = findViewById(R.id.customerAddress);
        final EditText etStreetNo = findViewById(R.id.customerAddressNumber);
        final EditText etPostCode = findViewById(R.id.customerPostCode);
        final Button signUp = findViewById(R.id.signUpButton);
        final Button nextSignUp = findViewById(R.id.signUpNextButton);

        Bundle extradata = getIntent().getExtras();
        if(extradata == null)
        {
            return;
        }

        final String type = extradata.getString("TYPE");

        if(type.equals("Technician")){
            signUp.setVisibility(View.INVISIBLE);
        }

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String phone = etPhone.getText().toString();
                String street = etStreet.getText().toString();
                int streetNo = Integer.parseInt(etStreetNo.getText().toString());
                String postCode = etPostCode.getText().toString();

                Address address = new Address(street, postCode, streetNo);

                String [] splitedName = name.split("\\s+");

                Customer newCustomer = new Customer(splitedName[0], splitedName[1], phone, email );

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(email + password + "data", password + "/n");
                editor.commit();

                Intent i = new Intent(SignUp.this, LogIn.class);
                //Intent i = new Intent(SignUp.this, SignUpCategories.class);
                i.putExtra("TYPE", type);
                startActivity(i);
            }
        });

        nextSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String phone = etPhone.getText().toString();
                String street = etStreet.getText().toString();
                int streetNo = Integer.parseInt(etStreetNo.getText().toString());
                String postCode = etPostCode.getText().toString();

                Address address = new Address(street, postCode, streetNo);

                String [] splitedName = name.split("\\s+");

                Technician newTechnician = new Technician(splitedName[0], splitedName[1], phone, email );

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(email + password + "data", password + "/n");
                editor.commit();

                Intent i = new Intent(SignUp.this, SignUpCategories.class);
                i.putExtra("TYPE", type);
                System.out.println(newTechnician.getEmail() + "signUp");
                i.putExtra("TECHNICIAN", newTechnician);
                startActivity(i);
            }
        });
    }
}
