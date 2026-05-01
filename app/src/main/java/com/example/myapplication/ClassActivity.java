package com.example.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ClassAdapter;
import com.example.myapplication.database.DBHelper;
import com.example.myapplication.database.DbContract;
import com.example.myapplication.model.ClassModel;

import java.util.List;

public class ClassActivity extends AppCompatActivity {
    private EditText edCodeClass;
    private EditText edClassName;
    private Button btnAdd;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnBack;
    private RecyclerView rcvClass;
    private List<ClassModel> classModelList;
    private ClassAdapter classAdapter;
    private DBHelper dbHelper;

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

        dbHelper = new DBHelper(this);
        classModelList = dbHelper.getAllClass();

        classAdapter = new ClassAdapter(classModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvClass.setLayoutManager(linearLayoutManager);
        rcvClass.setAdapter(classAdapter);


        btnAdd.setOnClickListener(v -> {
            String codeClass = edCodeClass.getText().toString();
            String className = edClassName.getText().toString();

            if(codeClass.isEmpty()){
                Toast.makeText(this, "Nhập code lớp đầy đủ", Toast.LENGTH_LONG).show();
            }
            if(className.isEmpty()){
                Toast.makeText(this, "Nhập tên lớp đầy đủ", Toast.LENGTH_LONG).show();
            }

            ContentValues contentValues = new ContentValues();
            contentValues.put(DbContract.CLASS_CODE, codeClass);
            contentValues.put(DbContract.CLASS_NAME, className);

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            long result = db.insert(DbContract.TABLE_CLASS, null, contentValues);

            if (result == -1){
                Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }

            reloadData();
            edCodeClass.setText("");
            edClassName.setText("");
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void reloadData() {
        classModelList.clear();
        classModelList.addAll(dbHelper.getAllClass());
        classAdapter.notifyDataSetChanged();
    }
}