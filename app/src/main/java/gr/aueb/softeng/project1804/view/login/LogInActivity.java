package gr.aueb.softeng.project1804.view.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.LogedInUser;
import gr.aueb.softeng.project1804.memorydao.CustomerDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.customerhome.HomeScreenCustomerActivity;
import gr.aueb.softeng.project1804.view.main.MainScreenActivity;
import gr.aueb.softeng.project1804.view.signup.SignUpActivity;
import gr.aueb.softeng.project1804.view.technicianhome.TechnicianHomeActivity;

public class LogInActivity extends AppCompatActivity implements LogInView{

    public static final String TYPE_VISITOR = "Visitor";
    private String type;

    /**
     * This method is responsible vor verifying the email and password provided by the users and ultimately allowing them, or not, to login.
     */
    @Override
    public void startLogInOption() {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

        String userDetails = preferences.getString(getEmail() + getPassword() + "data", "Email or Password is Incorrect");

        if(userDetails.equals(getPassword() + "/n") && type.equals(MainScreenActivity.TYPE_CUSTOMER)) {

            LogedInUser logedin = LogedInUser.getInstance();
            Customer tempCustomer = CustomerDAOMemory.findCustomeByEmail(getEmail());
            if(tempCustomer == null){
                Toast.makeText(getApplicationContext(), "YOU ARE NOT A CUSTOMER", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(getApplicationContext(), "CorrectCustomer", Toast.LENGTH_SHORT).show();

            logedin.setUser(tempCustomer);
            Intent i = new Intent(LogInActivity.this, HomeScreenCustomerActivity.class);
            i.putExtra("TYPE", MainScreenActivity.TYPE_CUSTOMER);
            startActivity(i);

        }else if(userDetails.equals(getPassword() + "/n") && type.equals(MainScreenActivity.TYPE_TECHNICIAN)){

            LogedInUser logedin = LogedInUser.getInstance();
            Technician tempTecnician = TechnicianDAOMemory.findTechnicianByEmail(getEmail());
            if(tempTecnician == null){
                Toast.makeText(getApplicationContext(), "YOU AR NOT A TECHNICIAN", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(getApplicationContext(), "CorrectTechnician", Toast.LENGTH_SHORT).show();

            logedin.setUser(tempTecnician);
            Intent i = new Intent(LogInActivity.this, TechnicianHomeActivity.class);
            i.putExtra("TYPE", MainScreenActivity.TYPE_TECHNICIAN);
            startActivity(i);

        }else{
            Toast.makeText(getApplicationContext(), "Email or Password is Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * this method is responsible for starting the signup procedure
     */
    @Override
    public void startSignUpOption() {
        Intent i = new Intent(LogInActivity.this, SignUpActivity.class);
        i.putExtra("TYPE", type);
        startActivity(i);
    }

    /**
     * this method is responsible for allowing a user without account to browse through the technicians and their details
     */
    @Override
    public void startVisitorOption() {
        Intent i = new Intent(LogInActivity.this, HomeScreenCustomerActivity.class);
        i.putExtra("TYPE", TYPE_VISITOR);
        System.out.println(i.getExtras().getString("TYPE"));
        startActivity(i);
    }

    /**
     * Email getter
     */
    @Override
    public String getEmail() {
        return ((AutoCompleteTextView)findViewById(R.id.userEmail)).getText().toString().trim();
    }

    /**
     * Password getter
     */
    @Override
    public String getPassword() {
        return ((AutoCompleteTextView)findViewById(R.id.userPassword)).getText().toString().trim();
    }

    /**
     * this method enables the visitor button when the user of the application is a "customer"
     */
    public void customActivity(){
        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;
        type = extradata.getString("TYPE");

        if(type.equals(MainScreenActivity.TYPE_TECHNICIAN)){
            findViewById(R.id.button4).setVisibility(View.INVISIBLE); //set Visitor Button false
        }
    }

    /**
     * In this method the activity connects with the layout and displays all the items
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        customActivity();

        final LogInPresenter presenter = new LogInPresenter(this);

        findViewById(R.id.signUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickSignUp();
            }
        });

        findViewById(R.id.logIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickLogIn();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickVisitor();
            }
        });
    }
}
