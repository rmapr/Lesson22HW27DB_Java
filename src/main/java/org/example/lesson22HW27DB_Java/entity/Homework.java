package org.example.lesson22HW27DB_Java.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Homework {
    private Integer id;
    private String name;
    private String description;

}
