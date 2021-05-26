package com.achmadqomarudin.animatedbottombar;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.CustomViewHolder> {

    private ArrayList<KakaoUser> mList = null;
    private Activity context = null;


    public QuestAdapter(Activity context, ArrayList<KakaoUser> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
        protected TextView kakaoname;
        protected TextView date;
        protected TextView context;
        protected ImageView image;


        public CustomViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.textView_list_title);
            this.kakaoname = (TextView) view.findViewById(R.id.textView_list_kakaoname);
            this.date = (TextView) view.findViewById(R.id.textView_list_date);
            this.context = (TextView) view.findViewById(R.id.textView_list_context);
            this.image = (ImageView) view.findViewById(R.id.textView_list_image);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.title.setText(mList.get(position).getMember_title());
        viewholder.kakaoname.setText(mList.get(position).getMember_kakaoname());
        viewholder.date.setText(mList.get(position).getMember_date());
        viewholder.context.setText(mList.get(position).getMember_context());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}

