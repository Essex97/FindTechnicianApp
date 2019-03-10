package gr.aueb.softeng.project1804.view.customerhome;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class HomeScreenCustomerViewStub implements  HomeScreenCustomerView
{
    private int payments;
    public HomeScreenCustomerViewStub()
    {
        payments=0;

    }

    /**
     * This method increases the payments counter so we can make tests
     */
    @Override
    public void startPaymentOption()
    {
        payments++;
    }

    public int getPayments()
    {
        return payments;
    }
}
