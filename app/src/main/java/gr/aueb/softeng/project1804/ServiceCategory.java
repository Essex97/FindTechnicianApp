package gr.aueb.softeng.project1804;

/**
 * Created by Stratos on 11/4/2018.
 */

public class ServiceCategory
{
    private Service service;
    private Category category;

    /**
     * Default Constructor
     */
    public ServiceCategory()
    {
    }

    /**
     * @param service  The name of the service
     * @param category The category in which the service belongs
     */
    public ServiceCategory(Service service, Category category)
    {
        this.service = service;
        this.category = category;
    }

    public Service getService()
    {
        return service;
    }

    public Category getCategory()
    {
        return category;
    }
}
