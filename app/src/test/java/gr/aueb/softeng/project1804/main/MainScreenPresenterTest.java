package gr.aueb.softeng.project1804.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.main.MainScreenPresenter;
import gr.aueb.softeng.project1804.view.main.MainScreenView;
import gr.aueb.softeng.project1804.view.main.MainScreenViewStub;

/**
 * Created by marios on 5/12/18.
 */

public class MainScreenPresenterTest
{
    private MainScreenViewStub stub;
    private MainScreenPresenter presenter;
    @Before
    public void setUp() throws Exception
    {
        stub = new MainScreenViewStub();
        presenter = new MainScreenPresenter(stub);
    }

    /**
     * This method tests the code that is responsible for
     * handling the presses of the customer button.
     */
    @Test
    public void startCustomerOptionTest()
    {
        presenter.onClickCustomer();

        Assert.assertEquals(stub.getStartCustomerCounter(), 1);
    }

    /**
     * This method tests the code that is responsible for
     * handling the presses of the customer button.
     */
    @Test
    public void startTechnicianOptionTest()
    {
        presenter.onClickTechnician();

        Assert.assertEquals(stub.getStartTechnicianCounter(), 1);
    }
}
