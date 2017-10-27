package com.example.administrator.lab3;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import static android.location.Location.convert;


public abstract class CommonAdapter<M> extends RecyclerView.Adapter {
    private Context mcontext;
    private List mlist ;
    private int mlayoutid;
    private CommonAdapter.OnItemClickListener mOnitemClickListener;


    public CommonAdapter(Context context, int layoutid, List list){
        this.mcontext = context;
        this.mlist = list;
        this.mlayoutid = layoutid;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType){
        ViewHolder viewHolder  = ViewHolder.get(mcontext , parent, mlayoutid);
        return viewHolder;
    }

    public  void  onBindViewHolder(final ViewHolder holder, int position){
        convert(holder, (Map<String, Object>) mlist.get(position));
        if(mOnitemClickListener != null){
            holder.itemView.setOnClickListener(new CommonAdapter.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnitemClickListener.onClick(holder.getAdapterPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new CommonAdapter.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnitemClickListener.onLongClick(holder.getAdapterPosition());
                    return false;
                }
            });
        }
    }
    @Override
    public int getItemCount(){
        return mlist.size();
    }

    public abstract void convert(ViewHolder holder, Map<String, Object> L);

    public interface OnItemClickListener  {
        void onClick(int position);
        void onLongClick(int position);
    }
    public void setOnItemClickListener (CommonAdapter.OnItemClickListener onItemClickListener){
        this.mOnitemClickListener =  onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> mView;
        private View mConvertView;

        public ViewHolder(Context context, View itemView, ViewGroup parent){
            super(itemView);
            mConvertView  = itemView;
            mView = new SparseArray<View>();
        }

        public static ViewHolder get(Context context, ViewGroup parent, int layoutid){
            View itemView = LayoutInflater.from(context).inflate(layoutid,parent,false);
            ViewHolder holder = new ViewHolder(context,itemView,parent);
            return holder;
        }

        public <T extends View> T getView(int viewId){
            View view = mView.get(viewId);
            if(view == null){
                view  = mConvertView.findViewById(viewId);
                mView.put(viewId,view);
            }
            return (T) view;
        }
    }

    public class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    public class OnLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
}


