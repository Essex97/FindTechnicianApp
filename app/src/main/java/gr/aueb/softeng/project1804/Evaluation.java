package gr.aueb.softeng.project1804;

public class Evaluation
{
    private Scale workQuality;
    private Scale priceEvaluation;
    private String comment;
    private Customer customer;
    private Technician technician;
    private Scale technicianBehavior;

    public Scale getTechnicianBehavior()
    {
        return technicianBehavior;
    }

    public Scale getWorkQuality()
    {
        return workQuality;
    }

    public Scale getPriceEvaluation()
    {
        return priceEvaluation;
    }

    public String getComment()
    {
        return comment;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public Technician getTechnician()
    {
        return technician;
    }

}