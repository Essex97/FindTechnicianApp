package gr.aueb.softeng.project1804.view.service;

/**
 * Created by dimitrisstaratzis on 5/13/18.
 */

public class ServiceAssignViewStub implements ServiceAssignView
{
    private int servicesAssigned;
    public ServiceAssignViewStub()
    {
        servicesAssigned=0;
    }
    @Override
    public void startSignUpOption()
    {
        servicesAssigned++;
    }

    public int getServicesAssigned()
    {
        return servicesAssigned;
    }
}
