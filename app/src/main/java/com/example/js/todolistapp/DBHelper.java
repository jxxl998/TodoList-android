package com.example.js.todolistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "todo.db";
    private static final String TBL_NAME = "todoList";
    //创建表的语句
    private static final String CREATE_TBL = "CREATE TABLE todoList(_id integer " +
            "primary key autoincrement,titletodo TEXT,desctodo TEXT,datetodo TEXT)";
    private SQLiteDatabase db;

    // 构造函数
    public DBHelper(Context context){
        super(context,DB_NAME,null,2);
        System.out.printf("数据库初始化……\n");
    }


    //create table
    public void onCreate(SQLiteDatabase db){
        this.db = db;
        db.execSQL(CREATE_TBL);
        System.out.printf("创表成功！\n");
    }

    // insert
    public void insert(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TBL_NAME, null,values);
        db.close();
        System.out.printf("执行数据库插入操作\n");
    }

    // query
    public Cursor query(){
        System.out.printf("执行数据库查询操作\n");
        SQLiteDatabase db=getWritableDatabase();
        Cursor c = db.query(TBL_NAME, null, null, null, null, null, null);
        return c;
    }

    // delete
    public void del(int id){
        System.out.printf("执行数据库删除方法\n");
        if(db == null){
            SQLiteDatabase db = getWritableDatabase();
            db.delete(TBL_NAME, "_id=?", new String[]{String.valueOf(id)});
        }
    }

    // close
    public void close(){
        System.out.printf("关闭数据库\n");
        if(db != null){
            db.close();
        }
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
    }

}
