package gr.aueb.softeng.project1804.view.customerhome;

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
import gr.aueb.softeng.project1804.view.info.TechnicianInfoActivity;

/**
 * Created by Stratos on 9/5/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TechnicianHolder>{

    private List<Technician> technicianList;
    private HomeScreenCustomerActivity homeActivity;
    public static Technician selectedTechnician;

    public ListAdapter(HomeScreenCustomerActivity homeActivity){
        this.homeActivity = homeActivity;
        technicianList = TechnicianDAOMemory.technicians;
        System.out.println(technicianList.get(0).getFirstName());
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

    public class TechnicianHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView techName;
        private ImageView image;

        TechnicianHolder(View itemView){
            super(itemView);
            techName = itemView.findViewById(R.id.tech_name);
            image = itemView.findViewById(R.id.tech_infoPhoto);
            itemView.setOnClickListener(this);
        }

        void apply(Technician technician) {
            techName.setText(technician.getFirstName() +" " + technician.getLastName());
            TextDrawable drawable = TextDrawable.builder().buildRound(techName.getText().toString().substring(0,2), Color.RED);
            image.setImageDrawable(drawable);
            selectedTechnician = technician;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(homeActivity, TechnicianInfoActivity.class);
            i.putExtra("POSITION", getAdapterPosition());
            i.putExtra("TYPE", HomeScreenCustomerActivity.type);
            homeActivity.startActivity(i);
        }
    }

}
