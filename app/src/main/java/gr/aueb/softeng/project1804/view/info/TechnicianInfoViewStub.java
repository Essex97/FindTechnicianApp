package gr.aueb.softeng.project1804.view.info;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class TechnicianInfoViewStub implements TechnicianInfoView
{
    private int startSignupOption;

    public TechnicianInfoViewStub()
    {
        startSignupOption=0;
    }
    @Override
    public void startRequestOption()
    {
        startSignupOption++;
    }

    public int getStartSignupOption()
    {
        return startSignupOption;
    }
}
