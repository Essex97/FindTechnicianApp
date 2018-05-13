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
import gr.aueb.softeng.project1804.domain.Resource;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.domain.Visit;

/**
 * Created by Stratos on 21/4/2018.
 */

public class VisitTest {

    private Visit visit;

    private Technician tech;
    private Request rq;
    private Customer cst;
    private List<OfferedService> ofserv;
    private List<Category> categories;

    @Before
    public void setUp() throws Exception {
        cst = new Customer("jy", "liu", "gli", "tres");
        tech = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Category c1 = new Category("graa", "grae");
        Category c2 = new Category("giuolha", "kjglrae");

        Service s1 = new Service("tghh", c1);
        Service s2 = new Service("jyy", c2);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
        rq = new Request("2017, 3, 13", "21, 24, 45",tech, cst, ofserv);
        visit = new Visit(rq);
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * This method checks if the ids are set correctly.
     */
    @Test
    public void visitIDTest(){
        Assert.assertTrue(visit.getVisitID().equals(visit.getCounter() + ""));
    }

    /**
     * This method checks if the payment object is created correctly
     */
    @Test
    public void succesfulPaymentTest(){
        visit.createPayment(50);
        Assert.assertNull(visit.getPayment());
    }

    /**
     * This method checks if the payment object is created correctly
     */
    @Test
    public void unnSuccesfulPaymentTest(){
        visit.createPayment(1000);
        Assert.assertNotNull(visit.getPayment());
    }

    /**
     * This method checks the equals method.
     */
    @Test
    public void equalsTest(){
        Visit visit1 = new Visit(rq);
        Assert.assertTrue(visit.equals(visit1));
    }

    /**
     * This method checks the equals method.
     */
    @Test
    public void notEqualsTest(){
        Request rq1 = new Request("2021, 6, 1", "2, 2, 4", cst, (ArrayList<OfferedService>) ofserv);
        Visit visit2 = new Visit(rq1);
        Assert.assertFalse(visit.equals(visit2));
    }

    /**
     * This method checks the getter for the date.
     */
    @Test
    public void getDateTest(){
        Assert.assertTrue(visit.getDate().equals("2017, 3, 13") );
    }

    /**
     * This method checks the setter for the date.
     */
    @Test
    public void setDateTest(){
        visit.setDate("2019, 4, 34");
        Assert.assertTrue(visit.getDate().equals("2019, 4, 34") );
    }

    /**
     * This method checks the getter for the request.
     */
    @Test
    public void getRequestTest(){
        Assert.assertTrue(visit.getRequest().equals(rq) );
    }

    /**
     * This method checks the getter for the payment.
     */
    @Test
    public void getPaymentTest(){
        Assert.assertNull(visit.getPayment());
    }

    /**
     * This method checks the getter for the technician.
     */
    @Test
    public void getTechnicianTest(){
        Assert.assertTrue(visit.getTechnician().equals(tech) );
    }

    /**
     * This method checks the getter for the customer.
     */
    @Test
    public void getCustomerTest(){
        Assert.assertTrue(visit.getCustomer().equals(cst) );
    }

    /**
     * This method checks the getter for the resources.
     */
    @Test
    public void getRecourcesTest(){
        Assert.assertNull(visit.getResources());
    }

    /**
     * This method checks the setter and getter for the resources.
     */
    @Test
    public void setRecourcesTest(){
        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(new Resource("solhnas", 2, 2));
        visit.setResources(resources);
        Assert.assertTrue(visit.getResources().equals(resources));
    }



}
