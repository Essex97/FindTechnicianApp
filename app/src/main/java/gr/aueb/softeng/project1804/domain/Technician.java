package gr.aueb.softeng.project1804.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marios on 4/15/18.
 */

public class Technician extends User implements Serializable
{
    private List<Request> requests;
    private List<OfferedService> services;
    private List<String> availableDays;
    private List<String> availableHours;


    /**
     * This is the constructor of the Technician class.
     * @param firstName The first name.
     * @param lastName The last name.
     * @param phone The phone.
     * @param email The email.
     */
    public Technician(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        requests = new ArrayList<Request>();
        services = new ArrayList<OfferedService>();
    }

    /**
     * This is the default constructor of the Technician class.
     */
    public Technician()
    {
        super();
    }

    /**
     * The getter for the list that contains the requests.
     * @return The list with the requests.
     */
    public List<Request> getRequests() {
        return requests;
    }

    /**
     * The setter for the requests list.
     * @param requests The new requests list.
     */
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    /**
     * The getter for the list that contains the services that the technician offers.
     * @return The list with the offered services.
     */
    public List<OfferedService> getServices() {
        return services;
    }

    /**
     * The setter for the services list.
     * @param services The new serveces list.
     */
    public void setServices(List<OfferedService> services) {
        this.services = services;
    }

    /**
     * This is the getter for the available days of the Technician.
     * @return The list with the available days.
     */
    public List<String> getAvailableDays() {
        return availableDays;
    }

    /**
     * The setter of the availabledDays list.
     * @param availableDays The new list of available days.
     */
    public void setAvailableDays(List<String> availableDays){
        this.availableDays = availableDays;
    }

    /**
     * This is the getter for the available hours of the Technician.
     * @return The list with the available hours.
     */
    public List<String> getAvailableHours() {
        return availableHours;
    }

    /**
     * The setter of the availableHours list.
     * @param availableHours The new list of available hours.
     */
    public void setAvailableHours(List<String> availableHours) {
        this.availableHours = availableHours;
    }

    /**
     * This method returns a list with all the approved requests.
     * @return A list with the approved requests.
     */
    public List<Request> getApprovedRequests()
    {
        if (requests == null)
            return null;

        List<Request> approved = new ArrayList<Request>();

        for (Request request : requests)
            if (request.isApproved())
                approved.add(request);
        return approved;
    }

    /**
     * This method returns a list with all the pending requests.
     * @return A lists with all the pending requests.
     */
    public List<Request> getPendingRequests()
    {
        if (requests == null)
            return null;

        List<Request> pending = new ArrayList<Request>();

        for (Request request : requests)
            if (!request.isApproved())
                pending.add(request);
        return pending;
    }

    /**
     * This method approves a specific request.
     * @param request The request.
     */
    public void approve(Request request)
    {
        if (request == null)
            throw new IllegalArgumentException();

        request.setApproved(true);
    }

    /**
     * The setter for the requests list.
     * @param rq The new requests list.
     */
    public void setRequest(Request rq){
        requests.add(rq);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Technician that = (Technician) o;

        if (requests != null ? !requests.equals(that.requests) : that.requests != null)
            return false;
        if (services != null ? !services.equals(that.services) : that.services != null)
            return false;
        if (availableDays != null ? !availableDays.equals(that.availableDays) : that.availableDays != null)
            return false;
        return availableHours != null ? availableHours.equals(that.availableHours) : that.availableHours == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (requests != null ? requests.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (availableDays != null ? availableDays.hashCode() : 0);
        result = 31 * result + (availableHours != null ? availableHours.hashCode() : 0);
        return result;
    }
}
