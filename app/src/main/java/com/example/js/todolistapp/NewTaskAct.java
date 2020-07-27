package com.example.js.todolistapp;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewTaskAct extends AppCompatActivity {

    Button btnSaveTask, btnCancel;
    EditText et_title, et_desc, et_date;
    String title, desc, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        et_title = findViewById(R.id.titletodo);
        et_date = findViewById(R.id.datetodo);
        et_desc = findViewById(R.id.desctodo);
        btnSaveTask = (Button) findViewById(R.id.btnSaveTask);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        insertToSQLite();
    }

    /**
     * 添加条目到SQLite数据库
     */
    public void insertToSQLite() {
        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = et_title.getText().toString();
                desc = et_desc.getText().toString();
                date = et_date.getText().toString();
                System.out.println("获取结果：" + title + desc + date);
                // insert data
                ContentValues values = new ContentValues();
                values.put("titletodo", title);
                values.put("desctodo", desc);
                values.put("datetodo", date);

                // initialize database
                DBHelper helper = new DBHelper(getApplicationContext());
                helper.insert(values);
                helper.close();


                // finish this activity and back to the index page
//                Intent intent = new Intent(NewTaskAct.this,MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        //cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back to the former page
                finish();
            }
        });
    }
}



