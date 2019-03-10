package gr.aueb.softeng.project1804.domain;

/**
 * Created by dimitrisstaratzis on 4/25/18.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.domain.Payment;


public class PaymentTest
{
    private Payment a,b;

    @Before
    public void setUp() throws Exception {
        a = new Payment(45.0);
        b = new Payment(45.0);
    }

    @After
    public void tearDown() throws Exception
    {

    }

    /**
     * This method checks the getter for the id.
     */
    @Test
    public void getEvaluationIdTest()
    {
        Assert.assertTrue(b.getPaymentCode().equals(b.getCounter() +"") );
    }

    /**
     * This method checks the equals method.
     */
    @Test
    public void equalsTest()
    {

        Assert.assertTrue(a.equals(b));
    }

    /**
     * This method checks the equals method.
     */
    @Test
    public void NotEqualsTest()
    {
        Payment c = new Payment(45.0);
        Payment d = new Payment(46.0);
        Assert.assertFalse(c.equals(d));
    }

    /**
     * This method checks the getter and setter for the Total Cost.
     */
    @Test
    public void getTotalCostTest()
    {
        a.setTotalCost(46.0);
        Assert.assertTrue(46.0 == a.getTotalCost());
    }

    /**
     * This method checks the hasCode method for the date.
     */
    @Test
    public void notEqualHashCodeTest()
    {
        Assert.assertFalse(a.hashCode() == b.hashCode());
    }



}
