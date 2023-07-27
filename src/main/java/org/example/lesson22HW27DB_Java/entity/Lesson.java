package org.example.lesson22HW27DB_Java.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
@ToString

public class Lesson {
    private Integer id;
    private String name;
    private Date updatedAt;
    private Integer homework_id;
}
