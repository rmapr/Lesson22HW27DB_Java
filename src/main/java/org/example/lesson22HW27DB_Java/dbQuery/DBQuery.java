package org.example.lesson22HW27DB_Java.dbQuery;

import org.example.lesson22HW27DB_Java.connection.DataBaseConnection;
import org.example.lesson22HW27DB_Java.entity.Lesson;
import org.example.lesson22HW27DB_Java.mapper.Mapper;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class DBQuery {
    private final String SQL_INSERT_LESSON = "insert into lesson22hw27.lesson (name, updatedAt, homework_id) value (?, ?, ?);";
    private final String SQL_DELETE_LESSON = "delete from lesson where id = %d;";
    private final String SQL_SELECT_ALL_LESSON = "select * from lesson22hw27.lesson order by id;";
    private final String SQL_SELECT_LESSON_BY_ID = "select * from lesson22hw27.lesson where id = '%s';";

    public void addLesson(String name, LocalDate updatedAt, Integer homework_id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_LESSON);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, String.valueOf(updatedAt));
        preparedStatement.setString(3, String.valueOf(homework_id));
        try {
            preparedStatement.executeUpdate();
            System.out.println("Урок добавлений.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Foreign key constraint fails. Index " + homework_id + " missing in table Homework!!!");
        }
        DataBaseConnection.close(connection);
    }

    public List<Lesson> getAllLesson() throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_LESSON);
        List<Lesson> result = Mapper.getAllLesson(resultSet);
        DataBaseConnection.close(connection);
        return result;
    }

    public List<Lesson> getLessonById(Integer id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format(SQL_SELECT_LESSON_BY_ID, id));
        List<Lesson> result = Mapper.getAllLesson(resultSet);
        if (result.isEmpty()) {
            System.out.println("Index " + id + " missing!");
        }
        DataBaseConnection.close(connection);
        return result;
    }
    public void deleteLesson(Integer id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
//        Перевірка чи є такий індекс
        ResultSet resultSet;
        resultSet = statement.executeQuery(String.format(SQL_SELECT_LESSON_BY_ID, id));
        List<Lesson> result = Mapper.getAllLesson(resultSet);
        if (result.isEmpty()) {
            System.out.println("Index " + id + " missing!");
        }else {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(SQL_DELETE_LESSON, id));
            preparedStatement.execute();
            System.out.println("Урок з індексом N: " + id + " був видалений.");
        }
        DataBaseConnection.close(connection);
    }
}
