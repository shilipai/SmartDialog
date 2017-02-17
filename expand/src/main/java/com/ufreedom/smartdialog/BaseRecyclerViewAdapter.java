package com.ufreedom.smartdialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author UFreedom
 * Date : 2017 二月 17
 */

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    protected LayoutInflater mInflater;
    private OnItemClickListener mListener;
    
    public BaseRecyclerViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder vHolder = onCreateBaseViewHolder(parent, viewType);
        if (mListener != null) {
            vHolder.setOnItemClickListener(mListener);
        }
        return vHolder;
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBindModel(getModelWrapper(position).getModel(), position);
    }

    public abstract BaseViewHolder onCreateBaseViewHolder(ViewGroup parent, int viewType);


    public View inflate(int resource, ViewGroup parent) {
        return mInflater.inflate(resource, parent, false);
    }

    @Override
    public int getItemViewType(int position) {
        return getModelWrapper(position).getType();
    }
    
    public ModelWrapper getModelWrapper(int position){
        if (getModelWrappers() == null || getModelWrappers().size() == 0) return null;
        
        return getModelWrappers().get(position);
    }

    @Override
    public int getItemCount() {
        if (getModelWrappers() == null) return 0;

        return getModelWrappers().size();
    }

    public abstract List<ModelWrapper> getModelWrappers();
    
    
    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }


}
