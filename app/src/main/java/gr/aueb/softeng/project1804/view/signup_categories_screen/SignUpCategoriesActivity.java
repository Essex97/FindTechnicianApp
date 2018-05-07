package gr.aueb.softeng.project1804.view.signup_categories_screen;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.view.ServicesAssign;

public class SignUpCategoriesActivity extends AppCompatActivity implements SignUpCategoriesView{

    private String type ;
    private String [] categoriesList;
    private String [] citiesList;
    private String [] daysList;
    private String [] hoursList;
    private boolean[] categoriesChecked;
    private boolean[] citiesChecked;
    private boolean[] daysChecked;
    private boolean[] hoursChecked;
    private ArrayList<Integer> selectedCategories;
    private ArrayList<Integer> selectedCities;
    private ArrayList<Integer> selectedDays;
    private ArrayList<Integer> selectedHours;

    @Override
    public void startChooseCategoryOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
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

    @Override
    public void startChooseCitiesOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
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

    @Override
    public void startChooseHoursOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
        mBuilder.setTitle("Select Hours");
        mBuilder.setMultiChoiceItems(hoursList, hoursChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedDays.add(position);

                }else{
                    selectedDays.remove((Integer.valueOf(position)));
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

    @Override
    public void startChooseDaysOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
        mBuilder.setTitle("Select Days");
        mBuilder.setMultiChoiceItems(daysList, daysChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedDays.add(position);

                }else{
                    selectedDays.remove((Integer.valueOf(position)));
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

    @Override
    public void startContinueOption(){
        Intent i = new Intent(SignUpCategoriesActivity.this, ServicesAssign.class);
        i.putExtra("TYPE", type);
        i.putExtra("CATEGORY", selectedCategories.get(0));
        startActivity(i);
    }

    public void customActivity(){
        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;
        type = extradata.getString("TYPE");

        categoriesList = getResources().getStringArray(R.array.categories_array);
        citiesList = getResources().getStringArray(R.array.cities_array);
        daysList = getResources().getStringArray(R.array.days_array);
        hoursList = getResources().getStringArray(R.array.hours_array);

        categoriesChecked = new boolean[categoriesList.length];
        selectedCategories = new ArrayList<>();
        citiesChecked = new boolean[citiesList.length];
        selectedCities = new ArrayList<>();
        daysChecked = new boolean[daysList.length];
        selectedDays = new ArrayList<>();
        hoursChecked = new boolean[hoursList.length];
        selectedHours = new ArrayList<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_categories);

        customActivity();

        final SignUpCategoriesPresenter presenter = new SignUpCategoriesPresenter(this);

        findViewById(R.id.chooseCatery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            presenter.onClickChooseCategory();
            }
        });

        findViewById(R.id.chooseCities).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickChooseCities();
            }
        });

        findViewById(R.id.chooseDays).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickChooseDays();
            }
        });

        findViewById(R.id.chooseHours).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickChooseHours();
            }
        });


        findViewById(R.id.continueSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickContinue();
            }
        });

    }
}
