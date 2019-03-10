package gr.aueb.softeng.project1804.sevice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.login.LogInPresenter;
import gr.aueb.softeng.project1804.view.login.LogInViewStub;
import gr.aueb.softeng.project1804.view.service.ServiceAssignPresenter;
import gr.aueb.softeng.project1804.view.service.ServiceAssignViewStub;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class ServiceAssignPresenterTest
{
    private ServiceAssignPresenter presenter;
    private ServiceAssignViewStub stub;


    @Before
    public void setUp() throws Exception
    {
        stub = new ServiceAssignViewStub();
        presenter = new ServiceAssignPresenter(stub);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the signup
     */
    @Test
    public void onClickSignUpTest()
    {
        presenter.onClickSignUp();

        Assert.assertEquals(stub.getServicesAssigned(), 1);
    }
}
