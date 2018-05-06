package gr.aueb.softeng.project1804.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.R;

public class SignUpCategories extends AppCompatActivity {

    String [] categoriesList;
    String [] citiesList;
    boolean[] categoriesChecked;
    boolean[] citiesChecked;
    ArrayList<Integer> selectedCategories;
    ArrayList<Integer> selectedCities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_categories);

        final Button categoriesToChoose = findViewById(R.id.button);
        final Button citiesToChoose = findViewById(R.id.button5);
        Button signUp = findViewById(R.id.techSignUp);

        categoriesList = getResources().getStringArray(R.array.categories_array);
        citiesList = getResources().getStringArray(R.array.cities_array);

        categoriesChecked = new boolean[categoriesList.length];
        selectedCategories = new ArrayList<>();
        citiesChecked = new boolean[citiesList.length];
        selectedCities = new ArrayList<>();


        Bundle extradata = getIntent().getExtras();
        if(extradata == null)
        {
            return;
        }
        final String type = extradata.getString("TYPE");


        categoriesToChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategories.this);
                mBuilder.setTitle("Available Categories");
                mBuilder.setMultiChoiceItems(categoriesList, categoriesChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            selectedCategories.add(position);

                        }else{
                            selectedCategories.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) { }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });

        citiesToChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategories.this);
                mBuilder.setTitle("Available Cities");
                mBuilder.setMultiChoiceItems(citiesList, citiesChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            selectedCities.add(position);

                        }else{
                            selectedCities.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) { }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        
        
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(SignUpCategories.this, LogIn.class);
                i.putExtra("TYPE", type);
                startActivity(i);

            }
        });

    }
}
