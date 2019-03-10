package gr.aueb.softeng.project1804.info;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.info.TechnicianInfoPresenter;
import gr.aueb.softeng.project1804.view.info.TechnicianInfoView;
import gr.aueb.softeng.project1804.view.info.TechnicianInfoViewStub;
import gr.aueb.softeng.project1804.view.login.LogInPresenter;
import gr.aueb.softeng.project1804.view.login.LogInViewStub;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class TechnicianInfoPresenterTest
{
    private TechnicianInfoPresenter presenter;
    private TechnicianInfoViewStub stub;

    @Before
    public void setUp() throws Exception
    {
        stub = new TechnicianInfoViewStub();
        presenter = new TechnicianInfoPresenter(stub);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the presses of the login button.
     */
    @Test
    public void onClickRequestTest()
    {
        presenter.onClickRequest();

        Assert.assertEquals(stub.getStartSignupOption(), 1);
    }

}
