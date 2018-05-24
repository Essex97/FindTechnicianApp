package gr.aueb.softeng.project1804.view.signup;

/**
 * Created by Stratos on 7/5/2018.
 */

public class SignUpPresenter {

    private SignUpView view;

    public SignUpPresenter(SignUpView view){
        this.view = view;
    }

    /**
     This method saves a customer as signed up by calling the method in the activity
     */
    public void onClickSignUp(){
        view.startSignUpOption();
    }

    /**
     This method saves a technician as signed up and continues the procedure as more details are needed for the technicians by calling the method in the activity
     */
    public void onClickNext(){
        view.startNextOption();
    }

}
