package gr.aueb.softeng.project1804.view.customerhome;

/**
 * Created by Stratos on 6/5/2018.
 */

public class HomeScreenCustomerPresenter {

    private HomeScreenCustomerView homeActivity;
    private ListAdapter listAdapter;

    /**
     * constructor
     * @param hsc
     * @param listAdapter
     */
    public HomeScreenCustomerPresenter(HomeScreenCustomerView hsc, ListAdapter listAdapter){
        homeActivity = hsc;
        this.listAdapter = listAdapter;
    }

    /**
     * This method is responsible for starting the payment procedure by calling the method inside the activity
     */
    public void onClickCreatePayment(){
        homeActivity.startPaymentOption();
    }
}
