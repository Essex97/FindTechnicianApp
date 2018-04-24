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

public class EvaluationTest
{
    private Technician tech;
    private List<OfferedService> ofserv;
    private Request re1;
    private Request re2;
    private Customer cst;
	private Evaluation eval;
	private Visit visit;
	private int c=0;
	
    @Before
    public void setUp() throws Exception {
        Category c1 = new Category("grg", "graa", "grae");
        Category c2 = new Category("gkjlb,jkg", "giuolha", "kjglrae");
        List<Category> categories = new ArrayList<Category>();
        categories.add(c1);
        categories.add(c2);
        tech = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
        cst = new Customer("Dimitris", "Staratzis", "xxxxx", "xxxxx");
        Service s1 = new Service("fdhtg", "tghh", categories, null);
        Service s2 = new Service("124", "jyy", categories, null);
        ofserv = new ArrayList<OfferedService>();
        ofserv.add(new OfferedService(tech, s1, 23.4));
        ofserv.add(new OfferedService(tech, s2, 255));
        re1 = new Request(new Date(2017, 3, 13), new Time(21, 24, 45), tech, cst, ofserv);
        re2 = new Request(new Date(2018, 7, 9), new Time(21, 24, 45), tech, cst, ofserv);
		visit = new Visit(re1);
		eval = new Evaluation(tech, visit);
    }

    @After
    public void tearDown() throws Exception
    {
		
    }

    @Test
    public void getEvaluationIdTest()
    {
		Assert.assertTrue(eval.getEvaluationID().equals(eval.counter +"") );
	}
	
	@Test
	public void getTechnicianBehaviourTest()
	{
		Scale s = Scale.GOOD;
		eval.setTechnicianBehaviour(s);
		Assert.assertEquals(s, eval.getTechnicianBehavior());
	}
	
	@Test
	public void getWorkQualityTest()
	{
		Scale s = Scale.GOOD;
		eval.setWorkQuality(s);
		Assert.assertEquals(s, eval.getWorkQuality());
	}
	
	@Test
	public void getPriceEvaluationTest()
	{
		Scale s = Scale.GOOD;
		eval.setPriceEvaluation(s);
		Assert.assertEquals(s, eval.getPriceEvaluation());
	}
	
	@Test
	public void getCommentTest()
	{
		eval.setComment("Works!");
		Assert.assertEquals("Works!", eval.getComment());
	}
	
	@Test
	public void getTechnicianTest()
	{
		Technician tech2 = new Technician("Statos", "Xenouleas", "69xxxx", "stratos@gmail.com");
		Assert.assertEquals(tech2, eval.getTechnician());
	}
	
	@Test
	public void getVisitTest()
	{
		Visit visit2 = new Visit(re1);
		Assert.assertEquals(visit2, eval.getVisit());
	}
	
	@Test
	public void equalsTest()
	{
		Evaluation eval2 = new Evaluation(tech, visit);
		Assert.assertTrue(eval2.equals(eval));
	}

	@Test
	public void hashCodeTest()
	{
		Evaluation eval2 = new Evaluation(tech, visit);
		Assert.assertTrue(eval2.hashCode() == eval.hashCode());
	}
	
	
	

}
