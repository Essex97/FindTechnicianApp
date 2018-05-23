package gr.aueb.softeng.project1804.view.login;

/**
 * Created by Stratos on 7/5/2018.
 */

public class LogInPresenter {

    private LogInView view;

    public LogInPresenter(LogInView view){ this.view = view;}

    /**
     * this method starts the sign up procedure by calling the method inside the activity
     */
    public void onClickSignUp(){
        view.startSignUpOption();
    }

    /**
     * this method starts the login procedure by calling the method inside the activity
     */
    public void onClickLogIn(){
        view.startLogInOption();
    }

    /**
     * this method starts the "visitor" procedure by calling the method inside the activity
     */
    public void onClickVisitor(){
        view.startVisitorOption();
    }

}
