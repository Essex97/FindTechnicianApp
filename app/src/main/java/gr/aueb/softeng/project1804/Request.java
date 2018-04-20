package gr.aueb.softeng.project1804;

import java.sql.Time;
import java.util.*;

public class Request
{
    private String requestCode;
    private Date date;
    private Time time;
    private Visit visit;
    private boolean approved;
    private Technician technician;
    private Customer customer;
    private OfferedService offeredService;

    /**
     * Constructor-1
     *
     * @param requestCode Each request has a different code
     * @param date creation date of the Request
     * @param time creation time of the Request
     * @param technician the technician to whom the Request refers to
     * @param customer the customer who initialized the request
     */
    public Request(String requestCode, Date date, Time time, Technician technician, Customer customer, OfferedService offeredService)
    {
        this.requestCode = requestCode;
        this.date = date;
        this.technician = technician;
        this.time = time;
        this.customer = customer;
        this.offeredService = offeredService;
    }

    /**
     * Constructor-2
     *
     * @param requestCode Each request has a different code
     * @param date creation date of the Request
     * @param time creation time of the Request
     * @param customer the customer who initialized the request
     */
    public Request(String requestCode, Date date, Time time, Customer customer, OfferedService offeredService)
    {
        this.requestCode = requestCode;
        this.date = date;
        this.technician = technician;
        this.time = time;
        this.customer = null;
        this.offeredService = offeredService;
    }

    /**
     * @param approved sets the Request's approved to approved
     * If approved a visit object is created
     */
    public void setApproved(boolean approved)
    {
        this.approved = approved;
        if(approved)
        {
            visit = new Visit(this, technician);
        }
    }

    /**
     * @return the unique code of each Request
     */
    public String getRequestCode()
    {
        return requestCode;
    }

    /**
     * @return the date of the Request
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param newDate sets the Request's date to newDate
     */
    public void setDate(Date newDate)
    {
        date = newDate;
    }

    /**
     * @return the time of the Request
     */
    public Time getTime()
    {
        return time;
    }

    /**
     * @param newTime sets the Request's time to newTime
     */
    public void setTime(Time newTime)
    {
        time = newTime;
    }

    /**
     * @return the visit associated with the current Request

     */
    public Visit getVisit()
    {
        return visit;
    }

    /**
     * @return the customer associated with this Request
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * @return the technician associated with this Request
     */
    public Technician getTechnician()
    {
        return technician;
    }

    /**
     * @return true if the Request is associated with a Visit other than null or false in any other case
     */
    public boolean isApproved()
    {
        return visit != null;
    }

    /**
     * @return the service chosen by the customer
     */
    public OfferedService getOfferedService()
    {
        return offeredService;
    }

    /**
     * @param offeredService sets the Request's offeredService to offeredService
     */
    public void setOfferedService(OfferedService offeredService)
    {
        this.offeredService = offeredService;
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

        Request request = (Request) o;

        if (approved != request.approved) return false;
        if (!requestCode.equals(request.requestCode)) return false;
        if (!date.equals(request.date)) return false;
        if (!time.equals(request.time)) return false;
        if (!visit.equals(request.visit)) return false;
        if (technician != null ? !technician.equals(request.technician) : request.technician != null)
            return false;
        if (!customer.equals(request.customer)) return false;
        return offeredService.equals(request.offeredService);
    }

    @Override
    public int hashCode()
    {
        int result = requestCode.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + visit.hashCode();
        result = 31 * result + (approved ? 1 : 0);
        result = 31 * result + (technician != null ? technician.hashCode() : 0);
        result = 31 * result + customer.hashCode();
        result = 31 * result + offeredService.hashCode();
        return result;
    }
}


