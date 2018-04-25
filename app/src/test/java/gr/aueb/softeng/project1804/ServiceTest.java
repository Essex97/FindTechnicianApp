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
        s1 = new Service();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCodeTest(){
        Assert.assertTrue(s1.getServiceCode().equals(s1.getCounter()+"") );
    }

    @Test
    public void get_setDescriptionTest(){
        s1.setDescription("sintirisi hlektrologikwn");
        Assert.assertTrue(s1.getDescription().equals("sintirisi hlektrologikwn"));
    }

    @Test
    public void get_setCategoriesTest(){
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category());
        s1.setCategories(categories);
        Assert.assertTrue(s1.getCategories().equals(categories));
    }

    @Test
    public void get_setOfferedServiceTest(){
        Technician tech = new Technician("Pepe", "TheFrog", "666", "pepetheforg@gmail.com");
        OfferedService ofsv = new OfferedService(tech, s1, 25);
        List<OfferedService> ofsvlist = new ArrayList<>();
        ofsvlist.add(ofsv);
        s1.setOfferedServices(ofsvlist);
        Assert.assertTrue(s1.getOfferedServices().equals(ofsvlist));
    }



}
