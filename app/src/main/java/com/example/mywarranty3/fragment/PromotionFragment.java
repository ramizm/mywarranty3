package com.example.mywarranty3.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywarranty3.R;
import com.example.mywarranty3.adapter.PromotionAdapter;

public class PromotionFragment extends Fragment {

    private PromotionAdapter adapter;
    private int[] img;

    public PromotionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_promotion);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        img = new int[3];
        img[0]=R.drawable.promotion1;
        img[1]=R.drawable.promotion2;
        img[2]=R.drawable.promotion3;

        adapter = new PromotionAdapter(img);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
