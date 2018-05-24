package gr.aueb.softeng.project1804.view.signup;

/**
 * Created by Stratos on 7/5/2018.
 */

public interface SignUpView {

    /**
     This method saves a customer as signed up
     */
    void startSignUpOption();

    /**
     This method saves a technician as signed up and continues the procedure as more details are needed for the technicians
     */
    void startNextOption();

    String getName();

    String getPassword();

    String getEmail();

    String getPhone();

    String getStreetName();

    int getStreetNumber();

    String getPostalCode();

}
