package gr.aueb.softeng.project1804;

public class Payment
{
    private String paymentCode;
    private double totalCost;
    private boolean paidFlag;
    private Visit Visit;

    public boolean getPaidFlag()
    {
        return paidFlag;
    }

    public String getPaymentCode()
    {
        return paymentCode;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void pay(boolean paidFlag)
    {
        this.paidFlag = paidFlag;
    }
}