package gr.aueb.softeng.project1804;

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
 * Created by Stratos on 21/4/2018.
 */

public class TechnicianTest {

    private Technician tech;
    private List<OfferedService> ofserv;

    @Before
    public void setUp() throws Exception {
        tech = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Category c1 = new Category("graa", "grae");
        Category c2 = new Category("giuolha", "kjglrae");

        Service s1 = new Service("tghh", c1);
        Service s2 = new Service("jyy", c2);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * This method tests the getter for the approved requests.
     */
    @Test
    public void getApprovedRequestsTest(){
        Customer cst = new Customer("fdsf", "gfsd", "gra", "dhsf");
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        cst.createRequests("2015, 5, 10", "15, 56, 4", tech, ofserv);

        tech.approve(tech.getRequests().get(0));


        List<Request> approved = new ArrayList<Request>();
        approved.add(tech.getRequests().get(0));

        Assert.assertEquals(approved, tech.getApprovedRequests());
    }

    /**
     * This method tests the getter for the pending requests.
     */
    @Test
    public void getPendingRequestsTest(){
        Customer cst = new Customer("fdsf", "gfsd", "gra", "dhsf");
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        cst.createRequests("2015, 5, 10", "15, 56, 4", tech, ofserv);

        tech.approve(tech.getRequests().get(0));

        List<Request> pending = new ArrayList<Request>();
        pending.add(tech.getRequests().get(1));

        Assert.assertEquals(pending, tech.getPendingRequests());
    }

    /**
     * This method tests the approval of a request by a Technician.
     */
    @Test
    public void approveTest()
    {
        Customer cst = new Customer("fdsf", "gfsd", "gra", "dhsf");
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        cst.createRequests("2015, 5, 10", "15, 56, 4", tech, ofserv);

        //Assert.assertTrue(!tech.getRequests().get(1).isApproved());
        tech.approve(tech.getRequests().get(1));
        Assert.assertTrue(tech.getRequests().get(1).isApproved());
    }

    /**
     * This method tests the behavior of the approve method, given wrong arguments.
     */
    @Test(expected = IllegalArgumentException.class)
    public void approveWithNullTest()
    {
        tech.approve(null);
    }

    /**
     * This method tests the equals method of the Technician class.
     */
    @Test
    public void equalsTest()
    {
        Technician tech2 = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Assert.assertTrue(tech.equals(tech2));
    }
}
