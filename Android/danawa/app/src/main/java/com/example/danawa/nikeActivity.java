package com.example.danawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class nikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsm);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 엘리트 AG-PRO", "289,000" , "발볼 등급 : C", R.drawable.nike1));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 엘리트 FG", "289,000" , "발볼 등급 : C", R.drawable.nike2));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 아카데미 HG", "99,000" , "발볼 등급 : C", R.drawable.nike3));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 엘리트 DF SW FG","329,000" , "발볼 등급 : C", R.drawable.nike4));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 아카데미 FLYEASE FG", "99,000" , "발볼 등급 : C", R.drawable.nike5));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 아카데미 HG", "99,000" , "발볼 등급 : C", R.drawable.nike6));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT2 엘리트 DF FG", "309,000" , "발볼 등급 : C", R.drawable.nike7));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT 아카데미 HG", "99,000" , "발볼 등급 : C", R.drawable.nike8));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 GT 아카데미 HG", "99,000" , "발볼 등급 : C", R.drawable.nike9));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 비전 2 아카데미 DF HG", "109,000" ,  "발볼 등급 : B", R.drawable.nike10));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 비전 2 엘리트 DF FG", "329,000" , "발볼 등급 : B", R.drawable.nike11));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 비전 2 프로 DF HG", "199,000" , "발볼 등급 : B", R.drawable.nike12));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 비전 2 프로 DF FG", "179,000" , "발볼 등급 : B", R.drawable.nike13));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 비전 엘리트 DF FG", "329,000" , "발볼 등급 : B", R.drawable.nike14));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 클럽 FG", "79,000" , "발볼 등급 : B", R.drawable.nike15));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 프로 FG", "179,000" , "발볼 등급 : B", R.drawable.nike16));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 프로 HG", "179,000" , "발볼 등급 : B", R.drawable.nike17));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 아카데미 HG", "99,000" , "발볼 등급 : B", R.drawable.nike18));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 프로 HG", "179,000" , "발볼 등급 : B", R.drawable.nike19));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 아카데미 HG", "99,000" , "발볼 등급 : B", R.drawable.nike20));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 프로 HG", "179,000" , "발볼 등급 : B", R.drawable.nike21));
        adapter.addItem(new com.example.danawa.Product("나이키 팬텀 베놈 아카데미 HG", "99,000" , "발볼 등급 : B", R.drawable.nike22));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 8 엘리트 FG", "319,000" , "발볼 등급 : A", R.drawable.nike23));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 AG", "299,000" , "발볼 등급 : A", R.drawable.nike24));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 8 엘리트 MDS FG", "339,000" , "발볼 등급 : A", R.drawable.nike25));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 8 엘리트 FG", "319,000" , "발볼 등급 : A", R.drawable.nike26));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 8 엘리트 FG", "319,000" , "발볼 등급 : A", R.drawable.nike27));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 FG", "299,000" , "발볼 등급 : A", R.drawable.nike28));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 프로 HG", "169,000" , "발볼 등급 : A", R.drawable.nike29));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike30));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 FG", "299,000" , "발볼 등급 : A", R.drawable.nike31));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 FG", "289,000" , "발볼 등급 : A", R.drawable.nike32));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike33));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 HG", "289,000" , "발볼 등급 : A", R.drawable.nike34));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike35));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 8 엘리트 FG", "309,000" , "발볼 등급 : A", R.drawable.nike36));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 8 엘리트 FG", "309,000" , "발볼 등급 : A", R.drawable.nike37));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 FG", "289,000" , "발볼 등급 : A", R.drawable.nike38));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 프로 HG", "169,000" , "발볼 등급 : A", R.drawable.nike39));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 프로 HG", "169,000" , "발볼 등급 : A", R.drawable.nike40));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike41));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike42));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 7 아카데미 HG", "109,000" , "발볼 등급 : A", R.drawable.nike43));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike44));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 아카데미 HG", "99,000" , "발볼 등급 : A", R.drawable.nike45));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 아카데미 FG", "99,000" , "발볼 등급 : A", R.drawable.nike46));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 7 아카데미 HG", "109,000" , "발볼 등급 : A", R.drawable.nike47));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 프로 HG", "139,000" , "발볼 등급 : A", R.drawable.nike48));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 7 엘리트 FG", "329,000" , "발볼 등급 : A", R.drawable.nike49));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 프로 네이마르 HG", "149,000" , "발볼 등급 : A", R.drawable.nike50));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 7 엘리트 MDS FG", "349,000" , "발볼 등급 : A", R.drawable.nike51));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 아카데미 MDS HG", "99,000" , "발볼 등급 : A", R.drawable.nike52));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 프로 MDS HG", "139,000" , "발볼 등급 : A", R.drawable.nike53));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 프로 HG", "139,000" , "발볼 등급 : A", R.drawable.nike54));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 프로 MDS HG", "139,000" , "발볼 등급 : A", R.drawable.nike55));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 아카데미 MDS FG", "99,000" , "발볼 등급 : A", R.drawable.nike56));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 수퍼플라이 7 아카데미 MDS HG", "119,000" , "발볼 등급 : A", R.drawable.nike57));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 13 프로 HG", "139,000" , "발볼 등급 : A", R.drawable.nike58));
        adapter.addItem(new com.example.danawa.Product("나이키 머큐리얼 베이퍼 14 엘리트 AG", "289,000" , "발볼 등급 : A", R.drawable.nike59));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 아카데미", "60,670" , "발볼 등급 : E", R.drawable.nike60));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 아카데미", "85,000" , "발볼 등급 : E", R.drawable.nike61));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 아카데미", "82,010" , "발볼 등급 : E", R.drawable.nike62));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 아카데미", "144,000" , "발볼 등급 : E", R.drawable.nike63));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 클럽", "73,990" , "발볼 등급 : D", R.drawable.nike64));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 아카데미", "388,740" , "발볼 등급 : D", R.drawable.nike65));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 아카데미", "70,190" , "발볼 등급 : D", R.drawable.nike66));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 엘리트 PRO", "256,150" , "발볼 등급 : E", R.drawable.nike67));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 아카데미", "87,210" , "발볼 등급 : D", R.drawable.nike68));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 엘리트", "153,500" , "발볼 등급 : E", R.drawable.nike69));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 아카데미", "64,580" , "발볼 등급 : E", R.drawable.nike70));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 아카데미", "73,000" , "발볼 등급 : D", R.drawable.nike71));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드8 프로", "75,640" , "발볼 등급 : D", R.drawable.nike72));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 엘리트", "215,190" , "발볼 등급 : E", R.drawable.nike73));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 엘리트", "367,900" , "발볼 등급 : E", R.drawable.nike74));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 PRO", "98,600" , "발볼 등급 : D", R.drawable.nike75));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 엘리트", "185,900" , "발볼 등급 : E", R.drawable.nike76));
        adapter.addItem(new com.example.danawa.Product("나이키 티엠포 레전드9 엘리트", "208,810" , "발볼 등급 : D", R.drawable.nike77));


        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Intent intent = new Intent(nikeActivity.this, detailActivity.class);

                intent.putExtra("pro_name", item.getName());
                intent.putExtra("pro_cost", item.getCost());
                intent.putExtra("pro_level", item.getFootlevel());
                intent.putExtra("pro_pic", item.getPic());

                startActivity(intent);
                Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +
                        "\n 설명 : " + item.getFootlevel(),Toast.LENGTH_LONG).show();
            }
        });

        Button imageButton = (Button) findViewById(R.id.button_first);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(intent);
            }
        });

        Button imageButton2 = (Button) findViewById(R.id.nike_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), lsmActivity.class);
                startActivity(intent);
            }
        });

        Button imageButton3 = (Button) findViewById(R.id.adi_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), adiActivity.class);
                startActivity(intent);
            }
        });

        Button imageButton4 = (Button) findViewById(R.id.fuma_button);
        imageButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), fumaActivity.class);
                startActivity(intent);
            }
        });

        Button imageButton5 = (Button) findViewById(R.id.miz_button);
        imageButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), mizActivity.class);
                startActivity(intent);
            }
        });

    }
}