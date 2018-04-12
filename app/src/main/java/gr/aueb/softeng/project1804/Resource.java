package gr.aueb.softeng.project1804;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Resource
{
    private String name;
    private double price;
    private int quantity;

    public Resource()
    {
    }

    public Resource(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
