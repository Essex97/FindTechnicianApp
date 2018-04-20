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

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Request getRequest()
    {
        return request;
    }

    public ArrayList<Resource> getResources()
    {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources)
    {
        this.resources = resources;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public Technician getTechnician()
    {
        return technician;
    }

    public void createPayment(double amount)
    {
        payment = new Payment(amount);
    }

}