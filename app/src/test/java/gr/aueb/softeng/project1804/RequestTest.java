package gr.aueb.softeng.project1804;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Category> categories = new ArrayList<Category>();
        categories.add(c1);
        categories.add(c2);
        tech = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        cst = new Customer("Dimitris", "Staratzis", "xxxxx", "xxxxx");
        Service s1 = new Service("tghh", categories, null);
        Service s2 = new Service("jyy", categories, null);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
        re1 = new Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        re2 = new Request(new Date(2018, 7, 9), new Time(21, 24, 45), tech, cst, ofserv);


    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void setApprovedTest()
    {
        re1.setApproved(true);
        re2.setApproved(false);
        Assert.assertTrue(re1.isApproved());
        Assert.assertFalse(re2.isApproved());
    }

    @Test
    public void isApprovedTest()
    {
        re2.setApproved(true);
        Assert.assertTrue(re2.isApproved());
    }
    @Test
    public void equalsTest()
    {
        Request re5 = new  Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        Request re4 = new  Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        Assert.assertTrue(re5.equals(re4));
    }
    @Test
    public void NotEqualsTest()
    {
        Request re5 = new  Request(new Date(2018, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        Request re4 = new  Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        Assert.assertFalse(re5.equals(re4));
    }

    @Test
    public void hashCodeTest()
    {
        Request re5 = new  Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        Request re4 = new  Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        Assert.assertTrue(re5.hashCode() == re4.hashCode());
    }

    @Test
    public void getTimeTest()
    {
        Time time = new Time(21, 24, 45);
        re1.setTime(time);
        Assert.assertEquals(time, re1.getTime());
    }

}
