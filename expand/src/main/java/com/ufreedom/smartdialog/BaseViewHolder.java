package com.ufreedom.smartdialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Author SunMeng
 * Date : 2017 二月 17
 */

public abstract class BaseViewHolder<M extends BaseModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public View findViewById(int id) {
        return itemView.findViewById(id);
    }


    public BaseViewHolder setOnItemClickListener(final OnItemClickListener listener) {
        if (listener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemView, BaseViewHolder.this, getLayoutPosition());
                }
            });
        }
        return this;
    }

    public abstract void onBindModel(M model, int position);

}
