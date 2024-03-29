package gr.aueb.softeng.project1804.view.technicianhome;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.Resource;
import gr.aueb.softeng.project1804.memorydao.CategoryDAOMemory;
import gr.aueb.softeng.project1804.memorydao.ResourceDAOMemory;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.signupcategories.SignUpCategoriesActivity;

public class TechnicianHomeActivity extends AppCompatActivity implements TechnicianHomeView{

    private RecyclerView recyclerView;
    private String [] resourcesList;
    private boolean[] resourcesChecked;
    private ArrayList<String> selectedResources;
    private ArrayList<Resource> returnedResources;

    /**
     * this method is responsible for displaying all the requests made to the logged in user
     */
    @Override
    public void startRequestsOption() {
        findViewById(R.id.btn_tech_visit).setAlpha(0.5f);
        findViewById(R.id.btn_tech_request).setAlpha(1f);
        findViewById(R.id.textView9).setVisibility(View.VISIBLE);
        findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
    }

    /**
     * this method is responsible for displaying all the visits arranged for the logged in user
     */
    @Override
    public void startVisitsOption() {
        findViewById(R.id.btn_tech_request).setAlpha(0.5f);
        findViewById(R.id.btn_tech_visit).setAlpha(1f);
        findViewById(R.id.textView9).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView12).setVisibility(View.VISIBLE);
    }

    /**
     * this method is responsible for filling the lists
     */
    public ArrayList<Resource> addResources(){

        selectedResources = new ArrayList<>();
        resourcesList = new String[ResourceDAOMemory.resources.size()];
        for(int i = 0; i < ResourceDAOMemory.resources.size(); i++){
            resourcesList[i] = ResourceDAOMemory.resources.get(i).getName();
        }
        resourcesChecked = new boolean[resourcesList.length];
        returnedResources = new ArrayList<>();

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(TechnicianHomeActivity.this);
        mBuilder.setTitle("Add Resources");
        mBuilder.setMultiChoiceItems(resourcesList, resourcesChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if (isChecked) {
                    selectedResources.add(resourcesList[position]);
                    returnedResources.add(ResourceDAOMemory.resources.get(position));

                } else {
                    selectedResources.remove(resourcesList[position]);
                    returnedResources.remove(ResourceDAOMemory.resources.get(position));
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

        return returnedResources;
    }

    /**
     * this method is responsible enabling for initializing the activity and which buttons and fields
     * are accessible
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_home);

        recyclerView = findViewById(R.id.requestList);

        RequestAdapter adapter = new RequestAdapter(TechnicianHomeActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        final TechnicianScreenPresenter presenter = new TechnicianScreenPresenter(this, adapter);

        presenter.onClickRequests();

        findViewById(R.id.btn_tech_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickRequests();
            }
        });

        findViewById(R.id.btn_tech_visit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickVisits();
            }
        });
    }
}
