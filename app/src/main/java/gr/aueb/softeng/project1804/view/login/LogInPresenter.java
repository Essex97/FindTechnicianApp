package gr.aueb.softeng.project1804.view.login;

/**
 * Created by Stratos on 7/5/2018.
 */

public class LogInPresenter {

    private LogInView view;

    public LogInPresenter(LogInView view){ this.view = view;}

    public void onClickSignUp(){
        view.startSignUpOption();
    }

    public void onClickLogIn(){
        view.startLogInOption();
    }

    public void onClickVisitor(){
        view.startVisitorOption();
    }

}
