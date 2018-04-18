package gr.aueb.softeng.project1804;

import java.util.List;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Service
{
    private String serviceCode;
    private String description;
    private List<Category> categories;
    private List<OfferedService> OfferedServices;

    public Service()
    {
    }

    public Service(String serviceCode, String description, List<Category> categories, List<OfferedService> OfferedServices)
    {
        this.serviceCode = serviceCode;
        this.description = description;
        this.categories = categories;
        this.OfferedServices = OfferedServices;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
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

    public List<OfferedService> getTechnicians()
    {
        return OfferedServices;
    }
}
