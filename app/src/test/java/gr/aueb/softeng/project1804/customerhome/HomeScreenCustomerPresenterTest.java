package gr.aueb.softeng.project1804.customerhome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.customerhome.HomeScreenCustomerPresenter;
import gr.aueb.softeng.project1804.view.customerhome.HomeScreenCustomerViewStub;
import gr.aueb.softeng.project1804.view.customerhome.ListAdapter;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class HomeScreenCustomerPresenterTest
{
    private HomeScreenCustomerPresenter presenter;
    private HomeScreenCustomerViewStub stub;
    private ListAdapter listAdapter;

    @Before
    public void setUp() throws Exception
    {
        stub = new HomeScreenCustomerViewStub();
        presenter = new HomeScreenCustomerPresenter(stub, listAdapter);
    }

    /**
     * This method, tests the code that is responsible for
     * handling the presses of the -pay- button.
     */
    @Test
    public void onClickCreatePayment()
    {
        presenter.onClickCreatePayment();

        Assert.assertEquals(stub.getPayments(), 1);
    }

}
