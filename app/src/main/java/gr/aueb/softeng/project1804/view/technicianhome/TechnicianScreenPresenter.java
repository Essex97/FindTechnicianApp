package gr.aueb.softeng.project1804.view.technicianhome;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.LogedInUser;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.domain.User;
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
        LogedInUser login = LogedInUser.getInstance();
        User user = login.getUser();
        Technician tech = null;
        if (user instanceof Technician)
        {
            tech = (Technician) user;
        }
        adapter.setList(tech.getPendingRequests());
        //adapter.setList(TechnicianDAOMemory.getLogedInTechnician().getPendingRequests());
        adapter.notifyDataSetChanged();
        //adapter.notifyItemRangeChanged(0, TechnicianDAOMemory.getLogedInTechnician().getPendingRequests().size());

        adapter.notifyItemRangeChanged(0, tech.getPendingRequests().size());
        view.startRequestsOption();
    }

    public void onClickVisits(){
        LogedInUser login = LogedInUser.getInstance();
        User user = login.getUser();
        Technician tech = null;
        if (user instanceof Technician)
        {
            tech = (Technician) user;
        }
        //adapter.setList(TechnicianDAOMemory.getLogedInTechnician().getApprovedRequests());
        adapter.setList(tech.getApprovedRequests());
        adapter.notifyDataSetChanged();
        //adapter.notifyItemRangeChanged(0, TechnicianDAOMemory.getLogedInTechnician().getApprovedRequests().size());
        adapter.notifyItemRangeChanged(0, tech.getApprovedRequests().size());
        view.startVisitsOption();
    }

}
