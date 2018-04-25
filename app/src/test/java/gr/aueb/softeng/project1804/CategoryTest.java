package gr.aueb.softeng.project1804;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void getCodeTest(){
        Assert.assertTrue(c1.getCode().equals(c1.getCounter()+""));
    }

    @Test
    public void get_setTitleTest(){
        c1.setTitle("hlektrologika");
        Assert.assertTrue(c1.getTitle().equals("hlektrologika"));
    }

    @Test
    public void get_setDescriptionTest(){
        c1.setDescription("sintirisi hlektrologikwn");
        Assert.assertTrue(c1.getDescription().equals("sintirisi hlektrologikwn"));
    }


}
