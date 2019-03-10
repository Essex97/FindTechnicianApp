package gr.aueb.softeng.project1804.view.main;

/**
 * Created by marios on 5/12/18.
 */

public class MainScreenViewStub implements MainScreenView
{
    private int startCustomerCounter, startTechnicianCounter;

    public MainScreenViewStub()
    {
        startCustomerCounter = 0;
        startTechnicianCounter = 0;
    }

    @Override
    public void startCustomerOption()
    {
        startCustomerCounter++;
    }

    @Override
    public void startTechnicianOption()
    {
        startTechnicianCounter++;
    }

    public int getStartCustomerCounter()
    {
        return startCustomerCounter;
    }

    public int getStartTechnicianCounter()
    {
        return startTechnicianCounter;
    }
}
