package gr.aueb.softeng.project1804;

import java.util.List;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Service
{
    private String serviceCode;
    private double serviceCost;
    private String description;
    private List<Category> categories;
    private List<TechnicianService> technicians;

    public Service()
    {
    }

    public Service(String serviceCode, double serviceCost, String description, List<Category> categories, List<TechnicianService> technicians)
    {
        this.serviceCode = serviceCode;
        this.serviceCost = serviceCost;
        this.description = description;
        this.categories = categories;
        this.technicians = technicians;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
    }

    public double getServiceCost()
    {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost)
    {
        this.serviceCost = serviceCost;
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

    public List<TechnicianService> getTechnicians()
    {
        return technicians;
    }
}
