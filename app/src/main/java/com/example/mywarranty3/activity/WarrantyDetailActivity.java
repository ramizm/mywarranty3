package com.example.mywarranty3.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.example.mywarranty3.R;
import com.example.mywarranty3.model.UserWarranty;
import com.example.mywarranty3.model.Warranty;
import com.example.mywarranty3.util.ApiCaller;
import com.example.mywarranty3.util.Callback;

import java.text.SimpleDateFormat;

public class WarrantyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warranty_detail);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);

        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText(R.string.title_activity_warranty_detail);

        Intent intent = getIntent();
        final String warrantyId = intent.getStringExtra("warrantyId");

        final ImageView imgBrand = (ImageView) findViewById(R.id.img_detail_brand);
        final ImageView imgProduct = (ImageView) findViewById(R.id.img_detail_product);
        final TextView txtBrandName = (TextView) findViewById(R.id.txt_detail_brand_name);
        final TextView txtProductName = (TextView) findViewById(R.id.txt_detail_product_name);
        final TextView txtPurchaseDate = (TextView) findViewById(R.id.txt_detail_purchase_date);
        final TextView txtExpirationDate = (TextView) findViewById(R.id.txt_detail_expire_date);
        final TextView txtSeller = (TextView) findViewById(R.id.txt_detail_seller_name);
        final TextView txtSellerBrand = (TextView) findViewById(R.id.txt_detail_seller_brand);
        final TextView txtSellerTel = (TextView) findViewById(R.id.txt_detail_seller_tel);
        final Button btnDelete = (Button) findViewById(R.id.btn_delete);

        ApiCaller.getWarranty(warrantyId, new Callback<Warranty>() {
            @Override
            public void onSuccess(Warranty result) {

                Glide.with(WarrantyDetailActivity.this).load(result.getProduct().getImage()).into(imgProduct);
                Glide.with(WarrantyDetailActivity.this).load(result.getBrand().getLogoImage()).into(imgBrand);
                txtBrandName.setText(result.getBrand().getName());
                txtProductName.setText(result.getProduct().getName());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                txtPurchaseDate.setText(formatter.format(result.getPurchaseDate()));
                txtExpirationDate.setText(formatter.format(result.getExpirationDate()));
                txtSeller.setText(result.getSellerName());
                txtSellerBrand.setText(result.getBrand().getName());
                txtSellerTel.setText(result.getSellerTel().toString());
                btnDelete.setText("삭제");
            }

            @Override
            public void onFailure() {

            }

        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog dialog = new MaterialDialog.Builder(WarrantyDetailActivity.this)
                        .title(R.string.delete)
                        .content(R.string.delete_warranty)
                        .negativeText("CANCEL")
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                            }
                        })
                        .positiveText("OK")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                                ApiCaller.deleteWarranty(warrantyId);
                                finish();
                            }
                        })
                        .show();
            }
        });
    }
}
