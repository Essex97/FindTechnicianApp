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
import gr.aueb.softeng.project1804.domain.Evaluation;
import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.Scale;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.domain.Visit;

/**
 * Created by marios on 4/21/18.
 */

public class CustomerTest
{
    private Customer cst;
    private List<OfferedService> ofserv;
    private Technician tech;

    @Before
    public void setUp() throws Exception {
        cst = new Customer("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        tech = new Technician("Pepe", "TheFrog", "666", "pepetheforg@gmail.com");
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
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        cst.createRequests("2015, 5, 10", "15, 56, 4", tech, ofserv);

        tech.approve(cst.getRequests().get(0));

        List<Request> approved = new ArrayList<Request>();
        approved.add(cst.getRequests().get(0));

        Assert.assertEquals(approved, cst.getApprovedRequests());
    }

    /**
     * This method tests the getter for the pending requests.
     */
    @Test
    public void getPendingRequestsTest(){
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        cst.createRequests("2015, 5, 10", "15, 56, 4", tech, ofserv);

        tech.approve(cst.getRequests().get(0));

        List<Request> pending = new ArrayList<Request>();
        pending.add(cst.getRequests().get(1));

        Assert.assertEquals(pending, cst.getPendingRequests());
    }

    /**
     * This method tests the creation of a request.
     */
    @Test
    public void createRequestTest()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        Assert.assertEquals(1, cst.getRequests().size());
    }

    /**
     * This method tests the successful payment of a request.
     */
    @Test
    public void payCompletedTest()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        tech.approve(cst.getRequests().get(0));
        double amount = 100000;
        cst.pay(cst.getRequests().get(0), amount);

        Assert.assertNotNull(cst.getRequests().get(0).getVisit().getPayment());
    }

    /**
     * This method tests the unsuccessful payment of a request.
     */
    @Test
    public void payNotCompletedTest()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        tech.approve(cst.getRequests().get(0));
        double amount = 200;
        cst.pay(cst.getRequests().get(0), amount);

        Assert.assertNull(cst.getRequests().get(0).getVisit().getPayment());
    }

    /**
     * This method tests the evaluation of a Technician from a Customer.
     */
    @Test
    public void evaluateTest()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        tech.approve(cst.getRequests().get(0));

        cst.evaluate(tech, cst.getRequests().get(0).getVisit());

        Assert.assertEquals(1, cst.getEvaluations().size());
    }

    /**
     * This method tests the equals method of the Customer class.
     */
    @Test
    public void testEquals()
    {
        Customer cst2 = new Customer("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Assert.assertTrue(cst2.equals(cst));
    }

    /**
     * This method tests the comment addition to an evaluation by a Customer.
     */
    @Test
    public void evaluateTechnicianComment()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        String comment = "A very good technician.";
        eval.setComment(comment);
        Assert.assertEquals(eval.getComment(), comment);
    }

    /**
     * This method tests the evaluation of the behavior of a Technician by a Customer.
     */
    @Test
    public void evaluateTechnicianBehavior()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Scale scale = Scale.GOOD;
        eval.setTechnicianBehaviour(scale);
        Assert.assertEquals(eval.getTechnicianBehavior(), scale);
    }

    /**
     * This method tests the evaluation of the work quality of a Technician by a Customer.
     */
    @Test
    public void evaluateTechnicianWorkQuality()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Scale scale = Scale.BAD;
        eval.setWorkQuality(scale);
        Assert.assertEquals(eval.getWorkQuality(), scale);
    }

    /**
     * This method tests the evaluation of the price that a Technician charges the Customer.
     */
    @Test
    public void evaluateTechnicianPriceEvaluation()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Scale scale = Scale.VERY_GOOD;
        eval.setPriceEvaluation(scale);
        Assert.assertEquals(eval.getPriceEvaluation(), scale);
    }

    /**
     * This method tests the correct addition of an evaluation to the list of the Customer
     * that created it.
     */
    @Test
    public void evaluateTechnicianEvaluationsSize()
    {
        cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Assert.assertEquals(1, cst.getEvaluations().size());
    }

    /**
     * This method tests the behavior of the evaluate method, given wrong arguments.
     */
    @Test(expected = IllegalArgumentException.class)
    public void evaluateTechnicianInvalidVisit()
    {
        Evaluation eval = cst.evaluate(tech, null);
    }

    /**
     * This method tests the behavior of the evaluate method, given wrong arguments.
     */
    @Test(expected = IllegalArgumentException.class)
    public void evaluateTechnicianInvalidTechnician()
    {
        Evaluation eval = cst.evaluate(null, null);
    }
}
