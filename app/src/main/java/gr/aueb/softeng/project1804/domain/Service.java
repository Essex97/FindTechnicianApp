package gr.aueb.softeng.project1804.domain;

import java.util.List;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Service
{
    private String serviceCode;
    private static int counter = 0;
    private String description;
    private Category category;

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
     * @param category A category in which the service belongs to
     */
    public Service(String description, Category category)
    {
        this();
        this.description = description;
        this.category = category;
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
    public Category getCategory()
    {
        return category;
    }

    /**
     * This is a setter which sets the categories
     * @param category - the categories to be set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (serviceCode != null ? !serviceCode.equals(service.serviceCode) : service.serviceCode != null)
            return false;
        if (description != null ? !description.equals(service.description) : service.description != null)
            return false;
        return category != null ? category.equals(service.category) : service.category == null;
    }

    @Override
    public int hashCode() {
        int result = serviceCode != null ? serviceCode.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
