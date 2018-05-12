package gr.aueb.softeng.project1804.view.login;

/**
 * Created by marios on 5/12/18.
 */

public class LogInViewStub implements LogInView
{

    private int logInCounter, signUpCounter, visitorCounter;
    private String email, password;


    public LogInViewStub(String email, String password)
    {
        logInCounter = 0;
        signUpCounter = 0;
        visitorCounter = 0;
        this.email = email;
        this.password = password;
    }

    public int getLogInCounter()
    {
        return logInCounter;
    }

    public int getSignUpCounter()
    {
        return signUpCounter;
    }

    public int getVisitorCounter()
    {
        return visitorCounter;
    }

    @Override
    public void startLogInOption()
    {
        logInCounter++;
    }

    @Override
    public void startSignUpOption()
    {
        signUpCounter++;
    }

    @Override
    public void startVisitorOption()
    {
        visitorCounter++;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public String getPassword()
    {
        return password;
    }
}
