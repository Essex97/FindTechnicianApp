package gr.aueb.softeng.project1804.view.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Address;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.CustomerDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.signupcategories.SignUpCategoriesActivity;
import gr.aueb.softeng.project1804.view.main.MainScreenActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpView{

    private String type;

    /**
     * This method saves a customer as signed up
     */
    @Override
    public void startSignUpOption() {
        Address address = new Address(getStreetName(), getPostalCode(), getStreetNumber());

        Customer newCustomer;
        String [] splitedName = getName().split("\\s+");

        if (splitedName.length == 1)
            newCustomer = new Customer(splitedName[0], "", getPhone(), getEmail() );
        else
            newCustomer = new Customer(splitedName[0], splitedName[1], getPhone(), getEmail() );

        ((CustomerDAOMemory) getApplication()).addCustomer(newCustomer);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(getEmail() + getPassword() + "data", getPassword() + "/n");
        editor.commit();

        Intent i = new Intent(SignUpActivity.this, MainScreenActivity.class);
        i.putExtra("TYPE", type);
        startActivity(i);
    }

    /**
     * This method saves a technician as signed up and continues the procedure as more details are needed for the technicians
     */
    @Override
    public void startNextOption() {
        Address address = new Address(getStreetName(), getPostalCode(), getStreetNumber());

        Technician newTechnician;
        String [] splitedName = getName().split("\\s+");

        if (splitedName.length == 1)
            newTechnician = new Technician(splitedName[0], "", getPhone(), getEmail() );
        else
            newTechnician = new Technician(splitedName[0], splitedName[1], getPhone(), getEmail() );

        ((TechnicianDAOMemory) getApplication()).addTechnician(newTechnician);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(getEmail() + getPassword() + "data", getPassword() + "/n");
        editor.commit();

        Intent i = new Intent(SignUpActivity.this, SignUpCategoriesActivity.class);
        i.putExtra("TYPE", type);
        startActivity(i);
    }

    @Override
    public String getName() {
        return ((EditText)findViewById(R.id.customerFirstName)).getText().toString();
    }

    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.password)).getText().toString();
    }

    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.customerEmail)).getText().toString();
    }

    @Override
    public String getPhone() {
        return ((EditText)findViewById(R.id.customerPhone)).getText().toString();
    }

    @Override
    public String getStreetName() {
        return ((EditText)findViewById(R.id.customerAddress)).getText().toString();
    }

    @Override
    public int getStreetNumber() {
        return Integer.parseInt(((EditText)findViewById(R.id.customerAddressNumber)).getText().toString());
    }

    @Override
    public String getPostalCode() {
        return ((EditText)findViewById(R.id.customerPostCode)).getText().toString();
    }

    /**
     * this method displays the sign up button only when the user is a customer
     */
    public void customActivity(){
        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;

        type = extradata.getString("TYPE");

        if(type.equals(MainScreenActivity.TYPE_TECHNICIAN)){
            findViewById(R.id.signUpButton).setVisibility(View.INVISIBLE);
        }else {
            findViewById(R.id.signUpNextButton).setVisibility(View.INVISIBLE);
        }
    }

    /**
     * this method is responsible enabling for initializing the activity and which buttons and fields
     * are accessible
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        customActivity();

        final SignUpPresenter presenter = new SignUpPresenter(this);

        findViewById(R.id.signUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickSignUp();
            }
        });

        findViewById(R.id.signUpNextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickNext();
            }
        });
    }
}
