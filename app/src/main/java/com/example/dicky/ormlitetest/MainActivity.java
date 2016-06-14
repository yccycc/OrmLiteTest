package com.example.dicky.ormlitetest;

import android.app.Activity;
import android.os.Bundle;

import com.example.dicky.ormlitetest.bean.Book;
import com.example.dicky.ormlitetest.bean.Student;
import com.example.dicky.ormlitetest.db.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper databaseHelper = DatabaseHelper.getHelper(this);
        try {
            Student student = new Student();
            student.setName("ycc3");
            Collection<Book> books = new ArrayList<>();
            Book book = new Book();
            book.setBookName("dierben1");
            books.add(book);
            student.setBooks(books);
            databaseHelper.getDao(Student.class).create(student);
            book.setStudent(student);
            databaseHelper.getDao(Book.class).create(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
