package gr.aueb.softeng.project1804.view.signup;

/**
 * Created by Stratos on 7/5/2018.
 */

public interface SignUpView {

    /**
     This method saves a customer as signed up
     */
    public void startSignUpOption();

    /**
     This method saves a technician as signed up and continues the procedure as more details are needed for the technicians
     */
    public void startNextOption();

    public String getName();

    public String getPassword();

    public String getEmail();

    public String getPhone();

    public String getStreetName();

    public int getStreetNumber();

    public String getPostalCode();




}
