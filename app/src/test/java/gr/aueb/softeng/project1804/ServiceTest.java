package gr.aueb.softeng.project1804;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Service;

/**
 * Created by Stratos on 25/4/2018.
 */

public class ServiceTest {

    private Service s1;

    @Before
    public void setUp() throws Exception {
        s1 = new Service();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Get the code of the object.
     * @result The code must be equals with the counter of the class
     */
    @Test
    public void getCodeTest(){
        Assert.assertTrue(s1.getServiceCode().equals(s1.getCounter()+"") );
    }

    /**
     * Set and get the description of the object.
     * @result The description we get must be equals with the title we set
     */
    @Test
    public void get_setDescriptionTest(){
        s1.setDescription("sintirisi hlektrologikwn");
        Assert.assertTrue(s1.getDescription().equals("sintirisi hlektrologikwn"));
    }

    /**
     * Set and get the categories of the object.
     * @result The categories we get must be equals with the categories we set
     */
    @Test
    public void get_setCategoriesTest(){

        Category c = new Category();
        s1.setCategory(c);
        Assert.assertTrue(s1.getCategory().equals(c));
    }

}
