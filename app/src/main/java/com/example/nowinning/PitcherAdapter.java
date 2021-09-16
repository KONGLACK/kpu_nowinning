package com.example.nowinning;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class PitcherAdapter extends RecyclerView.Adapter<PitcherAdapter.CustomViewHolder> {

    private ArrayList<PitcherData> mList = null;
    private Activity context = null;


    public PitcherAdapter(Activity context, ArrayList<PitcherData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //protected TextView TEAM_NUM;

        protected TextView pitcher_name;
        protected TextView team_name;
        protected TextView play_inning;
        protected TextView HR;
        protected TextView Hits;
        protected TextView ER;
        protected TextView SO;
        protected TextView BB;



        public CustomViewHolder(View view) {
            super(view);

            this.pitcher_name = (TextView) view.findViewById(R.id.textView_list_pitcher);
            this.team_name = (TextView) view.findViewById(R.id.textView_list_team);
            this.play_inning = (TextView) view.findViewById(R.id.textView_list_inning);
            this.HR = (TextView) view.findViewById(R.id.textView_list_HR);
            this.Hits = (TextView) view.findViewById(R.id.textView_list_Hits);
            this.ER = (TextView) view.findViewById(R.id.textView_list_ER);
            this.SO = (TextView) view.findViewById(R.id.textView_list_SO);
            this.BB = (TextView) view.findViewById(R.id.textView_list_BB);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_pitcher_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.pitcher_name.setText(mList.get(position).getMember_pitcher_name());
        viewholder.team_name.setText(mList.get(position).getMember_team_name());
        viewholder.play_inning.setText(mList.get(position).getMember_play_inning());
        viewholder.HR.setText(mList.get(position).getMember_HR());
        viewholder.Hits.setText(mList.get(position).getMember_Hits());
        viewholder.ER.setText(mList.get(position).getMember_ER());
        viewholder.SO.setText(mList.get(position).getMember_SO());
        viewholder.BB.setText(mList.get(position).getMember_BB());


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
