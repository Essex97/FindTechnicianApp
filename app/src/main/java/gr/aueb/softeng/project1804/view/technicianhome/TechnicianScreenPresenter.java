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
        adapter.notifyItemRangeChanged(0, TechnicianDAOMemory.getLogedInTechnician().getPendingRequests().size());
        view.startRequestsOption();
    }

    public void onClickVisits(){
        adapter.setList(TechnicianDAOMemory.getLogedInTechnician().getApprovedRequests());
        adapter.notifyDataSetChanged();
        adapter.notifyItemRangeChanged(0, TechnicianDAOMemory.getLogedInTechnician().getApprovedRequests().size());

        view.startVisitsOption();
    }

}
