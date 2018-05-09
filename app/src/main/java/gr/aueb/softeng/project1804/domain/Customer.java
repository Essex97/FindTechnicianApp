package gr.aueb.softeng.project1804.domain;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by marios on 4/15/18.
 */

public class Customer extends User
{
    private List<Request> requests;
    private List<Evaluation> evaluations;

    public Customer()
    {
        super();
    }

    public Customer(String firstName, String lastName, String phone, String email)
    {
        super(firstName, lastName, phone, email);
        requests = new ArrayList<Request>();
        evaluations = new ArrayList<Evaluation>();
    }

    public List<Request> getRequests()
    {
        return requests;
    }

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

    public List<Evaluation> getEvaluations()
    {
        return evaluations;
    }

    public void createRequests(String date, String time, Technician technician, List<OfferedService> services)
    {
        if (date == null)
            throw new IllegalArgumentException();

        if (time == null)
            throw new IllegalArgumentException();

        if (technician == null)
            throw new IllegalArgumentException();

        if (services == null)
            throw new IllegalArgumentException();


        Request request = new Request(date, time, technician, this, services);
        requests.add(request);
        technician.setRequest(request);
    }

    public void pay(Request request, double givenAmount)
    {
        if (request == null)
            throw new IllegalArgumentException();

        if (givenAmount < 0)
            throw new IllegalArgumentException();

        Visit visit = request.getVisit();

        if (visit != null)
            visit.createPayment(givenAmount);
    }

    public Evaluation evaluate(Technician technician, Visit visit)
    {
        if (technician == null)
            throw new IllegalArgumentException();

        if (visit == null)
            throw new IllegalArgumentException();

        Evaluation evaluation = new Evaluation(technician, visit);
        evaluations.add(evaluation);
        return evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (requests != null ? !requests.equals(customer.requests) : customer.requests != null)
            return false;
        return evaluations != null ? evaluations.equals(customer.evaluations) : customer.evaluations == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (requests != null ? requests.hashCode() : 0);
        result = 31 * result + (evaluations != null ? evaluations.hashCode() : 0);
        return result;
    }
}
