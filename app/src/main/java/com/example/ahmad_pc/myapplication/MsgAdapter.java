package com.example.ahmad_pc.myapplication;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MessageViewHolder> {

    final ArrayList<Msg> data;

    public MsgAdapter(ArrayList<Msg> input) {
        this.data = input;
    }

    public void addMessage(Msg msg) {
        data.add(msg);
        notifyItemInserted(data.size() - 1);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_view, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Msg msg = data.get(position);
        holder.time.setText(DateUtils.getRelativeTimeSpanString(holder.itemView.getContext(), msg.getTime()));
        holder.msg.setText(msg.getText());
        holder.name.setText(msg.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView msg;
        TextView time;

        public MessageViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);
            time = itemView.findViewById(R.id.time);
        }
    }
}

