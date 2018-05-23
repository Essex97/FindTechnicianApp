package gr.aueb.softeng.project1804.view.signupcategories;

/**
 * Created by Stratos on 8/5/2018.
 */

public class SignUpCategoriesPresenter {

    private SignUpCategoriesView view;

    public SignUpCategoriesPresenter(SignUpCategoriesView view) {
        this.view = view;
    }

    /**
     * this method is responsible for letting a technician choose in which category he belongs by calling the activity
     */
    public void onClickChooseCategory(){
        view.startChooseCategoryOption();
    }

    /**
     * this method is responsible for letting a technician choose which hours he is available by calling the activity
     */
    public void onClickChooseCities(){
        view.startChooseCitiesOption();
    }

    /**
     * this method is responsible for letting a technician choose which hours he is available by calling the activity
     */
    public void onClickChooseHours(){
        view.startChooseHoursOption();
    }

    /**
     * this method is responsible for letting a technician choose which days he is available by calling the activity
     */
    public void onClickChooseDays(){
        view.startChooseDaysOption();
    }

    /**
     * this method is continues the signup procedure by calling the activity
     */
    public void onClickContinue(){
        view.startContinueOption();
    }
}
