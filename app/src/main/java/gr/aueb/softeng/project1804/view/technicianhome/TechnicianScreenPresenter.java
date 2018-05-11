package gr.aueb.softeng.project1804.view.technicianhome;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;

/**
 * Created by Stratos on 9/5/2018.
 */

public class TechnicianScreenPresenter {

    RequestAdapter adapter;
    private TechnicianHomeView view;

    public TechnicianScreenPresenter(TechnicianHomeView view, RequestAdapter adapter) {
        this.view = view;
        this.adapter = adapter;
    }

    public void onClickRequests(){
        adapter.setList(TechnicianDAOMemory.getLogedInTechnician().getPendingRequests());
        adapter.notifyDataSetChanged();
        view.startRequestsOption();
    }

    public void onClickVisits(){
        adapter.setList(TechnicianDAOMemory.getLogedInTechnician().getApprovedRequests());
        adapter.notifyDataSetChanged();
        view.startVisitsOption();
    }

}
