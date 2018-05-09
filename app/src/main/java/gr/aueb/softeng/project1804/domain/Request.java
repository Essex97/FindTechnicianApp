package gr.aueb.softeng.project1804.domain;

import java.util.*;

public class Request
{
    private static int counter = 0;
    private String requestCode;
    private String date;
    private String time;
    private Visit visit;
    private Technician technician;
    private Customer customer;
    private ArrayList<OfferedService> offeredServices;

    /**
     * Constructor-1
     *
     * @param date creation date of the Request
     * @param time creation time of the Request
     * @param technician the technician to whom the Request refers to
     * @param customer the customer who initialized the request
     * @param offeredServices
     */
    public Request(String date, String time, Technician technician, Customer customer, List<OfferedService> offeredServices)
    {
        this.requestCode = ++counter + "";
        this.date = date;
        this.technician = technician;
        this.time = time;
        this.customer = customer;
        this.offeredServices = (ArrayList<OfferedService>)offeredServices;
    }

    /**
     * Constructor-2
     *
     * @param date creation date of the Request
     * @param time creation time of the Request
     * @param customer the customer who initialized the request
     * @param offeredServices
     */
    public Request(String date, String time, Customer customer, ArrayList<OfferedService> offeredServices)
    {
        this(date, time, null, customer, offeredServices );
    }

    /**
     * @param approved sets the Request's approved to approved
     * If approved a visit object is created
     */
    public void setApproved(boolean approved)
    {
        if(approved && !isApproved())
        {
            visit = new Visit(this);
        }else
        {
            visit = null;
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
     * @return the static counter of the class
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * @return the date of the Request
     */
    public String getDate()
    {
        return date;
    }

    /**
     * @param newDate sets the Request's date to newDate
     */
    public void setDate(String newDate)
    {
        date = newDate;
    }

    /**
     * @return the time of the Request
     */
    public String getTime()
    {
        return time;
    }

    /**
     * @param newTime sets the Request's time to newTime
     */
    public void setTime(String newTime)
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
    public ArrayList<OfferedService>  getOfferedService()
    {
        return offeredServices;
    }

    /**
     * @param offeredService sets the Request's offeredService to offeredService
     */
    public void setOfferedServices(ArrayList<OfferedService> offeredService)
    {
        this.offeredServices = offeredServices;
    }

    /**
     * @param o object to compare with the current
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (date != null ? !date.equals(request.date) : request.date != null) return false;
        if (time != null ? !time.equals(request.time) : request.time != null) return false;
        if (visit != null ? !visit.equals(request.visit) : request.visit != null) return false;
        if (technician != null ? !technician.equals(request.technician) : request.technician != null)
            return false;
        if (customer != null ? !customer.equals(request.customer) : request.customer != null)
            return false;
        return offeredServices != null ? offeredServices.equals(request.offeredServices) : request.offeredServices == null;
    }

    @Override
    public int hashCode() {
        int result =  0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (visit != null ? visit.hashCode() : 0);
        result = 31 * result + (technician != null ? technician.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (offeredServices != null ? offeredServices.hashCode() : 0);
        return result;
    }
}


