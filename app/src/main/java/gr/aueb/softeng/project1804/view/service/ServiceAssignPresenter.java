package gr.aueb.softeng.project1804.view.service;

/**
 * Created by p3150130 on 8/5/2018.
 */

public class ServiceAssignPresenter {

    private ServiceAssignView view;

    public ServiceAssignPresenter(ServiceAssignView view){
        this.view = view;
    }

    public void onClickSignUp(){
        view.startSignUpOption();
    }


}
