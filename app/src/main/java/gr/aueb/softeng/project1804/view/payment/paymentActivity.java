package gr.aueb.softeng.project1804.view.payment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.Payment;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.memorydao.CustomerDAOMemory;

public class paymentActivity extends AppCompatActivity implements PaymentView{

    private ArrayAdapter<Request> requestAdapter;
    private List<Request> approvedRequests;

    @Override
    public void startPayOption() {

        double payAmount = Double.parseDouble(((AutoCompleteTextView)findViewById(R.id.payment_ammount)).getText().toString());
        Request selectedRequest = approvedRequests.get(((Spinner)findViewById(R.id.payment_spinner)).getSelectedItemPosition());
        Boolean successPay = selectedRequest.getVisit().createPayment(payAmount);

        if(successPay){
            findViewById(R.id.textView15).setEnabled(true);
            findViewById(R.id.textView16).setEnabled(true);
            findViewById(R.id.textView17).setEnabled(true);
            findViewById(R.id.textView18).setEnabled(true);
            findViewById(R.id.textView19).setEnabled(true);
            findViewById(R.id.ratingBar).setEnabled(true);
            findViewById(R.id.ratingBar).setClickable(true);
            findViewById(R.id.ratingBar2).setEnabled(true);
            findViewById(R.id.ratingBar2).setClickable(true);
            findViewById(R.id.ratingBar3).setEnabled(true);
            findViewById(R.id.ratingBar3).setClickable(true);
            findViewById(R.id.comment_arrea).setEnabled(true);
            findViewById(R.id.comment_arrea).setClickable(true);
            findViewById(R.id.btn_evaluate).setEnabled(true);
            findViewById(R.id.btn_evaluate).setClickable(true);
        }

    }

    @Override
    public void startEvaluateOption() {
        float technicianBehavior = ((RatingBar)findViewById(R.id.ratingBar)).getRating();
        float workQuality = ((RatingBar)findViewById(R.id.ratingBar)).getRating();
        float priceEvaluation = ((RatingBar)findViewById(R.id.ratingBar)).getRating();
        String comment = ((AutoCompleteTextView)findViewById(R.id.comment_arrea)).getText().toString();


    }

    @Override
    public void startChooseTechnician() {
        if(((Spinner)findViewById(R.id.payment_spinner)).getSelectedItemPosition() == 0){
            findViewById(R.id.textView13).setEnabled(false);
            findViewById(R.id.textView14).setEnabled(false);
            findViewById(R.id.payment_ammount).setEnabled(false);
            findViewById(R.id.payment_ammount).setClickable(false);
            findViewById(R.id.btn_pay).setEnabled(false);
            findViewById(R.id.btn_pay).setClickable(false);
            findViewById(R.id.textView15).setEnabled(false);
            findViewById(R.id.textView16).setEnabled(false);
            findViewById(R.id.textView17).setEnabled(false);
            findViewById(R.id.textView18).setEnabled(false);
            findViewById(R.id.textView19).setEnabled(false);
            findViewById(R.id.ratingBar).setEnabled(false);
            findViewById(R.id.ratingBar).setClickable(false);
            findViewById(R.id.ratingBar2).setEnabled(false);
            findViewById(R.id.ratingBar2).setClickable(false);
            findViewById(R.id.ratingBar3).setEnabled(false);
            findViewById(R.id.ratingBar3).setClickable(false);
            findViewById(R.id.comment_arrea).setEnabled(false);
            findViewById(R.id.comment_arrea).setClickable(false);
            findViewById(R.id.btn_evaluate).setEnabled(false);
            findViewById(R.id.btn_evaluate).setClickable(false);
        }else{
            findViewById(R.id.textView13).setEnabled(true);
            findViewById(R.id.textView14).setEnabled(true);
            findViewById(R.id.payment_ammount).setEnabled(true);
            findViewById(R.id.payment_ammount).setClickable(true);
            findViewById(R.id.btn_pay).setEnabled(true);
            findViewById(R.id.btn_pay).setClickable(true);

        }
    }

    public void customActivity(){
        Customer logedIn = CustomerDAOMemory.getLogedInCustomer();
        approvedRequests = logedIn.getApprovedRequests();
        List<Request> pr = logedIn.getPendingRequests();

        ArrayList<String> requestsByID = new ArrayList<>();
        requestsByID.add("--Choose a request First--");

        for(Request request : approvedRequests){
            requestsByID.add(request.getRequestCode());
        }

        requestAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, requestsByID);

        requestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ((Spinner)findViewById(R.id.payment_spinner)).setAdapter(requestAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        customActivity();

        final PaymentPresenter presenter = new PaymentPresenter(this);

        ((Spinner)findViewById(R.id.payment_spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.onChooseTechnician();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                presenter.onChooseTechnician();
            }
        });

        findViewById(R.id.payment_ammount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickPay();
            }
        });
    }
}
