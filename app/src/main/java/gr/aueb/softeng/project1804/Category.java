package gr.aueb.softeng.project1804;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Category
{
    private String code;
    private String title;
    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (code != null ? !code.equals(category.code) : category.code != null) return false;
        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        return description != null ? description.equals(category.description) : category.description == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
