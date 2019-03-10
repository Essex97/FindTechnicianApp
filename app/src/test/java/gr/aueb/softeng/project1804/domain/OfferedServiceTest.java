package gr.aueb.softeng.project1804.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1804.domain.OfferedService;
import gr.aueb.softeng.project1804.domain.Service;
import gr.aueb.softeng.project1804.domain.Technician;

/**
 * Created by Stratos on 25/4/2018.
 */

public class OfferedServiceTest {

    private OfferedService ofsv;

    @Before
    public void setUp() throws Exception {
        ofsv = new OfferedService();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Set and get the technician of the object.
     * @result The technician we get must be equals with the technician we set
     */
    @Test
    public void get_setTechnicianTest() {
        Technician tech = new Technician("Pepe", "TheFrog", "666", "pepetheforg@gmail.com");
        ofsv.setTechnician(tech);
        Assert.assertTrue(ofsv.getTechnician().equals(tech));
    }

    /**
     * Set and get the service of the object.
     * @result The service we get must be equals with the service we set
     */
    @Test
    public void get_setServiceTest() {
        Service s1 = new Service();
        ofsv.setService(s1);
        Assert.assertTrue(ofsv.getService().equals(s1));
    }

    /**
     * Set and get the cost of the object.
     * @result The cost we get must be equals with the cost we set
     */
    @Test
    public void get_setCost(){
        ofsv.setCost(20.3);
        Assert.assertTrue(ofsv.getCost() == 20.3);
    }

}
