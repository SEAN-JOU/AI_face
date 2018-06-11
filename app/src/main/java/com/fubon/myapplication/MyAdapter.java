package com.fubon.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fubon.myapplication.databinding.RecycleItemBinding;
import java.util.List;

/**
 * Created by jou on 2018/4/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<DataDetail> datapushs;
    Context context;


    public MyAdapter(Context context){
        this.context=context;
    }
    public MyAdapter(List<DataDetail> datapushs, Context context){

        this.datapushs=datapushs;
        this.context=context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        RecycleItemBinding recycleItemBinding =RecycleItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return  new ViewHolder(recycleItemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
       // final DataDetail datapush =datapushs.get(i);
        //Picasso.with(context).load(datapush.getPhoto()).into(viewHolder.imageView);
        viewHolder.mBinding.setDataDetail(datapushs.get(i));

    }

    @Override
    public int getItemCount() {

        return datapushs.size();
    }

   static class ViewHolder extends RecyclerView.ViewHolder {

       RecycleItemBinding mBinding;


       public ViewHolder(RecycleItemBinding binding) {
           super(binding.getRoot());
           mBinding = binding;
       }}}