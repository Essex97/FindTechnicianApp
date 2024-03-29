package gr.aueb.softeng.project1804.domain;

/**
 * Created by Stratos on 11/4/2018.
 */

public class Category
{
    private String code;
    private static int counter = 0;
    private String title;
    private String description;

    /**
     * Default Constructor
     */
    public Category()
    {
        this.code = ++counter+"";
    }

    /**
     * Helped Constructor which initialize the state
     * of a new category
     *
     * @param title       The title of the Category
     * @param description A description of this category
     */
    public Category(String title, String description)
    {
        this();
        this.title = title;
        this.description = description;
    }

    /**
     * @return the unique code of the object
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @return the static counter of the class which
     * help as to give a specific code of each object
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * @return the title of the category
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * This is a setter which sets the title
     * @param title - the title to be set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the description of each Category Object
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * This is a setter which sets the description
     * @param description - the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
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
