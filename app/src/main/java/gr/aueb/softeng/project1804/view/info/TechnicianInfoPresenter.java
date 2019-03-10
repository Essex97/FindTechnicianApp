package gr.aueb.softeng.project1804.view.info;

/**
 * Created by Stratos on 9/5/2018.
 */

public class TechnicianInfoPresenter {

    private TechnicianInfoView view;

    public TechnicianInfoPresenter(TechnicianInfoView view) {
        this.view = view;
    }

    /**
     * This method is responsible for starting the payment procedure by calling the method inside the activity
     */
    public void onClickRequest(){
        view.startRequestOption();
    }

}
