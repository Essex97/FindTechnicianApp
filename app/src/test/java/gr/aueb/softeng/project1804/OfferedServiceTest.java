package gr.aueb.softeng.project1804;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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


    @Test
    public void get_setTechnicianTest() {
        Technician tech = new Technician("Pepe", "TheFrog", "666", "pepetheforg@gmail.com");
        ofsv.setTechnician(tech);
        Assert.assertTrue(ofsv.getTechnician().equals(tech));
    }

    @Test
    public void get_setServiceTest() {
        Service s1 = new Service();
        ofsv.setService(s1);
        Assert.assertTrue(ofsv.getService().equals(s1));
    }

    @Test
    public void get_setCost(){
        ofsv.setCost(20.3);
        Assert.assertTrue(ofsv.getCost() == 20.3);
    }

}
