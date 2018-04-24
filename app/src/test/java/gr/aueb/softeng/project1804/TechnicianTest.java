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
 * Created by Stratos on 21/4/2018.
 */

public class TechnicianTest {

    private Technician tech;
    private List<OfferedService> ofserv;

    @Before
    public void setUp() throws Exception {
        tech = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Category c1 = new Category("grg", "graa", "grae");
        Category c2 = new Category("gkjlb,jkg", "giuolha", "kjglrae");
        List<Category> categories = new ArrayList<Category>();
        categories.add(c1);
        categories.add(c2);
        Service s1 = new Service("fdhtg", "tghh", categories, null);
        Service s2 = new Service("124", "jyy", categories, null);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getApprovedRequestsTest(){
        Customer cst = new Customer("fdsf", "gfsd", "gra", "dhsf");
        List<Request> requests = new ArrayList<Request>();
        cst.createRepuests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        cst.createRepuests(new Date(2015, 5, 10), new Time(15, 56, 4), tech, ofserv);

        tech.approve(tech.getRequests().get(0));


        List<Request> approved = new ArrayList<Request>();
        approved.add(tech.getRequests().get(0));

        Assert.assertEquals(approved, tech.getApprovedRequests());
    }

    @Test
    public void getPendingRequestsTest(){
        Customer cst = new Customer("fdsf", "gfsd", "gra", "dhsf");
        List<Request> requests = new ArrayList<Request>();
        cst.createRepuests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        cst.createRepuests(new Date(2015, 5, 10), new Time(15, 56, 4), tech, ofserv);

        tech.approve(tech.getRequests().get(0));

        List<Request> pending = new ArrayList<Request>();
        pending.add(tech.getRequests().get(1));

        Assert.assertEquals(pending, tech.getPendingRequests());
    }

    @Test
    public void approveTest()
    {
        Customer cst = new Customer("fdsf", "gfsd", "gra", "dhsf");
        List<Request> requests = new ArrayList<Request>();
        cst.createRepuests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        cst.createRepuests(new Date(2015, 5, 10), new Time(15, 56, 4), tech, ofserv);

        Assert.assertTrue(!tech.getRequests().get(1).isApproved());
        tech.approve(tech.getRequests().get(1));
        Assert.assertTrue(tech.getRequests().get(1).isApproved());
    }

    @Test(expected = IllegalArgumentException.class)
    public void approveWithNullTest()
    {
        tech.approve(null);
    }

    @Test
    public void equalsTest()
    {
        Technician tech2 = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Assert.assertTrue(tech.equals(tech2));
    }
}