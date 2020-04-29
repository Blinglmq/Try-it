package com.example.mywechat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<UserAccount>userAccounts;
    private Context mContext;

    public MyAdapter(Context context,List<UserAccount>userAccounts){
        mContext=context;
        this.userAccounts=userAccounts;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.itemview,null);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        ((TextView)myHolder.finViewById(R.id.tv_username)).setText(userAccounts.get(i).getUsername());
        ((TextView)myHolder.finViewById(R.id.tv_password)).setText(userAccounts.get(i).getPassword());
    }

    @Override
    public int getItemCount() {
        return userAccounts.size();
    }
}
