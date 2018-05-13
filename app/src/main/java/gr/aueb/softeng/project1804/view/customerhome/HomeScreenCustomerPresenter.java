package gr.aueb.softeng.project1804.view.customerhome;

/**
 * Created by Stratos on 6/5/2018.
 */

public class HomeScreenCustomerPresenter {

    private HomeScreenCustomerViewStub homeActivity;
    private ListAdapter listAdapter;

    public HomeScreenCustomerPresenter(HomeScreenCustomerViewStub hsc, ListAdapter listAdapter){
        homeActivity = hsc;
        this.listAdapter = listAdapter;
    }

    public void onClickCreatePayment(){
        homeActivity.startPaymentOption();
    }
}
