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
