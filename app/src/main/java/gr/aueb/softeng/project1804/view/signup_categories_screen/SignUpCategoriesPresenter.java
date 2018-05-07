package gr.aueb.softeng.project1804.view.signup_categories_screen;

/**
 * Created by Stratos on 8/5/2018.
 */

public class SignUpCategoriesPresenter {

    private SignUpCategoriesView view;

    public SignUpCategoriesPresenter(SignUpCategoriesView view) {
        this.view = view;
    }

    public void onClickChooseCategory(){
        view.startChooseCategoryOption();
    }

    public void onClickChooseCities(){
        view.startChooseCitiesOption();
    }

    public void onClickChooseHours(){
        view.startChooseHoursOption();
    }

    public void onClickChooseDays(){
        view.startChooseDaysOption();
    }

    public void onClickContinue(){
        view.startContinueOption();
    }
}
