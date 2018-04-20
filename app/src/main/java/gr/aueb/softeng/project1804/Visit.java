package gr.aueb.softeng.project1804;

import java.util.Date;
import java.util.ArrayList;

public class Visit
{
    private Date date;
    private Request request;
    private ArrayList<Resource> resources;
    private Payment payment;
    private Technician technician;

    /**
     * Constructor
     *
     * @param request the request that initialized the visit
     * @param technician the technician that was requested and then accepted the request
     */
    public Visit(Request request, Technician technician)
    {
        date = request.getDate();
        this.request = request;
        this.technician = technician;
    }

    /**
     * @return the date that the visit will take place
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date sets the Visit's date to date
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return the request that initialized the visit
     */
    public Request getRequest()
    {
        return request;
    }

    /**
     * @return the resources that will be used during the visit
     */
    public ArrayList<Resource> getResources()
    {
        return resources;
    }

    /**
     * @param resources sets the Visit's resources to resources
     */
    public void setResources(ArrayList<Resource> resources)
    {
        this.resources = resources;
    }

    /**
     * @return the payment of the visit
     */
    public Payment getPayment()
    {
        return payment;
    }

    /**
     * @return the technician that will attend
     */
    public Technician getTechnician()
    {
        return technician;
    }

    /**
     * This method will create a Payment object as soon as the customer pays for the service
     * @param amount the amount of money
     */
    public void createPayment(double amount)
    {
        payment = new Payment(amount);
    }

    /**
     * @param o object to compare with the current
     * @return true or false
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (!date.equals(visit.date)) return false;
        if (!request.equals(visit.request)) return false;
        if (!resources.equals(visit.resources)) return false;
        if (payment != null ? !payment.equals(visit.payment) : visit.payment != null) return false;
        return technician.equals(visit.technician);
    }

    @Override
    public int hashCode()
    {
        int result = date.hashCode();
        result = 31 * result + request.hashCode();
        result = 31 * result + resources.hashCode();
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + technician.hashCode();
        return result;
    }
}