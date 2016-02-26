package com.example.mywarranty3.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.example.mywarranty3.R;
import com.example.mywarranty3.SharedApplication;
import com.example.mywarranty3.adapter.WarrantyAdapter;
import com.example.mywarranty3.model.User;
import com.example.mywarranty3.model.UserWarranty;
import com.example.mywarranty3.model.Warranty;
import com.example.mywarranty3.util.ApiCaller;
import com.example.mywarranty3.util.Callback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WarrantyFragment extends Fragment {

    WarrantyAdapter adapter;

    public WarrantyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_warranty, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_warranty);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new WarrantyAdapter();
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewWarrantyDialog();

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        refreshData();
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }

    public void refreshData() {
        ApiCaller.getUserData(SharedApplication.getInstance().getToken().getUser(), new Callback<User>() {
            @Override
            public void onSuccess(User result) {
                if (result != null) {
                    SharedApplication.getInstance().setCurrentUser(result);
                    List<UserWarranty> warranties = result.getWarranties();
                    if (warranties != null) {
                        adapter.setListUserWarranty(warranties);
                    }
                }
            }

            @Override
            public void onFailure() {

            }
        });
    }

    private void openNewWarrantyDialog() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.input_redeem_code)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("Redeem Code", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        ApiCaller.getWarranty(input.toString(), new Callback<Warranty>() {
                            @Override
                            public void onSuccess(Warranty result) {
                                openWarrantyPreviewDialog(result);
                            }

                            @Override
                            public void onFailure() {

                            }
                        });
                        // Do something
                    }
                }).show();
    }

    private void openWarrantyPreviewDialog(final Warranty result) {
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .customView(R.layout.content_warranty_card, true)
                .positiveText("OK")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        ApiCaller.addWarranty(SharedApplication.getInstance().getCurrentUser(), result.getId(), new Callback<Boolean>() {
                            @Override
                            public void onSuccess(Boolean result) {
                                refreshData();
                            }

                            @Override
                            public void onFailure() {
                                refreshData();
                            }
                        });
                    }
                })
                .show();
        View view= dialog.getCustomView();

        ImageView imgBrand = (ImageView) view.findViewById(R.id.img_detail_brand);
        ImageView imgProduct = (ImageView) view.findViewById(R.id.img_detail_product);
        TextView txtBrandName = (TextView) view.findViewById(R.id.txt_detail_brand_name);
        TextView txtProductName = (TextView) view.findViewById(R.id.txt_detail_product_name);
        TextView txtPurchaseDate = (TextView) view.findViewById(R.id.txt_detail_purchase_date);
        TextView txtExpirationDate = (TextView) view.findViewById(R.id.txt_detail_expire_date);
        TextView txtSeller = (TextView) view.findViewById(R.id.txt_detail_seller_name);
        TextView txtSellerBrand = (TextView) view.findViewById(R.id.txt_detail_seller_brand);
        TextView txtSellerTel = (TextView) view.findViewById(R.id.txt_detail_seller_tel);

        Glide.with(this).load(result.getProduct().getImage()).into(imgProduct);
        Glide.with(this).load(result.getBrand().getLogoImage()).into(imgBrand);
        txtBrandName.setText(result.getBrand().getName());
        txtProductName.setText(result.getProduct().getName());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        txtPurchaseDate.setText(formatter.format(result.getPurchaseDate()));
        txtExpirationDate.setText(formatter.format(result.getExpirationDate()));
        txtSeller.setText(result.getSellerName());
        txtSellerBrand.setText(result.getBrand().getName());
        txtSellerTel.setText(result.getSellerTel().toString());

    }
}
