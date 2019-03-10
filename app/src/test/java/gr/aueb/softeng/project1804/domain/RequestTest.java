package gr.aueb.softeng.project1804.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gr.aueb.softeng.project1804.domain.Category;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;

/**
 * Created by dimitrisstaratzis on 4/21/18.
 */

public class RequestTest
{
    private Technician tech;
    private List<OfferedService> ofserv;
    private Request re1;
    private Request re2;
    private Customer cst;
    @Before
    public void setUp() throws Exception {
        Category c1 = new Category("graa", "grae");
        Category c2 = new Category("giuolha", "kjglrae");
        tech = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        cst = new Customer("Dimitris", "Staratzis", "xxxxx", "xxxxx");
        Service s1 = new Service("tghh", c1);
        Service s2 = new Service("jyy", c2);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
        re1 = new Request("2017, 3, 13", "21, 24, 45", tech, cst, ofserv);
        re2 = new Request("2018, 7, 9", "21, 24, 45", tech, cst, ofserv);


    }

    @After
    public void tearDown() throws Exception
    {

    }

    /**
     * This method tests the getter for the request's code.
     */
    @Test
    public void getRequestCodeTest(){
        Assert.assertTrue(re2.getRequestCode().equals(re2.getCounter() + ""));
    }

    /**
     * This method tests if a request gets approved correctly.
     */
    @Test
    public void setApprovedTest()
    {
        re1.setApproved(true);
        re2.setApproved(false);
        Assert.assertTrue(re1.isApproved());
        Assert.assertFalse(re2.isApproved());
    }

    /**
     * This method tests if the method isApproved test returns the correct results.
     */
    @Test
    public void isApprovedTest()
    {
        re2.setApproved(true);
        Assert.assertTrue(re2.isApproved());
    }

    /**
     * This method tests if the equals method
     */
    @Test
    public void equalsTest()
    {
        Request re5 = new  Request("2017, 3, 13", "21, 24, 45", tech, cst, ofserv);
        Request re4 = new  Request("2017, 3, 13", "21, 24, 45", tech, cst, ofserv);
        Assert.assertTrue(re5.equals(re4));
    }
    @Test

    /**
     * This method tests if the equals method
     */
    public void NotEqualsTest()
    {
        Request re5 = new  Request("2018, 3, 13", "21, 24, 45", tech, cst, ofserv);
        Request re4 = new  Request("2017, 3, 13", "21, 24, 45", tech, cst, ofserv);
        Assert.assertFalse(re5.equals(re4));
    }

    /**
     * This method tests if the hashCode method
     */
    @Test
    public void hashCodeTest()
    {
        Request re5 = new  Request("2017, 3, 13", "21, 24, 45", tech, cst, ofserv);
        Request re4 = new  Request("2017, 3, 13", "21, 24, 45", tech, cst, ofserv);
        Assert.assertTrue(re5.hashCode() == re4.hashCode());
    }

    /**
     * This method tests the time's getter and setter.
     */
    @Test
    public void getTimeTest()
    {
        String time = "21, 24, 45";
        re1.setTime(time);
        Assert.assertEquals(time, re1.getTime());
    }

}
