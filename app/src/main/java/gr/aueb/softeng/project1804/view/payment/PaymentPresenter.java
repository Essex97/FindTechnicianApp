package gr.aueb.softeng.project1804.view.payment;

/**
 * Created by Stratos on 12/5/2018.
 */

public class PaymentPresenter {

    PaymentView view;

    public PaymentPresenter(PaymentView view) {
        this.view = view;
    }

    /**
     * This method is responsible for starting the payment by calling the method in the activity
     */
    public void onClickPay(){
        view.startPayOption();
    }

    /**
     * this method is responsible for evaluating a technician by calling the method in the activity
     */
    public void onClickEvaluate(){
        view.startEvaluateOption();
    }

    /**
     * this mehtod is responsible enabling for initializing the activity and which buttons and fields
     * are accesible by calling the method in the activity
     */
    public void onChooseTechnician(){
        view.startChooseTechnician();
    }
}
