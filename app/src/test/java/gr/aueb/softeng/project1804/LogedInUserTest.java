package gr.aueb.softeng.project1804;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.LogedInUser;

/**
 * Created by marios on 5/20/18.
 */

public class LogedInUserTest
{
    private LogedInUser logedInUser;

    @Before
    public void setUp() throws Exception
    {
        LogedInUser.reset();
    }

    /**
     * This method tests the creation of a new instance.
     */
    @Test
    public void getInstanceFirstTest()
    {
        logedInUser = LogedInUser.getInstance();

        Assert.assertNotNull(logedInUser);
    }

    /**
     * This method checks the case in which we already have instanciated
     * the singleton and we call the getInstance again. A new instance should
     * not be created and instaid the same should be returned.
     */
    @Test
    public void getInstanceSecondTest()
    {
        LogedInUser temp = LogedInUser.getInstance();
        logedInUser = LogedInUser.getInstance();

        Assert.assertEquals(logedInUser, temp);
    }

    /**
     * This method tests the setter and getter of the logged in user.
     */
    @Test
    public void getSetUserTest()
    {
        Technician tech = new Technician();
        logedInUser = LogedInUser.getInstance();
        logedInUser.setUser(tech);

        Assert.assertEquals((Technician) logedInUser.getUser(), tech);
    }
}
