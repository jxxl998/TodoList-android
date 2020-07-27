package com.example.js.todolistapp;

public class MyTodos {

    String titleTodo;   //标题
    String dateTodo;    //描述
    String descTodo;    //时间点
    int id;     //序号


    public MyTodos() {
    }

    public MyTodos(String titleTodo, String descTodo, String dateTodo, int id) {
        this.titleTodo = titleTodo;
        this.descTodo = descTodo;
        this.dateTodo = dateTodo;
        this.id = id;
    }

    public String getTitleTodo() {
        return titleTodo;
    }

    public void setTitleTodo(String titleTodo) {
        this.titleTodo = titleTodo;
    }

    public String getDateTodo() {
        return dateTodo;
    }

    public void setDateTodo(String dateTodo) {
        this.dateTodo = dateTodo;
    }

    public String getDescTodo() {
        return descTodo;
    }

    public void setDescTodo(String descTodo) {
        this.descTodo = descTodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
