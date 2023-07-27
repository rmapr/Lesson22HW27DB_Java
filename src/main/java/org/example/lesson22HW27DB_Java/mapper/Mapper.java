package org.example.lesson22HW27DB_Java.mapper;

import org.example.lesson22HW27DB_Java.entity.Lesson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

public static List<Lesson> getAllLesson(ResultSet resultSet) throws SQLException {
    List<Lesson> lessons = new ArrayList<>();
    while (resultSet.next()) {
        lessons.add(new Lesson()
                .setId(resultSet.getInt(1))
                .setName(resultSet.getString("name"))
                .setUpdatedAt(resultSet.getDate("updatedAt"))
                .setHomework_id(resultSet.getInt("homework_id"))
        );
    }
    return lessons;

}
}
