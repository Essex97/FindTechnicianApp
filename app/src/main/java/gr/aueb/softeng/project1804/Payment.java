package gr.aueb.softeng.project1804;

public class Payment
{
    private int counter = 0;
    private String paymentCode;
    private double totalCost;

    /**
     * Constructor
     *
     * @param totalCost the total amount paid for this service
     */
    public Payment(double totalCost)
    {
        counter++;
        paymentCode = counter + "";
        this.totalCost = totalCost;
    }

    /**
     * @return the unique code of this Payment
     */
    public String getPaymentCode()
    {
        return paymentCode;
    }

    /**
     * @return the total amount paid for this service
     */
    public double getTotalCost()
    {
        return totalCost;
    }

    /**
     * @param paymentCode sets the Payment's paymentCode to paymentCode
     */
    public void setPaymentCode(String paymentCode)
    {
        this.paymentCode = paymentCode;
    }

    /**
     * @param totalCost sets the Payment's totalCost to totalCost
     */
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
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

        Payment payment = (Payment) o;

        if (counter != payment.counter) return false;
        if (Double.compare(payment.totalCost, totalCost) != 0) return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = counter;
        result = 31 * result + paymentCode.hashCode();
        temp = Double.doubleToLongBits(totalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}