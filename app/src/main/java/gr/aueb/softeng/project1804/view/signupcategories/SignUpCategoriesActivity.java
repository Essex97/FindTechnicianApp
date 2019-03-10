package gr.aueb.softeng.project1804.view.signupcategories;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.CategoryDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.service.ServicesAssignActivity;

public class SignUpCategoriesActivity extends AppCompatActivity implements SignUpCategoriesView{

    private String type ;
    private int size;
    private Technician tech;
    private String [] categoriesList;

    private String [] citiesList;
    private String [] daysList;
    private String [] hoursList;
    private boolean[] categoriesChecked;
    private boolean[] citiesChecked;
    private boolean[] daysChecked;
    private boolean[] hoursChecked;
    private ArrayList<String> selectedCategories;
    private ArrayList<String> selectedCities;
    private ArrayList<String> selectedDays;
    private ArrayList<String> selectedHours;

    /**
     * this method is responsible for letting a technician choose in which category he belongs
     */
    @Override
    public void startChooseCategoryOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
        mBuilder.setTitle("Available Categories");
        mBuilder.setMultiChoiceItems(categoriesList, categoriesChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedCategories.add(categoriesList[position]);

                }else{
                    selectedCategories.remove(categoriesList[position]);
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

    /**
     * this method is responsible for letting a technician choose in which city he is available
     */
    @Override
    public void startChooseCitiesOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
        mBuilder.setTitle("Available Cities");
        mBuilder.setMultiChoiceItems(citiesList, citiesChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedCities.add(citiesList[position]);

                }else{
                    selectedCities.remove(citiesList[position]);
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

    /**
     * this method is responsible for letting a technician choose which hours he is available
     */
    @Override
    public void startChooseHoursOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
        mBuilder.setTitle("Select Hours");
        mBuilder.setMultiChoiceItems(hoursList, hoursChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedHours.add(hoursList[position]);
                }else{
                    selectedHours.remove(hoursList[position]);
                }
            }
        });

        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) { }
        });

        tech.setAvailableHours(selectedHours);

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    /**
     * this method is responsible for letting a technician choose which days he is available
     */
    @Override
    public void startChooseDaysOption() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpCategoriesActivity.this);
        mBuilder.setTitle("Select Days");
        mBuilder.setMultiChoiceItems(daysList, daysChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedDays.add(daysList[position]);

                }else{
                    selectedDays.remove(daysList[position]);
                }
            }
        });

        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) { }
        });

        tech.setAvailableDays(selectedDays);

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    /**
     * this method is continues the signup procedure
     */
    @Override
    public void startContinueOption(){
        Intent i = new Intent(SignUpCategoriesActivity.this, ServicesAssignActivity.class);
        i.putExtra("TYPE", type);
        i.putExtra("CATEGORY", selectedCategories.get(0));
        startActivity(i);
    }

    /**
     * this method fills all the lists
     */
    public void customActivity(){
        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;
        type = extradata.getString("TYPE");
        size = ((TechnicianDAOMemory)getApplication()).getTechnicians().size();
        tech = ((TechnicianDAOMemory) getApplication()).getTechnicians().get(size-1);

        //categoriesList = getResources().getStringArray(R.array.categories_array);
        categoriesList = new String[CategoryDAOMemory.categories.size()];
        for(int i = 0; i < CategoryDAOMemory.categories.size(); i++){
            categoriesList[i] = CategoryDAOMemory.categories.get(i).getTitle();
        }
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

    /**
     * this method is responsible enabling for initializing the activity and which buttons and fields
     * are accessible
     */
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
