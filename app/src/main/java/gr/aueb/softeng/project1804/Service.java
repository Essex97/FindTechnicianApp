package gr.aueb.softeng.project1804;

import java.util.List;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Service
{
    private String serviceCode;
    private static int counter = 0;
    private String description;
    private List<Category> categories;
    private List<OfferedService> OfferedServices;

    /**
     * Default Constructor
     */
    public Service()
    {
        this.serviceCode = ++counter+"";
    }

    /**
     * Helped Constructor which initialize the state
     * of a new service
     *
     * @param description A description of this service
     * @param categories A list of categories in which the service belongs to
     * @param OfferedServices A List of OfferedServices which can provide this service
     */
    public Service(String description, List<Category> categories, List<OfferedService> OfferedServices)
    {
        this();
        this.description = description;
        this.categories = categories;
        this.OfferedServices = OfferedServices;
    }

    /**
     * @return the unique code of the object
     */
    public String getServiceCode()
    {
        return serviceCode;
    }

    /**
     * @return the static counter of the class which
     * help as to give a specific code of each object
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * @return the description of each Service Object
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * This is a setter which sets the description
     * @param description - the description to be set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the categories of each Service Object
     */
    public List<Category> getCategories()
    {
        return categories;
    }

    /**
     * This is a setter which sets the categories
     * @param categories - the categories to be set
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * @return the OfferedServices of each Service Object
     */
    public List<OfferedService> getOfferedServices() {
        return OfferedServices;
    }

    /**
     * This is a setter which sets the offeredServices
     * @param categories - the offeredServices to be set
     */
    public void setOfferedServices(List<OfferedService> offeredServices) {
        OfferedServices = offeredServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (description != null ? !description.equals(service.description) : service.description != null)
            return false;
        if (categories != null ? !categories.equals(service.categories) : service.categories != null)
            return false;
        return OfferedServices != null ? OfferedServices.equals(service.OfferedServices) : service.OfferedServices == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (OfferedServices != null ? OfferedServices.hashCode() : 0);
        return result;
    }
}
