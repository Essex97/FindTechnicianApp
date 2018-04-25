package gr.aueb.softeng.project1804;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stratos on 25/4/2018.
 */

public class ServiceTest {

    private Service s1;

    @Before
    public void setUp() throws Exception {
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category());
        s1 = new Service("sintirish yliakou", categories, null);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCodeTest(){
        Assert.assertTrue(s1.getServiceCode().equals(s1.getCounter()+""));
    }

    @Test
    public void get_setDescriptionTest(){
        s1.setDescription("sintirisi hlektrologikwn");
        Assert.assertTrue(s1.getDescription().equals("sintirisi hlektrologikwn"));
    }


}
