package com.example.danawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsm);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new Product("미즈노 레뷸라컵 JP", "239,000" , "발볼 등급 : D", R.drawable.miz1));
        adapter.addItem(new Product("미즈노 레뷸라컵 셀렉트", "83,000" , "발볼 등급 : D", R.drawable.miz2));
        adapter.addItem(new Product("미즈노 레뷸라3 엘리트", "195,000" , "발볼 등급 : D", R.drawable.miz3));
        adapter.addItem(new Product("미즈노 레뷸라컵 프로", "119,000" , "발볼 등급 : D", R.drawable.miz4));
        adapter.addItem(new Product("미즈노 모렐리아네오3 프로", "139,000" , "발볼 등급 : E", R.drawable.miz5));
        adapter.addItem(new Product("미즈노 모렐리아네오3 엘리트", "183,000" , "발볼 등급 : E", R.drawable.miz6));
        adapter.addItem(new Product("미즈노 모렐리아네오3 베타", "293,000" , "발볼 등급 : E", R.drawable.miz7));
        adapter.addItem(new Product("미즈노 모렐리아네오3 베타엘리트", "234,000" , "발볼 등급 : E", R.drawable.miz8));
        adapter.addItem(new Product("미즈노 모렐리아 UL", "279,000" , "발볼 등급 : E", R.drawable.miz9));
        adapter.addItem(new Product("미즈노 웨이브컵 레전드", "219,000" , "발볼 등급 : E", R.drawable.miz10));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Intent intent = new Intent(mizActivity.this, detailActivity.class);

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
                Intent intent = new Intent(getApplicationContext(), lsmActivity.class);
                startActivity(intent);
            }
        });

    }
}