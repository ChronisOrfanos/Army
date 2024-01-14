package com.example.maap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Kylikeio extends AppCompatActivity {


    EditText editTextOrder;
    Button btn_place_order;

    FirebaseDatabase db;
    DatabaseReference reference;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kylikeio);



        // Gia thn ypogrammish twn titlwn
        TextView textViewRofimata = findViewById(R.id.Rofimata);
        textViewRofimata.setPaintFlags(textViewRofimata.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        TextView textViewFagito = findViewById(R.id.Fagito);
        textViewFagito.setPaintFlags(textViewFagito.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        TextView textViewPsilika = findViewById(R.id.Psilika);
        textViewPsilika.setPaintFlags(textViewPsilika.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        // Telos Gia thn ypogrammish twn titlwn




//        editTextOrder = findViewById(R.id.edit_order);

        btn_place_order = findViewById(R.id.placeorder);
        btn_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btn_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextOrder = findViewById(R.id.edit_order);
                String Name = editTextOrder.getText().toString();



                if (!Name.isEmpty()){

                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Παραγγελίες Φαγητού");
                    reference.child(Name).setValue("ΣΤΡ(ΠΒ): "+ Name).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {


                            Toast.makeText(Kylikeio.this,"Successfuly Updated",Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        });

    }


}