package gr.aueb.softeng.project1804.view.customerhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Technician;

public class HomeScreenCustomerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_customer);

        Bundle extradata = getIntent().getExtras();
        if(extradata == null) return;

        type = extradata.getString("TYPE");
        recyclerView = findViewById(R.id.recycler_view);

        ListAdapter listAdapter = new ListAdapter(HomeScreenCustomerActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);

        listAdapter.notifyDataSetChanged();

        HomeScreenCustomerPresenter presenter = new HomeScreenCustomerPresenter(this, listAdapter);

    }
}
