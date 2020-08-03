package com.example.layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment1 extends Fragment {

    RecyclerView recyclerView;
    String [] title, subtitles;
    AdapterClass adapterClass;
    int [] images = {R.drawable.c,R.drawable.d,R.drawable.a,R.drawable.b,R.drawable.e};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment1_layout, container, false);

        recyclerView = view.findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);

        title =  getResources().getStringArray(R.array.title);
        subtitles = getResources().getStringArray(R.array.Sub_title);

        adapterClass = new AdapterClass(getActivity(),title,subtitles,images);

        recyclerView.setAdapter(adapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;

    }
}
