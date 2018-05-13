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
import gr.aueb.softeng.project1804.domain.Evaluation;
import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.Scale;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.domain.Visit;

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
		cst.createRequests("2017, 3, 13", "21, 24, 45", tech, ofserv);
		cst.createRequests("2015, 5, 10", "15, 56, 4", tech, ofserv);
		visit = new Visit(re1);
		eval = new Evaluation(tech, visit);
	}

	@After
	public void tearDown() throws Exception
	{

	}

	/**
	 * This method checks the getter and setter for the id.
	 */
	@Test
	public void getEvaluationIdTest()
	{
		Assert.assertTrue(eval.getEvaluationID().equals(eval.getCounter() +"") );
	}

	/**
	 * This method checks the getter and setter for the behaviour.
	 */
	@Test
	public void getTechnicianBehaviourTest()
	{
		Scale s = Scale.GOOD;
		eval.setTechnicianBehaviour(s);
		Assert.assertEquals(s, eval.getTechnicianBehavior());
	}

	/**
	 * This method checks the getter and setter for the work quality.
	 */
	@Test
	public void getWorkQualityTest()
	{
		Scale s = Scale.GOOD;
		eval.setWorkQuality(s);
		Assert.assertEquals(s, eval.getWorkQuality());
	}

	/**
	 * This method checks the getter and setter for the price Evaluation.
	 */
	@Test
	public void getPriceEvaluationTest()
	{
		Scale s = Scale.GOOD;
		eval.setPriceEvaluation(s);
		Assert.assertEquals(s, eval.getPriceEvaluation());
	}

	/**
	 * This method checks the getter and setter for the comment.
	 */
	@Test
	public void getCommentTest()
	{
		eval.setComment("Works!");
		Assert.assertEquals("Works!", eval.getComment());
	}

	/**
	 * This method checks the getter and setter for the visit.
	 */
	@Test
	public void getVisitTest()
	{
		Visit visit2 = new Visit(re1);
		Assert.assertEquals(visit2, eval.getVisit());
	}

	/**
	 * This method checks the equals method.
	 */
	@Test
	public void equalsTest()
	{
		Evaluation eval2 = new Evaluation(tech, visit);
		Assert.assertTrue(eval2.equals(eval));
	}

}
