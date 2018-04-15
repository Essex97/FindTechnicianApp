package gr.aueb.softeng.project1804;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marios on 4/15/18.
 */

public class Technician extends User
{
    private List<Visit> visits;
    private List<TechnicianService> services;

    public Technician(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        visists = new ArrayList<Visit>();
        services = new ArrayList<TechnicianService>();
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public List<TechnicianService> getServices() {
        return services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Technician that = (Technician) o;

        if (visits != null && !visits.equals(that.visits))
            return false;
        else if (visits == null &&  that.visits != null)
            return false;

        if (services != null && !services.equals(that.services))
            return false;
        else if (services == null &&  that.services != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (visits != null ? visits.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }
}
