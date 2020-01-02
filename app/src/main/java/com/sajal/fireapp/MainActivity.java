package com.sajal.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText,editText2;
    private Button button;
    private FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        firebaseDatabase= FirebaseDatabase.getInstance();

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatabaseReference myRef = firebaseDatabase.getReference("Name");
//                myRef.setValue("Sajal");
//
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DatabaseReference myRef = firebaseDatabase.getReference(editText2.getText().toString());
                DatabaseReference myRef = firebaseDatabase.getReference("User");
                DatabaseReference myRefChild= myRef.child(editText2.getText().toString());
//                myRef.setValue("Name");
//                DatabaseReference myRefChild = firebaseDatabase.getReference("https://fireapp-ed027.firebaseio.com/User/Name");
                String value = editText.getText().toString();
//                myRef.push().setValue(value);
                myRefChild.setValue(value);

            }
        });
    }
}
