package com.example.admin.rxandroiddemo;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin on 4/16/2017.
 */

public class CustomCursorRecyclerViewAdapter extends CursorRecyclerViewAdapter{

    public CustomCursorRecyclerViewAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        CustomViewHolder holder = (CustomViewHolder) viewHolder;
        cursor.moveToPosition(cursor.getPosition());
        holder.setData(cursor);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1;
        public CustomViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public void setData(Cursor c) {
            textView1.setText(c.getString(c.getColumnIndex("text")));
        }
    }
}
