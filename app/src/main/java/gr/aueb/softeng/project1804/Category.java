package gr.aueb.softeng.project1804;

import java.util.List;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Category
{
    private String code;
    private String title;
    private String description;
    private List<Service> services;

    /**
     * Default Constructor
     */
    public Category()
    {
    }

    /**
     * Helped Constructor which initialize the state
     * of a new category
     *
     * @param code        The code of the Category
     * @param title       The title of the Category
     * @param description A description of this category
     */
    public Category(String code, String title, String description)
    {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Service> getServices()
    {
        return services;
    }

}
