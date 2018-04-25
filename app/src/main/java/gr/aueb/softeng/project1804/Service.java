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

    public Service()
    {
        this.serviceCode = ++counter+"";
    }

    public Service(String description, List<Category> categories, List<OfferedService> OfferedServices)
    {
        this();
        this.description = description;
        this.categories = categories;
        this.OfferedServices = OfferedServices;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public static int getCounter() {
        return counter;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<OfferedService> getOfferedServices() {
        return OfferedServices;
    }

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
