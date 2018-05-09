package gr.aueb.softeng.project1804.view.login_screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.memorydao.CustomerDAOMemory;
import gr.aueb.softeng.project1804.view.HomeScreenCustomerActivity.HomeScreenCustomerActivity;
import gr.aueb.softeng.project1804.view.main_screen.MainScreenActivity;
import gr.aueb.softeng.project1804.view.signup_screen.SignUpActivity;

public class LogInActivity extends AppCompatActivity implements LogInView{

    public static final String TYPE_VISITOR = "Visitor";
    private String type;

    @Override
    public void startLogInOption() {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

        String userDetails = preferences.getString(getEmail() + getPassword() + "data", "Email or Password is Incorrect");

        if(userDetails.equals(getPassword() + "/n")){
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            CustomerDAOMemory.setLogedInCustomer(CustomerDAOMemory.findCustomeByEmail(getEmail()));
            Intent i = new Intent(LogInActivity.this, HomeScreenCustomerActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(), "Email or Password is Incorrect", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void startSignUpOption() {
        Intent i = new Intent(LogInActivity.this, SignUpActivity.class);
        i.putExtra("TYPE", type);
        startActivity(i);
    }

    @Override
    public void startVisitorOption() {
        Intent i = new Intent(LogInActivity.this, HomeScreenCustomerActivity.class);
        i.putExtra("TYPE", TYPE_VISITOR);
        startActivity(i);
    }

    @Override
    public String getEmail() {
        return ((AutoCompleteTextView)findViewById(R.id.userEmail)).getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return ((AutoCompleteTextView)findViewById(R.id.userPassword)).getText().toString().trim();
    }

    public void customActivity(){
        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;
        type = extradata.getString("TYPE");

        if(type.equals(MainScreenActivity.TYPE_TECHNICIAN)){
            findViewById(R.id.button4).setVisibility(View.INVISIBLE); //set Visitor Button false
        }
    }


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
