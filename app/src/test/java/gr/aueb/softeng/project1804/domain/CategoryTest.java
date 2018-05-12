package gr.aueb.softeng.project1804.domain;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.domain.Category;

/**
 * Created by Stratos on 25/4/2018.
 */

public class CategoryTest {

    private Category c1;

    @Before
    public void setUp() throws Exception {
        c1 = new Category();
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
        Assert.assertTrue(c1.getCode().equals(c1.getCounter()+""));
    }

    /**
     * Set and get the title of the object.
     * @result The title we get must be equals with the title we set
     */
    @Test
    public void get_setTitleTest(){
        c1.setTitle("hlektrologika");
        Assert.assertTrue(c1.getTitle().equals("hlektrologika"));
    }

    /**
     * Set and get the description of the object.
     * @result The description we get must be equals with the title we set
     */
    @Test
    public void get_setDescriptionTest(){
        c1.setDescription("sintirisi hlektrologikwn");
        Assert.assertTrue(c1.getDescription().equals("sintirisi hlektrologikwn"));
    }



}
