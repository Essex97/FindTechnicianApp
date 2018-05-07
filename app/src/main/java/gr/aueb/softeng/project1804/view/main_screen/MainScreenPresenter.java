package gr.aueb.softeng.project1804.view.main_screen;

/**
 * Created by Stratos on 6/5/2018.
 */

public class MainScreenPresenter {

    private  MainScreenView view;

    public MainScreenPresenter(MainScreenView view){
        this.view = view;
    }

    public void onClickCustomer(){
        view.startCustomerOption();
    }

    public void onClickTechnician(){
        view.startTechnicianOption();
    }
}
