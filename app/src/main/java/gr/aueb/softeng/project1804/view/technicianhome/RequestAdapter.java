package gr.aueb.softeng.project1804.view.technicianhome;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Customer;
import gr.aueb.softeng.project1804.domain.Resource;
import gr.aueb.softeng.project1804.memorydao.LogedInUser;
import gr.aueb.softeng.project1804.domain.Request;
import gr.aueb.softeng.project1804.domain.User;

/**
 * Created by Stratos on 9/5/2018.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestHolder> {

    private List<Request> requestList;
    private TechnicianHomeActivity homeActivity;

    public RequestAdapter(TechnicianHomeActivity homeActivity){
        this.homeActivity = homeActivity;
    }

    @Override
    public RequestAdapter.RequestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RequestAdapter.RequestHolder(LayoutInflater.from(homeActivity.getBaseContext()).inflate(R.layout.item_request, parent, false));
    }

    @Override
    public void onBindViewHolder(RequestAdapter.RequestHolder holder, int position) {
        holder.apply(requestList.get(position));
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public void setList(List<Request> list){
        requestList = list;
    }

    public class RequestHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView customerName;
        private TextView requestDay;
        private TextView requestHour;
        private ImageView image;

        RequestHolder(View itemView){
            super(itemView);
            customerName = itemView.findViewById(R.id.cust_name);
            requestDay = itemView.findViewById(R.id.day_request);
            requestHour = itemView.findViewById(R.id.hour_request);
            image = itemView.findViewById(R.id.requestPhoto);
            itemView.setOnClickListener(this);
        }

        void apply(Request request) {
            customerName.setText(request.getCustomer().getFirstName());
            requestDay.setText(request.getDate());
            requestHour.setText(request.getTime());
            TextDrawable drawable = TextDrawable.builder().buildRound(request.getRequestCode(), Color.RED);
            image.setImageDrawable(drawable);
        }



        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(), "Approved" , Toast.LENGTH_SHORT).show();
            Request selectedRequest = requestList.get(getAdapterPosition());
            selectedRequest.setApproved(true);

            if(selectedRequest.isApproved()){
                ArrayList<Resource> resources = homeActivity.addResources();
                selectedRequest.getVisit().setResources(resources);
            }


            LogedInUser login = LogedInUser.getInstance();
            User user = login.getUser();
            if (user instanceof Customer)
            {
                ((Customer)user).addRequest(selectedRequest);
            }

            requestList = selectedRequest.getTechnician().getPendingRequests();
            notifyItemRemoved(getAdapterPosition());
            notifyItemRangeChanged(getAdapterPosition(), requestList.size());
            homeActivity.startRequestsOption();
        }
    }
}
