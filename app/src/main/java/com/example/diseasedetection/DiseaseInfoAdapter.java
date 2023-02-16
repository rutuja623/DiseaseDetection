package com.example.diseasedetection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiseaseInfoAdapter extends RecyclerView.Adapter<DiseaseInfoAdapter.MyViewHolder> {
    private static Context context;
    private List<String> titles;
    private List<String> maininfo;

    public DiseaseInfoAdapter(Context context, List<String> titles, List<String> maininfo) {
        this.context = context;
        this.titles = titles;
        this.maininfo = maininfo;
    }

    @Override
    public DiseaseInfoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.disease_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DiseaseInfoAdapter.MyViewHolder holder, int position) {
        holder.maininfoview.setText(maininfo.get(position));
        holder.mTextview.setText(titles.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView maininfoview;
        TextView mTextview;

        public MyViewHolder(View itemView) {
            super(itemView);

            maininfoview = itemView.findViewById(R.id.detail_info);
            mTextview = itemView.findViewById(R.id.title_info);

        }
    }
}
