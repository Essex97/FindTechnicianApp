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

    /**
     * This is the default constructor of the Customer class.
     */
    public Customer()
    {
        super();
    }

    /**
     * This is the constructor of the Customer class.
     * @param firstName The first name of the Customer.
     * @param lastName The last name of the Customer.
     * @param phone The phone of the Costomer.
     * @param email The email of the Customer.
     */
    public Customer(String firstName, String lastName, String phone, String email)
    {
        super(firstName, lastName, phone, email);
        requests = new ArrayList<Request>();
        evaluations = new ArrayList<Evaluation>();
    }

    /**
     * This is the getter of the requests list.
     * @return The list that contains the requests that this user has created.
     */
    public List<Request> getRequests()
    {
        return requests;
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
     * This method adds a request into the list
     * @param request new request
     */
    public void addRequest(Request request){
        requests.add(request);
    }

    /**
     * The getter for the evaluations list.
     * @return The evaluations.
     */
    public List<Evaluation> getEvaluations()
    {
        return evaluations;
    }

    /**
     * This method creates a new requests with the specified attributes.
     * @param date The date that the visit will take place.
     * @param time The time that the visit will take place.
     * @param technician The technician that will go to the visit.
     * @param services The lists with the services that the customer wants.
     */
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

    /**
     * This method is responsible for paying the technician of
     * a given request with a certain amount. If the amount is
     * not enough then an IllegalArgumentException is thrown.
     * @param request The request that is to be paid.
     * @param givenAmount The amount of money.
     */
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

    /**
     * This method evaluates a technician according to a specific visit.
     * @param technician The technician that has to be evaluated.
     * @param visit The visit.
     * @return The evaluation object.
     */
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
