package com.example.nowinning;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class BatterAdapter extends RecyclerView.Adapter<BatterAdapter.CustomViewHolder> {

    private ArrayList<BatterData> mList = null;
    private Activity context = null;


    public BatterAdapter(Activity context, ArrayList<BatterData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //protected TextView TEAM_NUM;

        protected TextView batter_name;
        protected TextView team_name;
        protected TextView Hit;
        protected TextView AVG;
        protected TextView ONE;
        protected TextView TWO;
        protected TextView THREE;
        protected TextView Score;
        protected TextView RBI;
        protected TextView OBP;
        protected TextView SLG;
        protected TextView OPS;
        protected TextView SB;
        protected TextView SH;
        protected TextView SF;



        public CustomViewHolder(View view) {
            super(view);

            this.batter_name = (TextView) view.findViewById(R.id.textView_list_batter);
            this.team_name = (TextView) view.findViewById(R.id.textView_list_team);
            this.Hit = (TextView) view.findViewById(R.id.textView_list_hit);
            this.AVG = (TextView) view.findViewById(R.id.textView_list_avg);
            this.ONE = (TextView) view.findViewById(R.id.textView_list_one);
            this.TWO = (TextView) view.findViewById(R.id.textView_list_two);
            this.THREE = (TextView) view.findViewById(R.id.textView_list_three);
            this.Score = (TextView) view.findViewById(R.id.textView_list_score);
            this.RBI = (TextView) view.findViewById(R.id.textView_list_rbi);
            this.OBP = (TextView) view.findViewById(R.id.textView_list_obp);
            this.SLG = (TextView) view.findViewById(R.id.textView_list_slg);
            this.OPS = (TextView) view.findViewById(R.id.textView_list_ops);
            this.SB = (TextView) view.findViewById(R.id.textView_list_sb);
            this.SH = (TextView) view.findViewById(R.id.textView_list_sh);
            this.SF = (TextView) view.findViewById(R.id.textView_list_sf);

        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_batter_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.batter_name.setText(mList.get(position).getMember_batter_name());
        viewholder.team_name.setText(mList.get(position).getMember_team_name());
        viewholder.Hit.setText(mList.get(position).getMember_Hit());
        viewholder.AVG.setText(mList.get(position).getMember_AVG());
        viewholder.ONE.setText(mList.get(position).getMember_ONE());
        viewholder.TWO.setText(mList.get(position).getMember_TWO());
        viewholder.THREE.setText(mList.get(position).getMember_THREE());
        viewholder.Score.setText(mList.get(position).getMember_Score());
        viewholder.RBI.setText(mList.get(position).getMember_RBI());
        viewholder.OBP.setText(mList.get(position).getMember_OBP());
        viewholder.SLG.setText(mList.get(position).getMember_SLG());
        viewholder.OPS.setText(mList.get(position).getMember_OPS());
        viewholder.SB.setText(mList.get(position).getMember_SB());
        viewholder.SH.setText(mList.get(position).getMember_SH());
        viewholder.SF.setText(mList.get(position).getMember_SF());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}