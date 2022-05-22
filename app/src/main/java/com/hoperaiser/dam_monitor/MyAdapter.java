package com.hoperaiser.dam_monitor;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static List<UserModal> list_data;
    private Context context;
    List<UserModal> newlist;

    public MyAdapter(List<UserModal> list_data, Context context) {
        this.list_data=list_data;
        this.context = context;
        this.newlist=list_data;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModal listData=list_data.get(position);
        holder.txtname.setText(listData.getDate());
        holder.distance.setText(listData.getWaterlevel());
        holder.id.setText(listData.getTime());

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtname,id,distance;
        private CardView maincardview;
        public ViewHolder(View itemView) {
            super(itemView);
//            img=(ImageView)itemView.findViewById(R.id.image_view);
            txtname=(TextView)itemView.findViewById(R.id.idTVFirstName);
            id=(TextView)itemView.findViewById(R.id.idTVLastName);
            distance=(TextView)itemView.findViewById(R.id.idTVEmail);
            maincardview=(CardView)itemView.findViewById(R.id.maincardview);
        }
    }

}