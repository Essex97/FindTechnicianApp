package gr.aueb.softeng.project1804.view.technicianhome;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class TechnicianHomeViewStub implements TechnicianHomeView
{
    private int requests, visits;

    public TechnicianHomeViewStub()
    {
        requests=0;
        visits=0;
    }

    @Override
    public void startRequestsOption()
    {
        requests++;
    }

    @Override
    public void startVisitsOption()
    {
        visits++;
    }

    public int getRequests()
    {
        return requests;
    }

    public int getVisits()
    {
        return visits;
    }
}
