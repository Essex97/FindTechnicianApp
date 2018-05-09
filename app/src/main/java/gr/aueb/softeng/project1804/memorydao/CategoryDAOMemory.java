package gr.aueb.softeng.project1804.memorydao;

import java.util.ArrayList;

import gr.aueb.softeng.project1804.domain.Category;

/**
 * Created by Stratos on 2/5/2018.
 */

public class CategoryDAOMemory {
    public static ArrayList<Category> categories = new ArrayList<Category>();


    /**
     * Save a category into the list
     * @param category The category we want to add
     */
    public void add(Category category){
        categories.add(category);
    }

    /**
     * Returns all the categories
     * @return the categories list
     */
    public ArrayList<Category> getCategories() {
        ArrayList<Category> result = new ArrayList<Category>();
        result.addAll(categories);
        return result;
    }
}
