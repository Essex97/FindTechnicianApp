package gr.aueb.softeng.project1804;

import java.util.Date;
import java.util.ArrayList;

public class Visit
{
    private Request request;
    private static int counter = 0;
    private String visitID;
    private ArrayList<Resource> resources;
    private Payment payment;

    /**
     * Constructor
     *
     * @param request the request that initialized the visit
     *
     */
    public Visit(Request request)
    {
        counter++;
        visitID = counter + "";
        this.request = request;
    }

    /**
     * @return unique id
     */
    public String visitID()
    {
        return visitID;
    }

    /**
     * @return the date that the visit will take place
     */
    public Date getDate()
    {
        return request.getDate();
    }

    /**
     * @param date sets the Visit's date to date
     */
    public void setDate(Date date)
    {
        request.setDate(date);
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
        return request.getTechnician();
    }

    /**
     * @return the customer that requested the visit
     */
    public Customer getCustomer()
    {
        return request.getCustomer();
    }


    /**
     * This method will create a Payment object as soon as the customer pays for the service
     * @param amount the amount of money
     */
    public void createPayment(double amount)
    {
        double totalCost = 0;

        for (OfferedService ofsrv : request.getOfferedService()){
            totalCost = totalCost + ofsrv.getCost();
        }

        if (resources != null){
            for (Resource rc : resources){
                totalCost = totalCost + rc.getPrice();
            }
        }

        if(amount >= totalCost){
            payment = new Payment(amount);
        }
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

        if (request != null ? !request.equals(visit.request) : visit.request != null) return false;
        if (!visitID.equals(visit.visitID)) return false;
        if (resources != null ? !resources.equals(visit.resources) : visit.resources != null)
            return false;
        return payment != null ? payment.equals(visit.payment) : visit.payment == null;
    }

    @Override
    public int hashCode()
    {
        int result = request != null ? request.hashCode() : 0;
        result = 31 * result + visitID.hashCode();
        result = 31 * result + (resources != null ? resources.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        return result;
    }
}