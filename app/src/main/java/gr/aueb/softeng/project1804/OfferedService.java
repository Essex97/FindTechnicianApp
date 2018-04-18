package gr.aueb.softeng.project1804;

/**
 * Created by Stratos on 11/4/2018.
 */

public class OfferedService
{
    private Technician technician;
    private Service service;
    private double cost;

    /**
     * Default Constructor
     */
    public OfferedService()
    {
    }

    public OfferedService(Technician technician, Service service, double cost)
    {
        this.technician = technician;
        this.service = service;
        this.cost = cost;
    }

    public Technician getTechnician()
    {
        return technician;
    }

    public void setTechnician(Technician technician)
    {
        this.technician = technician;
    }

    public Service getService()
    {
        return service;
    }

    public void setService(Service service)
    {
        this.service = service;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost < 0.0 ? 0.0 : cost;
    }
}
