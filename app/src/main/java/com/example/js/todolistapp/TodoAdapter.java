package com.example.js.todolistapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {
    private ArrayList<MyTodos> todoList = new ArrayList<>();    //初始化为空
    Context context;

    public TodoAdapter() {
        Log.d("TodoAdapter", "TodoAdapter无参构造方法……");
    }

    //获取列表信息
    public void setTodoList( Context context,ArrayList<MyTodos> todoList) {
        this.todoList = todoList;
        this.context = context;
    }

    /**
     * 用于创建事项的View:
     * 1. 拿到类
     * 2. 创建内部holder MyViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去的这个View其实就是事项的界面
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_todo, parent, false);
        return new MyViewHolder(itemView);
    }

    /**
     * 绑定holder，一般用来设置数据
     *
     * @param myViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final MyTodos myTodos = todoList.get(i);
        Log.d("TodoAdapter", "for now i is " + i);
        // 设置数据
        myViewHolder.titletodo.setText(myTodos.getTitleTodo());
        myViewHolder.desctodo.setText(myTodos.getDescTodo());
        myViewHolder.datetodo.setText(myTodos.getDateTodo());

        // 删除条目
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(context);
                dbHelper.del(myTodos.id);
                dbHelper.close();
                Toast.makeText(context, "Done A Todo Item.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    /**
     * 返回条目个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        Log.d("TodoAdapter", "size of todoList is:" + String.valueOf(todoList.size()));
        return todoList == null ? 0 : todoList.size();

    }

    //添加static防止数据泄露
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView titletodo;
        private TextView desctodo;
        private TextView datetodo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //找到条目控件
            titletodo = (TextView) itemView.findViewById(R.id.titledoes);
            desctodo= (TextView) itemView.findViewById(R.id.descdoes);
            datetodo= (TextView) itemView.findViewById(R.id.datedoes);
        }
    }

}