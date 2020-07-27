package com.example.js.todolistapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddNew;
    TodoAdapter todoAdapter;
    ArrayList<MyTodos> list;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到控件
        btnAddNew = findViewById(R.id.btnAddNew);

        //设置布局管理器
        recyclerView = findViewById(R.id.recyclerview_todo);
        todoAdapter = new TodoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(todoAdapter);


        //点击按钮添加新的todo
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewTaskAct.class);
                startActivity(intent);
            }
        });

    }

    /**
     * RecyclerView的里面的数据需要刷新
     * 当再次返回到该Activity时程序会自动调用onResume()方法实现界面的数据显示刷新
     */
    @Override
    public void onResume() {

        super.onResume();
        getData();
    }

    /**
     * 从数据库获取数据并绑定适配器
     */
    public void getData() {
        // 从数据库获取数据
        DBHelper helper = new DBHelper(getApplicationContext());
        Cursor cursor = helper.query();
        cursor.moveToFirst();

        //创建数据集合
        list = new ArrayList<MyTodos>();

        String title, description, date;
        int id;
        while (cursor.moveToNext()) {
            title = cursor.getString(cursor.getColumnIndex("titletodo"));
            description = cursor.getString(cursor.getColumnIndex("desctodo"));
            date = cursor.getString(cursor.getColumnIndex("datetodo"));
            id = cursor.getInt(cursor.getColumnIndex("_id"));
            MyTodos todoData = new MyTodos(title, description, date, id);
            // 测试
            Log.d("MainActivity", "title" + title);
            Log.d("MainActivity", "description" + description);
            list.add(todoData);
        }

        //绑定adapter，传动态数组
        todoAdapter.setTodoList(MainActivity.this, list);
        Log.d("MainActivity", "the list size is:" + list.size());
        todoAdapter.notifyDataSetChanged();
    }
}










