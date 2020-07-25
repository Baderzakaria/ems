package com.EMS.Adapters;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.EMS.Models.Response;
import com.EMS.R;
import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder> {

    private Context mContext;
    private boolean availability;
    private List<Response> mData;


    public ResponseAdapter(Context mContext, List<Response> mData, boolean availability) {
        this.mContext = mContext;
        this.mData = mData;
        this.availability = availability;
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_comment, parent, false);
        return new ResponseViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {

        Glide.with(mContext).load(mData.get(position).getUimg()).into(holder.img_user);
        holder.tv_name.setText(mData.get(position).getUname());
        holder.tv_content.setText(mData.get(position).getContent());
        holder.tv_date.setText(timestampToString((Long) mData.get(position).getTimestamp()));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private String timestampToString(long time) {

        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("hh:mm", calendar).toString();
        return date;


    }

    public class ResponseViewHolder extends RecyclerView.ViewHolder {

        ImageView img_user;
        TextView tv_name, tv_content, tv_date;
        TextView ava;

        public ResponseViewHolder(View itemView) {
            super(itemView);
            img_user = itemView.findViewById(R.id.comment_user_img);
            tv_name = itemView.findViewById(R.id.comment_username);
            tv_content = itemView.findViewById(R.id.comment_content);
            tv_date = itemView.findViewById(R.id.comment_date);

        }
    }


}
