package com.example.danawa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroup1,radioGroup2,radioGroup3;
    private RadioButton radio_button;
    private Button btn_save;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private EditText price;

    private String strfield1;
    private String strfield2;
    private String strfield3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radio_group1);
        radioGroup2 = findViewById(R.id.radio_group2);
        radioGroup3 = findViewById(R.id.radio_group3);
        price = findViewById(R.id.edittext_price);
        btn_save = findViewById(R.id.btn_save);



        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup1, int i) {

                radio_button=radioGroup1.findViewById(i);

                switch (i) {
                    case R.id.radio_button_ag:
                        strfield1=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_fg:
                        strfield1=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_hg:
                        strfield1=radio_button.getText().toString();
                        break;

                    default:
                }

            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup2, int j) {

                radio_button=radioGroup2.findViewById(j);

                switch (j) {
                    case R.id.radio_button_fw:
                        strfield2=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_mf:
                        strfield2=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_df:
                        strfield2=radio_button.getText().toString();
                        break;

                    default:
                }

            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup3, int k) {

                radio_button=radioGroup3.findViewById(k);

                switch (k) {
                    case R.id.radio_button_a:
                        strfield3=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_b:
                        strfield3=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_c:
                        strfield3=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_d:
                        strfield3=radio_button.getText().toString();
                        break;
                    case R.id.radio_button_e:
                        strfield3=radio_button.getText().toString();
                        break;

                    default:
                }

            }
        });


        reference = database.getInstance().getReference().child("설문조사");


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("사용용도").setValue(strfield1);
                reference.child("포지션").setValue(strfield2);
                reference.child("무게").setValue(strfield3);
                reference.child("가격").setValue(price.getText().toString());

                Intent intent = new Intent(getApplicationContext(),PhotoActivity.class);
                startActivity(intent);

            }

        });
    }
}