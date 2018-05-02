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

    /**
     * Helped Constructor which initialize the state
     * of a new OfferedService
     *
     * @param technician  The technician of this OfferedService
     * @param service The service offered by the technician
     * @param cost The cost charged by the technician
     */
    public OfferedService(Technician technician, Service service, double cost)
    {
        this.technician = technician;
        this.service = service;
        this.cost = cost;
    }

    /**
     * @return the technician of this OfferedService Object
     */
    public Technician getTechnician()
    {
        return technician;
    }

    /**
     * This is a setter which sets the technician
     * @param technician - the technician to be set
     */
    public void setTechnician(Technician technician)
    {
        this.technician = technician;
    }

    /**
     * @return the service of this OfferedService Object
     */
    public Service getService()
    {
        return service;
    }

    /**
     * This is a setter which sets the service
     * @param service - the service to be set
     */
    public void setService(Service service)
    {
        this.service = service;
    }

    /**
     * @return the cost of this OfferedService Object
     */
    public double getCost()
    {
        return cost;
    }

    /**
     * This is a setter which sets the cost
     * @param cost - the cost to be set in case it's bigger than 0
     */
    public void setCost(double cost)
    {
        this.cost = cost < 0.0 ? 0.0 : cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferedService that = (OfferedService) o;

        if (Double.compare(that.cost, cost) != 0) return false;
        if (technician != null ? !technician.equals(that.technician) : that.technician != null)
            return false;
        return service != null ? service.equals(that.service) : that.service == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = technician != null ? technician.hashCode() : 0;
        result = 31 * result + (service != null ? service.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
