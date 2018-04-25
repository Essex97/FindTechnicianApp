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
        List<Category> categories = new ArrayList<Category>();
        categories.add(c1);
        categories.add(c2);
        Service s1 = new Service("tghh", categories, null);
        Service s2 = new Service("jyy", categories, null);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getApprovedRequestsTest(){
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        cst.createRequests(new Date(2015, 5, 10), new Time(15, 56, 4), tech, ofserv);

        tech.approve(cst.getRequests().get(0));

        List<Request> approved = new ArrayList<Request>();
        approved.add(cst.getRequests().get(0));

        Assert.assertEquals(approved, cst.getApprovedRequests());
    }

    @Test
    public void getPendingRequestsTest(){
        List<Request> requests = new ArrayList<Request>();
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        cst.createRequests(new Date(2015, 5, 10), new Time(15, 56, 4), tech, ofserv);

        tech.approve(cst.getRequests().get(0));

        List<Request> pending = new ArrayList<Request>();
        pending.add(cst.getRequests().get(1));

        Assert.assertEquals(pending, cst.getPendingRequests());
    }

    @Test
    public void createRequestTest()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        Assert.assertEquals(1, cst.getRequests().size());
    }

    @Test
    public void payCompletedTest()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        tech.approve(cst.getRequests().get(0));
        double amount = 100000;
        cst.pay(cst.getRequests().get(0), amount);

        Assert.assertNotNull(cst.getRequests().get(0).getVisit().getPayment());
    }

    @Test
    public void payNotCompletedTest()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        tech.approve(cst.getRequests().get(0));
        double amount = 200;
        cst.pay(cst.getRequests().get(0), amount);

        Assert.assertNull(cst.getRequests().get(0).getVisit().getPayment());
    }

    @Test
    public void evaluateTest()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        tech.approve(cst.getRequests().get(0));

        cst.evaluate(tech, cst.getRequests().get(0).getVisit());

        Assert.assertEquals(1, cst.getEvaluations().size());
    }

    @Test
    public void testEquals()
    {
        Customer cst2 = new Customer("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        Assert.assertTrue(cst2.equals(cst));
    }

    @Test
    public void evaluateTechnicianComment()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        String comment = "A very good technician.";
        eval.setComment(comment);
        Assert.assertEquals(eval.getComment(), comment);
    }

    @Test
    public void evaluateTechnicianBehavior()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Scale scale = Scale.GOOD;
        eval.setTechnicianBehaviour(scale);
        Assert.assertEquals(eval.getTechnicianBehavior(), scale);
    }

    @Test
    public void evaluateTechnicianWorkQuality()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Scale scale = Scale.BAD;
        eval.setWorkQuality(scale);
        Assert.assertEquals(eval.getWorkQuality(), scale);
    }

    @Test
    public void evaluateTechnicianPriceEvaluation()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Scale scale = Scale.VERY_GOOD;
        eval.setPriceEvaluation(scale);
        Assert.assertEquals(eval.getPriceEvaluation(), scale);
    }

    @Test
    public void evaluateTechnicianEvaluationsSize()
    {
        cst.createRequests(new Date(2017, 3, 13), new Time(21, 24, 45), tech, ofserv);
        Request request = cst.getRequests().get(0);
        Visit visit = new Visit(request);
        Evaluation eval = cst.evaluate(tech, visit);
        Assert.assertEquals(1, cst.getEvaluations().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void evaluateTechnicianInvalidVisit()
    {
        Evaluation eval = cst.evaluate(tech, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void evaluateTechnicianInvalidTechnician()
    {
        Evaluation eval = cst.evaluate(null, null);
    }
}
