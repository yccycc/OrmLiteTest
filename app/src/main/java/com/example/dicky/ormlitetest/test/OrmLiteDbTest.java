package com.example.dicky.ormlitetest.test;

import android.test.AndroidTestCase;

import com.example.dicky.ormlitetest.bean.Article;
import com.example.dicky.ormlitetest.bean.Student;
import com.example.dicky.ormlitetest.bean.User;
import com.example.dicky.ormlitetest.db.ArticleDao;
import com.example.dicky.ormlitetest.db.DatabaseHelper;
import com.example.dicky.ormlitetest.db.UserDao;
import com.example.dicky.ormlitetest.utils.L;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class OrmLiteDbTest extends AndroidTestCase {
    public void testAddArticle() {
        User u = new User();
        u.setName("张鸿洋");
        new UserDao(getContext()).add(u);
        Article article = new Article();
        article.setTitle("ORMLite的使用");
        article.setUser(u);
        new ArticleDao(getContext()).add(article);

    }

    public void testGetArticleById() {
        Article article = new ArticleDao(getContext()).get(1);
        L.e(article.getUser() + " , " + article.getTitle());
    }

    public void testGetArticleWithUser() {

        Article article = new ArticleDao(getContext()).getArticleWithUser(1);
        L.e(article.getUser() + " , " + article.getTitle());
    }

    public void testListArticlesByUserId() {

        List<Article> articles = new ArticleDao(getContext()).listByUserId(1);
        L.e(articles.toString());
    }

    public void testGetUserById() {
        User user = new UserDao(getContext()).get(1);
        L.e(user.getName());
        if (user.getArticles() != null)
            for (Article article : user.getArticles()) {
                L.e(article.toString());
            }
    }

    public void testAddStudent() throws SQLException {
        Dao dao = DatabaseHelper.getHelper(getContext()).getDao(Student.class);
        Student student = new Student();
        student.setDao(dao);
        student.setName("张鸿洋");
        student.create();
    }


}
