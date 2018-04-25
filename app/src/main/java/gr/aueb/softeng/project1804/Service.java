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
        this.serviceCode = ++counter+"";
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

    public List<OfferedService> getOfferedServices() {
        return OfferedServices;
    }

    public void setOfferedServices(List<OfferedService> offeredServices) {
        OfferedServices = offeredServices;
    }
}
