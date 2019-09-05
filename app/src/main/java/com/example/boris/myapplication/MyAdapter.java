package com.example.boris.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    List<MessageModel> messages;
    MainActivity mainActivity;

    public MyAdapter(List<MessageModel> messages, MainActivity mainActivity) {
        this.messages = messages;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Picasso.with(mainActivity.getApplicationContext()).load(messages.get(position).getImage()).into(holder.imageView);
        holder.mainText.setText(messages.get(position).getText());
        holder.date.setText(getDateFtomLong(messages.get(position).getDate()));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView mainText, date;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImage);
            mainText = itemView.findViewById(R.id.itemMainText);
            date = itemView.findViewById(R.id.itemDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (messages.get(getAdapterPosition()).getMessageType() == MessageType.MY_MESSAGE){
                        Toast.makeText(mainActivity, messages.get(getAdapterPosition()).getText(), Toast.LENGTH_LONG).show();
                    }
                    if (messages.get(getAdapterPosition()).getMessageType() == MessageType.LINK){
                        mainActivity.startAd();
                    }
                }
            });


        }
    }

    private String getDateFtomLong(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(time);
    }
}
