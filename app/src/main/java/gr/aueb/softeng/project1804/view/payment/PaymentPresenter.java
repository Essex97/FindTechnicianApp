package gr.aueb.softeng.project1804.view.payment;

/**
 * Created by Stratos on 12/5/2018.
 */

public class PaymentPresenter {

    PaymentView view;

    public PaymentPresenter(PaymentView view) {
        this.view = view;
    }

    public void onClickPay(){
        view.startPayOption();
    }

    public void onClickEvaluate(){
        view.startEvaluateOption();
    }

    public void onChooseTechnician(){
        view.startChooseTechnician();
    }
}
