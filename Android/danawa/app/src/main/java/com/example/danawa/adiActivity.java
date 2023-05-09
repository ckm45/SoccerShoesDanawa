package com.example.danawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsm);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new Product("아디다스 프레데터 펄스", "459,000" , "발볼 등급 : C", R.drawable.adi1));
        adapter.addItem(new Product("아디다스 프레데터 펄스 UCL", "459,000" , "발볼 등급 : C", R.drawable.adi2));
        adapter.addItem(new Product("아디다스 프레데터 프릭+폴 포그바X스텔라 맥카트니 ", "369,000" , "발볼 등급 : C", R.drawable.adi3));
        adapter.addItem(new Product("아디다스 프레데터 프릭+", "359,000" , "발볼 등급 : C", R.drawable.adi4));
        adapter.addItem(new Product("아디다스 프레데터 엣지.1", "299,000" , "발볼 등급 : C", R.drawable.adi5));
        adapter.addItem(new Product("아디다스 프레데터 엣지.1 ", "299,000" , "발볼 등급 : C", R.drawable.adi6));
        adapter.addItem(new Product("아디다스 프레데터 엣지.3 L", "109,000" , "발볼 등급 : C", R.drawable.adi7));
        adapter.addItem(new Product("아디다스 프레데터 엣지.3 ", "129,000" , "발볼 등급 : C", R.drawable.adi8));
        adapter.addItem(new Product("아디다스 프레데터 엣지.1 L ", "299,000" , "발볼 등급 : C", R.drawable.adi9));
        adapter.addItem(new Product("아디다스 프레데터 엣지.1 L ", "299,000" , "발볼 등급 : C", R.drawable.adi10));
        adapter.addItem(new Product("아디다스 프레데터 뮤테이터 20.2", "169,000" , "발볼 등급 : D", R.drawable.adi11));
        adapter.addItem(new Product("아디다스 프레데터 프릭.1 L", "299,000" , "발볼 등급 : C", R.drawable.adi12));
        adapter.addItem(new Product("아디다스 프레데터 뮤테이터 20.1", "299,000" , "발볼 등급 : D", R.drawable.adi13));
        adapter.addItem(new Product("아디다스 프레데터 프릭.1 L", "299,000" , "발볼 등급 : C", R.drawable.adi14));
        adapter.addItem(new Product("아디다스 프레데터 뮤테이터 20.1 L", "299,000" , "발볼 등급 : C", R.drawable.adi15));
        adapter.addItem(new Product("아디다스 프레데터 프릭.1", "299,000" , "발볼 등급 : D", R.drawable.adi16));
        adapter.addItem(new Product("아디다스 프레데터 프릭.1 L", "299,000" , "발볼 등급 : C", R.drawable.adi17));
        adapter.addItem(new Product("아디다스 프레데터 프릭.3 L", "109,000" , "발볼 등급 : C", R.drawable.adi18));
        adapter.addItem(new Product("아디다스 프레데터 프릭.1", "299,000" , "발볼 등급 : C", R.drawable.adi19));
        adapter.addItem(new Product("아디다스 프레데터 프릭.3", "129,000" , "발볼 등급 : B", R.drawable.adi20));
        adapter.addItem(new Product("아디다스 프레데터 프릭.1 L", "299,000" , "발볼 등급 : C", R.drawable.adi21));
        adapter.addItem(new Product("아디다스 프레데터 20.4 FXG", "79,000" , "발볼 등급 : C", R.drawable.adi22));
        adapter.addItem(new Product("아디다스 프레데터 20.3 L", "99,000" , "발볼 등급 : C", R.drawable.adi23));
        adapter.addItem(new Product("아디다스 프레데터 20.4 S FXG", "89,000" , "발볼 등급 : B", R.drawable.adi24));
        adapter.addItem(new Product("아디다스 프레데터 19.1", "239,000" , "발볼 등급 : C", R.drawable.adi25));
        adapter.addItem(new Product("아디다스 프레데터 19.4 FXG", "79,000" , "발볼 등급 : C", R.drawable.adi26));
        adapter.addItem(new Product("아디다스 프레데터 18.1", "259,000" , "발볼 등급 : C", R.drawable.adi27));
        adapter.addItem(new Product("아디다스 네메시스 0.1", "299,000" , "발볼 등급 : A", R.drawable.adi28));
        adapter.addItem(new Product("아디다스 네메시스 0.1", "299,000" , "발볼 등급 : A", R.drawable.adi29));
        adapter.addItem(new Product("아디다스 네메시스 0.3", "129,000" , "발볼 등급 : C", R.drawable.adi30));
        adapter.addItem(new Product("아디다스 네메시스 19.3", "119,000" , "발볼 등급 : A", R.drawable.adi31));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우+", "359,000" , "발볼 등급 : B", R.drawable.adi32));
        adapter.addItem(new Product("아디다스 F50 고스티드 UCL", "339,000" , "발볼 등급 : A", R.drawable.adi33));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.3", "109,000" , "발볼 등급 : B", R.drawable.adi34));
        adapter.addItem(new Product("아디다스 엑스 고스티드.1", "299,000" , "발볼 등급 : B", R.drawable.adi35));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.1", "299,000" , "발볼 등급 : B", R.drawable.adi36));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우 메시.1", "299,000" , "발볼 등급 : B", R.drawable.adi37));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.1", "299,000" , "발볼 등급 : B", R.drawable.adi38));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.2", "179,000" , "발볼 등급 : B", R.drawable.adi39));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.4 FXG ", "79,000" , "발볼 등급 : C", R.drawable.adi40));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.1", "299,000" , "발볼 등급 : B", R.drawable.adi41));
        adapter.addItem(new Product("아디다스 엑스 스피드플로우.3 LL", "139,000" , "발볼 등급 : B", R.drawable.adi42));
        adapter.addItem(new Product("아디다스 엑스 고스티드.1", "299,000" , "발볼 등급 : B", R.drawable.adi43));
        adapter.addItem(new Product("아디다스 엑스 19.3", "119,000" , "발볼 등급 : B", R.drawable.adi44));
        adapter.addItem(new Product("아디다스 엑스 고스티드.3", "129,000" , "발볼 등급 : B", R.drawable.adi45));
        adapter.addItem(new Product("아디다스 엑스 고스티드.2", "179,000" , "발볼 등급 : B", R.drawable.adi46));
        adapter.addItem(new Product("아디다스 엑스 고스티드.1", "299,000" , "발볼 등급 : B", R.drawable.adi47));
        adapter.addItem(new Product("아디다스 엑스 고스티드.4 FXG", "79,000" , "발볼 등급 : B", R.drawable.adi48));
        adapter.addItem(new Product("아디다스 엑스 19.2", "169,000" , "발볼 등급 : B", R.drawable.adi49));
        adapter.addItem(new Product("아디다스 엑스 19.1", "239,000" , "발볼 등급 : B", R.drawable.adi50));
        adapter.addItem(new Product("아디다스 엑스 19.4 FXG", "79,000" , "발볼 등급 : B", R.drawable.adi51));
        adapter.addItem(new Product("아디다스 코파  18.3", "39,900" , "발볼 등급 : C", R.drawable.adi52));
        adapter.addItem(new Product("아디다스 코파  20.1", "138,910" , "발볼 등급 : D", R.drawable.adi53));
        adapter.addItem(new Product("아디다스 코파  20.3", "52,720" , "발볼 등급 : D", R.drawable.adi54));
        adapter.addItem(new Product("아디다스 코파  20.4", "37,260" , "발볼 등급 : D", R.drawable.adi55));
        adapter.addItem(new Product("아디다스 코파  글로로 20.2", "55,050" , "발볼 등급 : D", R.drawable.adi56));
        adapter.addItem(new Product("아디다스 코파  문디알 21PK", "178,480" , "발볼 등급 : D", R.drawable.adi57));
        adapter.addItem(new Product("아디다스 코파  문디알", "101,740" , "발볼 등급 : D", R.drawable.adi58));
        adapter.addItem(new Product("아디다스 코파  센스.1", "151,480" , "발볼 등급 : D", R.drawable.adi59));
        adapter.addItem(new Product("아디다스 코파  센스.1", "160,540" , "발볼 등급 : D", R.drawable.adi60));
        adapter.addItem(new Product("아디다스 코파  센스.1", "151,840" , "발볼 등급 : D", R.drawable.adi61));
        adapter.addItem(new Product("아디다스 코파  센스.3", "151,840" , "발볼 등급 : D", R.drawable.adi62));
        adapter.addItem(new Product("아디다스 네메시스 0.1", "299,000" , "발볼 등급 : A", R.drawable.adi63));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Intent intent = new Intent(adiActivity.this, detailActivity.class);

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
                Intent intent = new Intent(getApplicationContext(), nikeActivity.class);
                startActivity(intent);
            }
        });

        Button imageButton3 = (Button) findViewById(R.id.adi_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), lsmActivity.class);
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