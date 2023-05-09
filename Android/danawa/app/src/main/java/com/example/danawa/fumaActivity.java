package com.example.danawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class fumaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsm);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();
        adapter.addItem(new Product("푸마 울트라 프로", "109,000" , "발볼 등급 : E", R.drawable.fuma1));
        adapter.addItem(new Product("푸마 울트라 매치플러스", "83,000" , "발볼 등급 : E", R.drawable.fuma2));
        adapter.addItem(new Product("푸마 울트라 매치", "79,000" , "발볼 등급 : E", R.drawable.fuma3));
        adapter.addItem(new Product("푸마 울트라 2.1", "119,000" , "발볼 등급 : E", R.drawable.fuma4));
        adapter.addItem(new Product("푸마 울트라 1.4", "179,000" , "발볼 등급 : E", R.drawable.fuma5));
        adapter.addItem(new Product("푸마 울트라 1.3", "175,000" , "발볼 등급 : E", R.drawable.fuma6));
        adapter.addItem(new Product("푸마 울트라 2.3", "109,000" , "발볼 등급 : E", R.drawable.fuma7));
        adapter.addItem(new Product("푸마 울트라 1.2", "175,000" , "발볼 등급 : E", R.drawable.fuma8));
        adapter.addItem(new Product("푸마 울트라 2.2", "109,000" , "발볼 등급 : E", R.drawable.fuma9));
        adapter.addItem(new Product("푸마 울트라 3.2", "76,000" , "발볼 등급 : E", R.drawable.fuma10));
        adapter.addItem(new Product("푸마 퓨처Z 3.4", "84,000" , "발볼 등급 : C", R.drawable.fuma11));
        adapter.addItem(new Product("푸마 퓨처Z 1.4", "199,000" , "발볼 등급 : C", R.drawable.fuma12));
        adapter.addItem(new Product("푸마 퓨처Z 1.3", "199,000" , "발볼 등급 : C", R.drawable.fuma13));
        adapter.addItem(new Product("푸마 퓨처Z 1.2", "195,000" , "발볼 등급 : C", R.drawable.fuma14));
        adapter.addItem(new Product("푸마 퓨처 5.4", "49,000" , "발볼 등급 : C", R.drawable.fuma15));
        adapter.addItem(new Product("푸마 TACTO 2", "39,000" , "발볼 등급 : C", R.drawable.fuma16));
        adapter.addItem(new Product("푸마 킹 플래티넘", "167,000" , "발볼 등급 : C", R.drawable.fuma17));
        adapter.addItem(new Product("푸마 원 20.2", "119,000" , "발볼 등급 : D", R.drawable.fuma18));
        adapter.addItem(new Product("푸마 원 20.3", "79,000" , "발볼 등급 : D", R.drawable.fuma19));
        adapter.addItem(new Product("푸마 원 20.4", "49,000" , "발볼 등급 : D", R.drawable.fuma20));


        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Intent intent = new Intent(fumaActivity.this, detailActivity.class);

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
                Intent intent = new Intent(getApplicationContext(), lsmActivity.class);
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