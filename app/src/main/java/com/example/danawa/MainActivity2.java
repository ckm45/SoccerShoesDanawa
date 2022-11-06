package com.example.danawa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity2<val> extends AppCompatActivity {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("추천 결과");
    private DatabaseReference ref=FirebaseDatabase.getInstance().getReference();
    private FirebaseStorage storage = FirebaseStorage.getInstance("gs://graduate-project-3c7b4.appspot.com/");
    private StorageReference storageRef = storage.getReference();
    private String uname,sim,sim2;
    private String uname1="feet1";
    TextView tv,recView,recView2;
    ImageView img_test,imageView2,imageView3,son;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.tv);
        recView = findViewById(R.id.recView);
        recView2 = findViewById(R.id.recView2);
        ImageView img_test = findViewById(R.id.img_test);
        ImageView imageView2= findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        son = findViewById(R.id.son);
        Glide.with(this).load(R.drawable.sonny).into(son);
        ref.child("cnt").setValue(0);

        reference.child("축구화 이름").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String soccer_value = dataSnapshot.getValue(String.class);
                uname = soccer_value;


//                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
//                String str = map.values().toString();

                tv.setText(uname);


                storageRef.child(uname+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //이미지 로드 성공시

                        Glide.with(getApplicationContext()).load(uri).into(img_test);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        //이미지 로드 실패시

                    }
                });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference.child("유사한 축구화1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String soccer_value2 =dataSnapshot.getValue(String.class);
                sim=soccer_value2;
                recView.setText(sim);

                storageRef.child(sim+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //이미지 로드 성공시

                        Glide.with(getApplicationContext()).load(uri).into(imageView2);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        //이미지 로드 실패시

                    }
                }); //유사 축구화 1
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference.child("유사한 축구화2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String soccer_value3 =dataSnapshot.getValue(String.class);
                sim2=soccer_value3;
                recView2.setText(sim2);

                storageRef.child(sim2+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //이미지 로드 성공시

                        Glide.with(getApplicationContext()).load(uri).into(imageView3);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        //이미지 로드 실패시

                    }
                }); //유사 축구화 2
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}


