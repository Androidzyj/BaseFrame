package com.example.baseframe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baseframe.R;
import com.example.baseframe.model.HomeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/9/9 0009
 */
public class HomeRecycleViewAdapter extends RecyclerView.Adapter<HomeRecycleViewAdapter.ViewHolder> {
    private Context context;
    private List<HomeBean> homeBeanList;

    public HomeRecycleViewAdapter(Context context, List<HomeBean> homeBeanList) {
        this.context = context;
        this.homeBeanList = homeBeanList;
    }

    @NonNull
    @Override
    public HomeRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rec_home_detail,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecycleViewAdapter.ViewHolder holder, int position) {
        HomeBean bean = homeBeanList.get(position);

        Glide.with(context).load(bean.getImageUrl()).into(holder.imageView);
        holder.title.setText(bean.getTitle());
        holder.content.setText(bean.getContent());
    }

    @Override
    public int getItemCount() {
        return homeBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_home_pic_iv);
            title = itemView.findViewById(R.id.item_home_title_tv);
            content = itemView.findViewById(R.id.item_home_content_tv);
        }
    }
}
