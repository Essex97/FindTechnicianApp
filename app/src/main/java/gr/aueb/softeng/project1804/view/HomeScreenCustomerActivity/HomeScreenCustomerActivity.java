package gr.aueb.softeng.project1804.view.HomeScreenCustomerActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;

public class HomeScreenCustomerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_customer);

        recyclerView = findViewById(R.id.recycler_view);

        HomeScreenCustomerPresenter presenter = new HomeScreenCustomerPresenter(this, new TechnicianDAOMemory());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(presenter);
        presenter.notifyDataSetChanged();

    }
}
