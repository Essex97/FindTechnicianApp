package gr.aueb.softeng.project1804.domain;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.domain.Resource;

/**
 * Created by Stratos on 25/4/2018.
 */

public class ResourceTest {

    private Resource r2;

    @Before
    public void setUp() throws Exception {
        r2 = new Resource();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Set and get the name of the object.
     * @result The name we get must be equals with the name we set
     */
    @Test
    public void get_setNameTest(){
        r2.setName("katsabidi");
        Assert.assertTrue(r2.getName().equals("katsabidi"));
    }

    /**
     * Set and get the price of the object.
     * @result The price we get must be equals with the price we set
     */
    @Test
    public void get_setPriceTest(){
        r2.setPrice(34);
        Assert.assertTrue(r2.getPrice() == 34);
    }

    /**
     * Set and get the quantity of the object.
     * @result The quantity we get must be equals with the quantity we set
     */
    @Test
    public void get_setQuantityTest(){
        r2.setQuantity(3);
        Assert.assertTrue(r2.getQuantity() == 3);
    }
}
