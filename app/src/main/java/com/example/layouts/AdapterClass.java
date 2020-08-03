package com.example.layouts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {

    Context mContext;
    String[] title,subtitle;
    int[] images;

    public AdapterClass(Context mContext, String[] title, String[] subtitle, int[] images) {
        this.mContext = mContext;
        this.title = title;
        this.subtitle = subtitle;
        this.images = images;
    }

    @NonNull
    @Override
    public AdapterClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view =layoutInflater.inflate(R.layout.design_file,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.MyViewHolder holder, int position) {

        holder.imageView.setImageResource(images[position]);
        holder.titleText.setText(title[position]);
        holder.subTitle.setText(subtitle[position]);



    }

    @Override
    public int getItemCount() {
        return title.length;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleText,subTitle;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewID);
            titleText = itemView.findViewById(R.id.textView3);
            subTitle = itemView.findViewById(R.id.textView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Details.class);
                    i.putExtra("title",title[getAdapterPosition()]);
                    i.putExtra("desc",subtitle[getAdapterPosition()]);
                    //Toast.makeText(v.getContext(),"1" + title[getAdapterPosition()] + "2" + subtitle[getAdapterPosition()], Toast. LENGTH_LONG).show();
                    v.getContext().startActivity(i);
                }
            });
        }

    }
}
