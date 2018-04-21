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
        Category c1 = new Category("grg", "graa", "grae");
        Category c2 = new Category("gkjlb,jkg", "giuolha", "kjglrae");
        categories = new ArrayList<Category>();
        categories.add(c1);
        categories.add(c2);
        Service s1 = new Service("fdhtg", "tghh", categories, null);
        Service s2 = new Service("124", "jyy", categories, null);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
        rq = new Request(new Date(2017, 3, 13), new Time(21, 24, 45), cst, (ArrayList<OfferedService>) ofserv);
        visit = new Visit(rq);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void succesfulPaymentTest(){
        visit.createPayment(50);
        Assert.assertNull(visit.getPayment());
    }

    @Test
    public void unnSuccesfulPaymentTest(){
        visit.createPayment(1000);
        Assert.assertNotNull(visit.getPayment());
    }
}
