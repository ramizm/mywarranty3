package com.example.mywarranty3.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mywarranty3.R;
import com.example.mywarranty3.activity.WarrantyDetailActivity;
import com.example.mywarranty3.model.UserWarranty;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by ramizm_2 on 2015-11-26.
 */
public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

//    private List<UserWarranty> listPromotion;
    private int[] img;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

//        public ImageView imgProduct;
//        public ImageView imgBrand;
//        public TextView txtBrandName;
//        public TextView txtProductName;
//        public TextView txtPurchaseDate;
        public ImageView imgPromotion;
        public Context context;


        public ViewHolder(View itemVIew) {
            super(itemVIew);

//            itemVIew.setOnClickListener(this);
            context = itemView.getContext();
//            imgProduct = (ImageView) itemVIew.findViewById(R.id.img_product);
//            imgBrand = (ImageView) itemVIew.findViewById(R.id.img_brand);
//            txtBrandName = (TextView) itemVIew.findViewById(R.id.txt_brand_name);
//            txtProductName = (TextView) itemVIew.findViewById(R.id.txt_product_name);
//            txtPurchaseDate = (TextView) itemVIew.findViewById(R.id.txt_purchase_date);
            imgPromotion = (ImageView) itemVIew.findViewById(R.id.img_promotion);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(v.getContext(), WarrantyDetailActivity.class);
//            intent.putExtra("warrantyId", txtBrandName.getTag().toString());
//            v.getContext().startActivity(intent);
        }
    }

    public PromotionAdapter(){
    }

    public PromotionAdapter(int[] img){
        this.img = img;
    }

    public void setListUserWarranty(List<UserWarranty> listUserWarranty) {
//        this.listUserWarranty = listUserWarranty;
//        this.notifyDataSetChanged();
    }

    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotion, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionAdapter.ViewHolder holder, int position) {
//        UserWarranty userWarranty = listUserWarranty.get(position);
//        holder.txtBrandName.setText(userWarranty.getBrand().getName());
//        holder.txtProductName.setText(userWarranty.getProduct().getName());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        holder.txtPurchaseDate.setText(formatter.format(userWarranty.getPurchaseDate()));
//        Glide.with(holder.context).load(userWarranty.getBrand().getLogoImage()).into(holder.imgBrand);
//        Glide.with(holder.context).load(userWarranty.getProduct().getImage()).into(holder.imgProduct);
//
//        holder.txtBrandName.setTag(userWarranty.getId());
        Glide.with(holder.context).load(img[position]).into(holder.imgPromotion);
//        holder.imgPromotion.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
//        return listUserWarranty != null ? listUserWarranty.size() : 0;
        return img.length;
    }
}
