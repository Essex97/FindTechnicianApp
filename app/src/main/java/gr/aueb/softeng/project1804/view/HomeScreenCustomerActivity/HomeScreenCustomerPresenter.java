package gr.aueb.softeng.project1804.view.HomeScreenCustomerActivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;

import gr.aueb.softeng.project1804.R;
import gr.aueb.softeng.project1804.domain.Technician;
import gr.aueb.softeng.project1804.memorydao.TechnicianDAOMemory;
import gr.aueb.softeng.project1804.view.TechnicianInfo;

/**
 * Created by Stratos on 6/5/2018.
 */

public class HomeScreenCustomerPresenter extends RecyclerView.Adapter<HomeScreenCustomerPresenter.TechnicianHolder>{

    private HomeScreenCustomerActivity homeActivity;
    private List<Technician> technicianList;

    public HomeScreenCustomerPresenter(HomeScreenCustomerActivity hsc, TechnicianDAOMemory tdm){
        homeActivity = hsc;
        technicianList = tdm.getTechnicians();
    }

    @Override
    public TechnicianHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TechnicianHolder(LayoutInflater.from(homeActivity.getBaseContext()).inflate(R.layout.item_technician, parent, false));
    }


    @Override
    public void onBindViewHolder(TechnicianHolder holder, int position) {
        holder.apply(technicianList.get(position));
    }

    @Override
    public int getItemCount() {
        return technicianList.size();
    }

    class TechnicianHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView techName;
        private ImageView image;

        TechnicianHolder(View itemView){
            super(itemView);
            techName = itemView.findViewById(R.id.tech_name);
            image = itemView.findViewById(R.id.infoPhoto);
            itemView.setOnClickListener(this);
        }

        void apply(Technician technician) {
            techName.setText(technician.getFirstName() +" " + technician.getLastName());
            TextDrawable drawable = TextDrawable.builder().buildRound(techName.getText().toString().substring(0,2), Color.RED);
            image.setImageDrawable(drawable);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(homeActivity, TechnicianInfo.class);
            i.putExtra("POSITION", getAdapterPosition());
            homeActivity.startActivity(i);
        }
    }
}
