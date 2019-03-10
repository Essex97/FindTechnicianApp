package gr.aueb.softeng.project1804.payment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.view.login.LogInPresenter;
import gr.aueb.softeng.project1804.view.login.LogInViewStub;
import gr.aueb.softeng.project1804.view.payment.PaymentPresenter;
import gr.aueb.softeng.project1804.view.payment.PaymentViewStub;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class PaymentPresenterTest
{
    private PaymentPresenter presenter;
    private PaymentViewStub stub;


    @Before
    public void setUp() throws Exception
    {
        stub = new PaymentViewStub();
        presenter = new PaymentPresenter(stub);
    }

    /**
     * This method, tests the code that is responsible for
     * executing payments
     */
    @Test
    public void onClickPayTest()
    {
        presenter.onClickPay();

        Assert.assertEquals(stub.getStartPayOption(), 1);
    }

    /**
     * This method, tests the code that is responsible for
     * executing evaluations
     */
    @Test
    public void onClickEvaluateTest()
    {
        presenter.onClickEvaluate();

        Assert.assertEquals(stub.getStartEvaluationOption(), 1);
    }
    /**
     * This method, tests the code that is responsible for
     * selecting a technician
     */
    @Test
    public void onChooseTecnichian()
    {
        presenter.onChooseTechnician();

        Assert.assertEquals(stub.getStartChooseTechnician(), 1);
    }

}
