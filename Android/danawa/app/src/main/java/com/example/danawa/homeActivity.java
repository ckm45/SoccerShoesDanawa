package com.example.danawa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class homeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button imageButton = (Button) findViewById(R.id.all_product);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), lsmActivity.class);
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
                Intent intent = new Intent(getApplicationContext(), mizActivity.class);
                startActivity(intent);
            }
        });

        Button imageButton6 = (Button) findViewById(R.id.recommend_product);
        imageButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        Button imageButton7 = (Button) findViewById(R.id.article_button1);
        imageButton7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sports.news.naver.com/news?oid=425&aid=0000134366"));
                startActivity(intent);
            }
        });

        Button imageButton8 = (Button) findViewById(R.id.article_button2);
        imageButton8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sports.news.naver.com/news?oid=108&aid=0003105509"));
                startActivity(intent);
            }
        });

        Button imageButton9 = (Button) findViewById(R.id.article_button3);
        imageButton9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sports.naver.com/news?oid=450&aid=0000088923"));
                startActivity(intent);
            }
        });

        Button imageButton10 = (Button) findViewById(R.id.article_button4);
        imageButton10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sports.naver.com/news?oid=139&aid=0002175299"));
                startActivity(intent);
            }
        });

        Button imageButton11 = (Button) findViewById(R.id.article_button5);
        imageButton11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://about.nike.com/en/newsroom/collections/nike-football-boots"));
                startActivity(intent);
            }
        });

        Button imageButton12 = (Button) findViewById(R.id.article_button6);
        imageButton12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://about.nike.com/en/newsroom/releases/nike-air-zoom-mercurial-official-images-release-date"));
                startActivity(intent);
            }
        });
        LinearLayout recLayout1 = (LinearLayout) findViewById(R.id.rec_first);
        recLayout1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, detailActivity.class);

                intent.putExtra("pro_name", "아디다스 프레데터 엣지.1");
                intent.putExtra("pro_cost", "299,000");
                intent.putExtra("pro_level", "사이즈 등급 : C");
                intent.putExtra("pro_pic", R.drawable.adi5);

                startActivity(intent);
            }
        });

        LinearLayout recLayout2 = (LinearLayout) findViewById(R.id.rec_two);
        recLayout2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, detailActivity.class);

                intent.putExtra("pro_name", "나이키 팬텀 GT2 아카데미 FLYEASE FG");
                intent.putExtra("pro_cost", "99,000");
                intent.putExtra("pro_level", "사이즈 등급 : C");
                intent.putExtra("pro_pic", R.drawable.nike5);

                startActivity(intent);
            }
        });

        LinearLayout recLayout3 = (LinearLayout) findViewById(R.id.rec_three);
        recLayout3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, detailActivity.class);

                intent.putExtra("pro_name", "나이키 머큐리얼 수퍼플라이 8 엘리트 FG");
                intent.putExtra("pro_cost", "309,000");
                intent.putExtra("pro_level", "사이즈 등급 : A");
                intent.putExtra("pro_pic", R.drawable.nike37);

                startActivity(intent);
            }
        });

        LinearLayout recLayout4 = (LinearLayout) findViewById(R.id.rec_four);
        recLayout4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, detailActivity.class);

                intent.putExtra("pro_name", "미즈노 웨이브컵 레전드");
                intent.putExtra("pro_cost", "219,000");
                intent.putExtra("pro_level", "사이즈 등급 : E");
                intent.putExtra("pro_pic", R.drawable.miz10);

                startActivity(intent);
            }
        });

    }

}