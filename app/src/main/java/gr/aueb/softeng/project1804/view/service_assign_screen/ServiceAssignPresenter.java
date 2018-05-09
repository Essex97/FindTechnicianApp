package gr.aueb.softeng.project1804.view.service_assign_screen;

/**
 * Created by p3150130 on 8/5/2018.
 */

public class ServiceAssignPresenter {

    private ServiceAssignView view;

    public ServiceAssignPresenter(ServicesAssignActivity view){
        this.view = view;
    }

    public void onClickSignUp(){
        view.startSignUpOption();
    }


}
