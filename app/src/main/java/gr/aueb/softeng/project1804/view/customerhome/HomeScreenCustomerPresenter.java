package gr.aueb.softeng.project1804.view.customerhome;

/**
 * Created by Stratos on 6/5/2018.
 */

public class HomeScreenCustomerPresenter {

    private HomeScreenCustomerView homeActivity;
    private ListAdapter listAdapter;

    public HomeScreenCustomerPresenter(HomeScreenCustomerView hsc, ListAdapter listAdapter){
        homeActivity = hsc;
        this.listAdapter = listAdapter;
    }

    /**
     * This method is responsible for starting the payment procedure
     */
    public void onClickCreatePayment(){
        homeActivity.startPaymentOption();
    }
}
