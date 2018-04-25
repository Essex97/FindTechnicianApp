package gr.aueb.softeng.project1804;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void get_setNameTest(){
        r2.setName("katsabidi");
        Assert.assertTrue(r2.getName().equals("katsabidi"));
    }

    @Test
    public void get_setPriceTest(){
        r2.setPrice(34);
        Assert.assertTrue(r2.getPrice() == 34);
    }

    @Test
    public void get_setQuantityTest(){
        r2.setQuantity(3);
        Assert.assertTrue(r2.getQuantity() == 3);
    }
}
