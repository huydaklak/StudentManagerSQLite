package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ClassActivity extends AppCompatActivity {
    private EditText edCodeClass;
    private EditText edClassName;
    private Button btnAdd;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnBack;
    private RecyclerView rcvClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_class);

        edCodeClass = findViewById(R.id.ed_class_code);
        edClassName = findViewById(R.id.ed_class_name);
        btnAdd = findViewById(R.id.btn_add_class);
        btnUpdate = findViewById(R.id.btn_update_class);
        btnDelete = findViewById(R.id.btn_delete_class);
        btnBack = findViewById(R.id.btn_back_class);
        rcvClass = findViewById(R.id.rcv_class);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}