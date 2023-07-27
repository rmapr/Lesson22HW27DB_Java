package org.example.lesson22HW27DB_Java.service.impl;

import org.example.lesson22HW27DB_Java.dbQuery.DBQuery;
import org.example.lesson22HW27DB_Java.entity.Lesson;
import org.example.lesson22HW27DB_Java.service.LessonDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DBServiceImpl implements LessonDao {
    @Override
    public void addLesson(String name, LocalDate updatedAt, Integer homework_id) throws SQLException {
        DBQuery dbQuery = new DBQuery();
        dbQuery.addLesson(name, updatedAt, homework_id);
    }

    @Override
    public void deleteLesson(Integer id) throws SQLException {
        DBQuery dbQuery = new DBQuery();
        dbQuery.deleteLesson(id);
    }

    @Override
    public List<Lesson> getAllLesson() throws SQLException {
        DBQuery dbQuery = new DBQuery();
        return dbQuery.getAllLesson();
    }

    @Override
    public List<Lesson> getLessonById(Integer id) throws SQLException {
        DBQuery dbQuery = new DBQuery();
        return dbQuery.getLessonById(id);
    }
}
