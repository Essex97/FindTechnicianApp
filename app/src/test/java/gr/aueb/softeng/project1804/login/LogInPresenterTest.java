package gr.aueb.softeng.project1804.login;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.login.LogInPresenter;
import gr.aueb.softeng.project1804.view.login.LogInViewStub;

/**
 * Created by marios on 5/12/18.
 */

public class LogInPresenterTest
{
    private LogInPresenter presenter;
    private LogInViewStub stub;

    public static final String email = "email";
    public static final String PASSWORD = "password";

    @Before
    public void setUp() throws Exception
    {
        stub = new LogInViewStub(email, PASSWORD);
        presenter = new LogInPresenter(stub);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the presses of the login button.
     */
    @Test
    public void onClickSignUpTest()
    {
        presenter.onClickLogIn();

        Assert.assertEquals(stub.getLogInCounter(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the presses of the sing up button.
     */
    @Test
    public void startSignUpOptionTest()
    {
        presenter.onClickSignUp();

        Assert.assertEquals(stub.getSignUpCounter(), 1);
    }

    /**
     * This method tests the code that is responsible for
     * handling the presses of the continue as visitor button.
     */
    @Test
    public void startVisitorOptionTest()
    {
        presenter.onClickVisitor();

        Assert.assertEquals(stub.getVisitorCounter(), 1);

    }

    /**
     * This method tests the code that is responsible for
     * returning the email.
     */
    @Test
    public void getEmailTest()
    {
        Assert.assertEquals(stub.getEmail(), email);
    }

    /**
     * This method tests the the code that is responsible for
     * returning the password.
     */
    @Test
    public void getPasswordTest()
    {
        Assert.assertEquals(stub.getPassword(), PASSWORD);
    }
}
