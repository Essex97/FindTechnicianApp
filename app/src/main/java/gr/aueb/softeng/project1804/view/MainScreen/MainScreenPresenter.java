package gr.aueb.softeng.project1804.view.MainScreen;

/**
 * Created by Stratos on 6/5/2018.
 */

public class MainScreenPresenter {

    private  MainScreenView view;

    public MainScreenPresenter(MainScreenView view){
        this.view = view;
    }

    public void onClickCustomer(){
        view.strartCustomerOprion();
    }

    public void onClickTechnician(){
        view.strartTechnicianOprion();
    }
}
