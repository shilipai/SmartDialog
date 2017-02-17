package com.ufreedom.smartdialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author UFreedom
 * Date : 2017 二月 17
 */

public class ListDialog extends BaseDialog {

    private TextView mTitleView;
    private RecyclerView mRecyclerView;
    private View mCancelActionView;

    @Override
    protected void onInitView(View dialog) {
        mTitleView = (TextView) findViewById(R.id.dialogTitle);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mCancelActionView = findViewById(R.id.cancelAction);
    }

    @Override
    protected int getDialogContentLayoutResId() {
        return R.layout.smart_dialog_simple_list;
    }
    
    
    public static class Builder{
        
        private String title;
        private String cancelActionText;
        
    }
    
    class SimpleItem implements BaseModel{
        
    }
    
    
    class SimpleListAdapter extends BaseRecyclerViewAdapter {

        private List<ModelWrapper> modelWrappers;
        
        public SimpleListAdapter(Context context) {
            super(context);
            modelWrappers = new ArrayList<>();
        }

        @Override
        public BaseViewHolder onCreateBaseViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public List<ModelWrapper> getModelWrappers() {
            return modelWrappers;
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {

        }

        
        

    }
    
    class SimpleViewHolder extends BaseViewHolder<SimpleItem>{

        public SimpleViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBindModel(SimpleItem model, int position) {
            
        }
    }


}
