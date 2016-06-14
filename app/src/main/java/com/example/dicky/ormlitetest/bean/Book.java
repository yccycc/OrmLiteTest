package com.example.dicky.ormlitetest.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_book")
public class Book {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = true, foreign = true, columnName = "stu_id", foreignAutoRefresh = true)
    private Student student;

    @DatabaseField
    private String bookName = "shum";

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
