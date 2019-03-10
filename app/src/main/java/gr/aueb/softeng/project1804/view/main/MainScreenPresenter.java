package gr.aueb.softeng.project1804.view.main;

/**
 * Created by Stratos on 6/5/2018.
 */

public class MainScreenPresenter {

    private  MainScreenView view;

    public MainScreenPresenter(MainScreenView view){
        this.view = view;
    }

    /**
     * this method is responsible for defining the users as a customer by calling the method pf the activity
     */
    public void onClickCustomer(){
        view.startCustomerOption();
    }

    /**
     * this method is responsible for defining the user as a technician by calling the method in the activity
     */
    public void onClickTechnician(){
        view.startTechnicianOption();
    }
}
