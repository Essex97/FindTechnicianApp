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

    @Test
    public void getEvaluationIdTest()
    {
        Assert.assertTrue(b.getPaymentCode().equals(b.getCounter() +"") );
    }

    @Test
    public void equalsTest()
    {

        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void NotEqualsTest()
    {
        Payment c = new Payment(45.0);
        Payment d = new Payment(46.0);
        Assert.assertFalse(c.equals(d));
    }

    @Test
    public void getTotalCostTest()
    {
        a.setTotalCost(46.0);
        Assert.assertTrue(46.0 == a.getTotalCost());
    }

    @Test
    public void notEqualHashCodeTest()
    {
        Assert.assertFalse(a.hashCode() == b.hashCode());
    }



}
