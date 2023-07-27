package org.example.lesson22HW27DB_Java.service;
//6.    Реалізувати клас LessonDao
//  a.  метод додавання уроку
//  b.  метод видалення уроку
//  c.  метод отримання всіх уроків
//  d.  метод отримання уроку за ID

import org.example.lesson22HW27DB_Java.entity.Lesson;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

//7.    Клас LessonDao взаємодіє з БД і повертає об'єкти типу Lesson
public interface LessonDao {
    void addLesson(String name, LocalDate updatedAt, Integer homework_id) throws SQLException;
    List<Lesson> deleteLesson(Integer id) throws SQLException;
    List<Lesson> getAllLesson() throws SQLException;
    List<Lesson> getLessonById(Integer id) throws SQLException;
}
