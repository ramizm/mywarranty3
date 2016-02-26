package com.example.mywarranty3.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.example.mywarranty3.R;
import com.example.mywarranty3.SharedApplication;
import com.example.mywarranty3.adapter.ViewPagerAdapter;
import com.example.mywarranty3.adapter.WarrantyAdapter;
import com.example.mywarranty3.fragment.PromotionFragment;
import com.example.mywarranty3.fragment.WarrantyFragment;
import com.example.mywarranty3.model.User;
import com.example.mywarranty3.model.UserWarranty;
import com.example.mywarranty3.model.Warranty;
import com.example.mywarranty3.util.ApiCaller;
import com.example.mywarranty3.util.Callback;

import java.text.SimpleDateFormat;
import java.util.List;

public class WarrantyActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private WarrantyAdapter adapter;
//    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warranty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_warranty);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        TextView txtTitle = (TextView) findViewById(R.id.txt_warranty_title);
        txtTitle.setText(R.string.title_activity_my_warranty);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        layoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new WarrantyAdapter();
//        recyclerView.setAdapter(adapter);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openNewWarrantyDialog();
//
//            }
//        });
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new WarrantyFragment(), getResources().getString(R.string.tab_warranty_title));
        adapter.addFrag(new PromotionFragment(), getResources().getString(R.string.tab_promotion_title));

        viewPager.setAdapter(adapter);
    }

//    private void openNewWarrantyDialog() {
//        new MaterialDialog.Builder(WarrantyActivity.this)
//                .title(R.string.input_redeem_code)
//                .inputType(InputType.TYPE_CLASS_TEXT)
//                .input("Redeem Code", "", new MaterialDialog.InputCallback() {
//                    @Override
//                    public void onInput(MaterialDialog dialog, CharSequence input) {
//                        ApiCaller.getWarranty(input.toString(), new Callback<Warranty>() {
//                            @Override
//                            public void onSuccess(Warranty result) {
//                                openWarrantyPreviewDialog(result);
//                            }
//
//                            @Override
//                            public void onFailure() {
//
//                            }
//                        });
//                        // Do something
//                    }
//                }).show();
//    }
//
//    private void openWarrantyPreviewDialog(final Warranty result) {
//        MaterialDialog dialog = new MaterialDialog.Builder(this)
//                .customView(R.layout.content_warranty_card, true)
//                .positiveText("OK")
//                .onPositive(new MaterialDialog.SingleButtonCallback() {
//                    @Override
//                    public void onClick(MaterialDialog dialog, DialogAction which) {
//                        ApiCaller.addWarranty(SharedApplication.getInstance().getCurrentUser(), result.getId(), new Callback<Boolean>() {
//                            @Override
//                            public void onSuccess(Boolean result) {
//                                refreshData();
//                            }
//
//                            @Override
//                            public void onFailure() {
//                                refreshData();
//                            }
//                        });
//                    }
//                })
//                .show();
//        View view= dialog.getCustomView();
//
//        ImageView imgBrand = (ImageView) view.findViewById(R.id.img_detail_brand);
//        ImageView imgProduct = (ImageView) view.findViewById(R.id.img_detail_product);
//        TextView txtBrandName = (TextView) view.findViewById(R.id.txt_detail_brand_name);
//        TextView txtProductName = (TextView) view.findViewById(R.id.txt_detail_product_name);
//        TextView txtPurchaseDate = (TextView) view.findViewById(R.id.txt_detail_purchase_date);
//        TextView txtExpirationDate = (TextView) view.findViewById(R.id.txt_detail_expire_date);
//        TextView txtSeller = (TextView) view.findViewById(R.id.txt_detail_seller_name);
//        TextView txtSellerBrand = (TextView) view.findViewById(R.id.txt_detail_seller_brand);
//        TextView txtSellerTel = (TextView) view.findViewById(R.id.txt_detail_seller_tel);
//
//        Glide.with(this).load(result.getProduct().getImage()).into(imgProduct);
//        Glide.with(this).load(result.getBrand().getLogoImage()).into(imgBrand);
//        txtBrandName.setText(result.getBrand().getName());
//        txtProductName.setText(result.getProduct().getName());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        txtPurchaseDate.setText(formatter.format(result.getPurchaseDate()));
//        txtExpirationDate.setText(formatter.format(result.getExpirationDate()));
//        txtSeller.setText(result.getSellerName());
//        txtSellerBrand.setText(result.getBrand().getName());
//        txtSellerTel.setText(result.getSellerTel().toString());
//
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        refreshData();
//    }

//    private void refreshData() {
//        ApiCaller.getUserData(SharedApplication.getInstance().getToken().getUser(), new Callback<User>() {
//            @Override
//            public void onSuccess(User result) {
//                if(result != null){
//                    SharedApplication.getInstance().setCurrentUser(result);
//                    List<UserWarranty> warranties = result.getWarranties();
//                    if (warranties != null) {
//                        adapter.setListUserWarranty(warranties);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure() {
//
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_warranty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
