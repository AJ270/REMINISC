package com.example.hp.reminisce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class patientadapt extends RecyclerView.Adapter<patientadapt.ViewHolder> {

    private Context mcontext;

    private ArrayList<ModelPatient> mList;

    patientadapt(Context context, ArrayList<ModelPatient> list){
        mcontext=context;
        mList=list;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        View view=layoutInflater.inflate(R.layout.rv_patient_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelPatient patientitem=mList.get(position);
        ImageView image=holder.patient_image;
        TextView graph1=holder.patient_graph;
        TextView namelabel1=holder.name_label;
        TextView mobilelabel1=holder.mobile_label;

        image.setImageResource(mList.get(position).getImage());

        namelabel1.setText(patientitem.getName());
        mobilelabel1.setText(patientitem.getMobile());
        graph1.setText(patientitem.getGraph());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView patient_image;
        TextView patient_graph,patient_mobile,name_label,mobile_label;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            patient_image=itemView.findViewById(R.id.image_p1);
            patient_graph=itemView.findViewById(R.id.tv1_graph_id);
            name_label=itemView.findViewById(R.id.name_label_id);
            mobile_label=itemView.findViewById(R.id.mobile_label_id);
        }
    }
}
