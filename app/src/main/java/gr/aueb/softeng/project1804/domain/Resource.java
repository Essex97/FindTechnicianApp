package gr.aueb.softeng.project1804.domain;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Resource
{
    private String name;
    private double price;
    private int quantity;

    /**
     * Default Constructor
     */
    public Resource()
    {
    }

    /**
     * Helped Constructor which initialize the state
     * of a new Resource
     *
     * @param name  The name of this Resource Object
     * @param price The price of this Resource Object
     * @param quantity The quantity of this Resource Object
     */
    public Resource(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return the name of this Resource Object
     */
    public String getName()
    {
        return name;
    }

    /**
     * This is a setter which sets the name
     * @param name - the name to be set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the price of this Resource Object
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * This is a setter which sets the price
     * @param price - the price to be set
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * @return the quantity of this Resource Object
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * This is a setter which sets the quantity
     * @param quantity - the quantity to be set in case it's bigger than 0
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity < 0 ? 0 : quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (Double.compare(resource.price, price) != 0) return false;
        if (quantity != resource.quantity) return false;
        return name != null ? name.equals(resource.name) : resource.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }
}
