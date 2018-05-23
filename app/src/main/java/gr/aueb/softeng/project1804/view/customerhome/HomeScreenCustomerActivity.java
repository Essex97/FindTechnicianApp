package gr.aueb.softeng.project1804.view.customerhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.view.payment.paymentActivity;

public class HomeScreenCustomerActivity extends AppCompatActivity implements HomeScreenCustomerView{

    private RecyclerView recyclerView;
    public static String type;

    /**
     * This method is responsible for starting the payment procedure and overrides the one contained in the Interface
     */
    @Override
    public void startPaymentOption() {
        Intent i = new Intent(this, paymentActivity.class);
        startActivity(i);
    }

    /**
     * In this method the activity connects with the layout and displays all the items
     * @param savedInstanceState
     */
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

        final HomeScreenCustomerPresenter presenter = new HomeScreenCustomerPresenter(this, listAdapter);

        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickCreatePayment();
            }
        });

    }
}
