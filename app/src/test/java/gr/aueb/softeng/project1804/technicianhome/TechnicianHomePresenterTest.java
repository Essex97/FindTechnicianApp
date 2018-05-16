package gr.aueb.softeng.project1804.technicianhome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.login.LogInPresenter;
import gr.aueb.softeng.project1804.view.login.LogInViewStub;
import gr.aueb.softeng.project1804.view.technicianhome.RequestAdapter;
import gr.aueb.softeng.project1804.view.technicianhome.TechnicianHomeViewStub;
import gr.aueb.softeng.project1804.view.technicianhome.TechnicianScreenPresenter;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class TechnicianHomePresenterTest
{
    private TechnicianScreenPresenter presenter;
    private TechnicianHomeViewStub stub;
    private RequestAdapter a;

    @Before
    public void setUp() throws Exception
    {
        stub = new TechnicianHomeViewStub();
        a = null;
        presenter = new TechnicianScreenPresenter(stub,a);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the presses of the request button.
     */
    @Test
    public void onClickRequestsTest()
    {
        presenter.onClickRequests();

        Assert.assertEquals(stub.getRequests(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the presses of the visit button.
     */
    @Test
    public void onClickVisitsTest()
    {
        presenter.onClickVisits();

        Assert.assertEquals(stub.getVisits(), 1);
    }


}
