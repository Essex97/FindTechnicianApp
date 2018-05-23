package gr.aueb.softeng.project1804.view.payment;

/**
 * Created by Stratos on 12/5/2018.
 */

public interface PaymentView {

    /**
     * This method is responsible for starting the payment
     */
    public void startPayOption();

    /**
     * this method is responsible for evaluating a technician
     */
    public void startEvaluateOption();

    /**
     * this mehtod is responsible enabling for initializing the activity and which buttons and fields
     * are accesible
     */
    public void startChooseTechnician();
}
