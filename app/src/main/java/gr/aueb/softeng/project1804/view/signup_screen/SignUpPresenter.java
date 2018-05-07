package gr.aueb.softeng.project1804.view.signup_screen;

/**
 * Created by Stratos on 7/5/2018.
 */

public class SignUpPresenter {

    private SignUpView view;

    public SignUpPresenter(SignUpView view){
        this.view = view;
    }

    public void onClickSignUp(){
        view.startSignUpOption();
    }

    public void onClickNext(){
        view.startNextOption();
    }

}
