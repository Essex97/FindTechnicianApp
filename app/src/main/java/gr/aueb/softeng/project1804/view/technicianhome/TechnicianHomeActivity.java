package gr.aueb.softeng.project1804.view.technicianhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;

public class TechnicianHomeActivity extends AppCompatActivity implements TechnicianHomeView{

    private RecyclerView recyclerView;

    @Override
    public void startRequestsOption() {
        findViewById(R.id.btn_tech_request).setEnabled(false);
        findViewById(R.id.btn_tech_visit).setEnabled(true);
        findViewById(R.id.textView9).setVisibility(View.VISIBLE);
        findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
    }

    @Override
    public void startVisitsOption() {
        findViewById(R.id.btn_tech_request).setEnabled(true);
        findViewById(R.id.btn_tech_visit).setEnabled(false);
        findViewById(R.id.textView9).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView12).setVisibility(View.VISIBLE);
    }

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
