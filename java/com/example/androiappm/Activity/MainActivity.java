package com.example.androiappm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androiappm.Adapter.CategoryAdapter;
import com.example.androiappm.Adapter.RecommendedAdapter;
import com.example.androiappm.Domain.CategoryDomain;
import com.example.androiappm.Domain.MakeupDomain;
import com.example.androiappm.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();


    }


    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<MakeupDomain> makeuplist = new ArrayList<>();
        makeuplist.add(new MakeupDomain("lipstick", "pic_1",
                "Texture is weightless on lips and delivers superb comfort\n" ,130, 5, 9, 20));
        makeuplist.add(new MakeupDomain("eyeliner", "pic_2", "ormulated with care, our eyeliner is ophthalmologist-tested and suitable for sensitive eyes and contact lens wearers. ", 150, 4, 10, 15));
        makeuplist.add(new MakeupDomain("foundation", "pic_3", " Lightweight and Ultra-Matte Finish: This blush is made from ultra-fine particles that absorb oil instantly to give a matte finish. The feather-light formula that doesn't weigh your skin down.", 110, 3, 16, 8));
        makeuplist.add(new MakeupDomain("gliter eyeliner","gliter1","This Palette Offers A Gorgeous Mix Of Matte And Shimmer Shades Which Helps You Creates Limitless Look For Eyes.",250,5,12,17));
        makeuplist.add(new MakeupDomain("mascara","mascara1","The smooth and creamy texture of our mascara prevents clumping, allowing for seamless application.",225,4,7,31));
        makeuplist.add(new MakeupDomain("eyebrow pencil","eyepencil","smudge-proof, fade-resistant brows that maintain their impeccable shape from morning to night.",200,5,10,22));
//
        adapter2 = new RecommendedAdapter(makeuplist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("lipstick","pic_1"));
        categoryList.add(new CategoryDomain("eyeliner","pic_2"));
        categoryList.add(new CategoryDomain("foundation","pic_3"));
        categoryList.add(new CategoryDomain("mascara","pic_4"));
        categoryList.add(new CategoryDomain("eyebrow pencil","pic_5"));
        categoryList.add(new CategoryDomain("glitter eyeliner","gliter1"));
        categoryList.add(new CategoryDomain("eye shadow","image_13"));
        categoryList.add(new CategoryDomain("Nailpolish","image_19"));
        categoryList.add(new CategoryDomain("Makeup Brush","image_10"));
        categoryList.add(new CategoryDomain("powder","image_24"));
        categoryList.add(new CategoryDomain("Face serum","image_25"));
        categoryList.add(new CategoryDomain("Eyelashes","image_26"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);

    }
}