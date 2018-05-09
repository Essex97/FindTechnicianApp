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
import gr.aueb.softeng.project1804.view.info.TechnicianInfoActivity;

/**
 * Created by Stratos on 6/5/2018.
 */

public class HomeScreenCustomerPresenter {

    private HomeScreenCustomerActivity homeActivity;
    private ListAdapter listAdapter;

    public HomeScreenCustomerPresenter(HomeScreenCustomerActivity hsc, ListAdapter listAdapter){
        homeActivity = hsc;
        this.listAdapter = listAdapter;
    }





}
