package gr.aueb.softeng.project1804.view.payment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.Evaluation;
import gr.aueb.softeng.project1804.memorydao.LogedInUser;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.Scale;
import gr.aueb.softeng.project1804.domain.User;

public class paymentActivity extends AppCompatActivity implements PaymentView{

    private ArrayAdapter<Request> requestAdapter;
    private List<Request> approvedRequests;
    private float technicianBehavior;
    private float workQuality;
    private float priceEvaluation;
    private Request selectedRequest;

    /**
     * This method is responsible for starting the payment
     */
    @Override
    public void startPayOption() {

        double payAmount = Double.parseDouble(((AutoCompleteTextView)findViewById(R.id.payment_ammount)).getText().toString());
        selectedRequest = approvedRequests.get(((Spinner)findViewById(R.id.payment_spinner)).getSelectedItemPosition()-1);
        Boolean successPay = selectedRequest.getVisit().createPayment(payAmount);

        if(successPay){
            enableRating();
        }
    }

    /**
     * this method anables rating only when a customer has completed his payment
     */
    private void enableRating(){
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

    /**
     * this method is responsible for evaluating a technician
     */
    @Override
    public void startEvaluateOption() {

        String comment = ((AutoCompleteTextView)findViewById(R.id.comment_arrea)).getText().toString();

        LogedInUser login = LogedInUser.getInstance();
        User user = login.getUser();
        Evaluation eval = null;
        if (user instanceof Customer)
        {
            eval = ((Customer)user).evaluate(selectedRequest.getTechnician(), selectedRequest.getVisit());
        }

        eval.setComment(comment);
        if(technicianBehavior <= 1.0f) eval.setTechnicianBehaviour(Scale.BAD);
        if(technicianBehavior <= 2.0f) eval.setTechnicianBehaviour(Scale.GOOD);
        if(technicianBehavior <= 3.0f) eval.setTechnicianBehaviour(Scale.VERY_GOOD);
        if(workQuality <= 1.0f) eval.setWorkQuality(Scale.BAD);
        if(workQuality <= 2.0f) eval.setWorkQuality(Scale.GOOD);
        if(workQuality <= 3.0f) eval.setWorkQuality(Scale.VERY_GOOD);
        if(priceEvaluation <= 1.0f) eval.setPriceEvaluation(Scale.BAD);
        if(priceEvaluation <= 2.0f) eval.setPriceEvaluation(Scale.GOOD);
        if(priceEvaluation <= 3.0f) eval.setPriceEvaluation(Scale.VERY_GOOD);

        Toast.makeText(getApplicationContext(), "Success Evaluation", Toast.LENGTH_SHORT).show();
    }

    /**
     * this method is responsible enabling for initializing the activity and which buttons and fields
     * are accesible
     */
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

    /**
     * this method fills all the dropdown lists
     */
    public void customActivity(){
        Customer logedIn = null;
        LogedInUser login = LogedInUser.getInstance();
        User user = login.getUser();
        if (user instanceof Customer)
        {
            logedIn = (Customer)user;
        }

        ArrayList<String> requestsByID = new ArrayList<>();
        requestsByID.add("--Choose a request First--");

        if(logedIn != null){
            approvedRequests = logedIn.getApprovedRequests();

            for(Request request : approvedRequests){
                requestsByID.add(request.getRequestCode());
            }
        }
        requestAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, requestsByID);
        requestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ((Spinner)findViewById(R.id.payment_spinner)).setAdapter(requestAdapter);

    }

    /**
     * In this method the activity connects with the layout and gets called first every time the activity launches
     * @param savedInstanceState
     */
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

        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickPay();
            }
        });

        findViewById(R.id.btn_evaluate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickEvaluate();
            }
        });

        ((RatingBar)findViewById(R.id.ratingBar)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                technicianBehavior = v;
            }
        });

        ((RatingBar)findViewById(R.id.ratingBar2)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                workQuality = v;
            }
        });

        ((RatingBar)findViewById(R.id.ratingBar3)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                priceEvaluation = v;
            }
        });
    }
}
