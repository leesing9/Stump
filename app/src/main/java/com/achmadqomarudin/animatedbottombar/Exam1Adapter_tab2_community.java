package com.achmadqomarudin.animatedbottombar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Exam1Adapter_tab2_community extends RecyclerView.Adapter<Exam1Adapter_tab2_community.CustomViewHolder> {

    private ArrayList<KakaoUser> mList = null;
    private Activity context = null;


    public Exam1Adapter_tab2_community(Activity context, ArrayList<KakaoUser> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView kakaoname;
        protected TextView context;



        public CustomViewHolder(View view) {
            super(view);
            this.kakaoname = (TextView) view.findViewById(R.id.textview_community_kakaoname);
            this.context = (TextView) view.findViewById(R.id.textview_community_context);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_exam1_community, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.kakaoname.setText(mList.get(position).getMember_kakaoname());
        viewholder.context.setText(mList.get(position).getMember_context());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}

