package com.example.layouts.ByRestApi;

import android.app.LauncherActivity;
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

import com.example.layouts.AdapterClass;
import com.example.layouts.Details;
import com.example.layouts.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterClass2 extends RecyclerView.Adapter<AdapterClass2.MyViewHolder> {

    List<ListItems> listItems;
    Context mContext;
    String[] title, subtitle;
    int[] images;

    public AdapterClass2(List<ListItems> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public AdapterClass2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.design_file, parent, false);
        return new AdapterClass2.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ListItems listItem = listItems.get(position);

        holder.titleText.setText(listItem.getName());
        holder.subTitle.setText(listItem.getDesc());
        Picasso.get().load(listItem.getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleText, subTitle;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewID);
            titleText = itemView.findViewById(R.id.textView3);
            subTitle = itemView.findViewById(R.id.textView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Details.class);
                    i.putExtra("title", title[getAdapterPosition()]);
                    i.putExtra("desc", subtitle[getAdapterPosition()]);
                    Toast.makeText(v.getContext(), "1" + title[getAdapterPosition()] + "2" + subtitle[getAdapterPosition()], Toast.LENGTH_LONG).show();
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
