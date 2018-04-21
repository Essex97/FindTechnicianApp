package gr.aueb.softeng.project1804;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marios on 4/15/18.
 */

public class Technician extends User
{
    public Technician(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        requests = new ArrayList<Request>();
        services = new ArrayList<OfferedService>();
    }

    private List<Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<OfferedService> getServices() {
        return services;
    }

    public void setServices(List<OfferedService> services) {
        this.services = services;
    }

    private List<OfferedService> services;



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

    public void approve(Request request)
    {
        if (request == null)
            throw new IllegalArgumentException();

        request.setApproved(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Technician that = (Technician) o;

        if (requests != null ? !requests.equals(that.requests) : that.requests != null)
            return false;
        return services != null ? services.equals(that.services) : that.services == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (requests != null ? requests.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }
}
