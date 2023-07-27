package org.example;

import org.example.lesson22HW27DB_Java.service.LessonDao;
import org.example.lesson22HW27DB_Java.service.impl.DBServiceImpl;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Integer id;
        LessonDao lessonDao = new DBServiceImpl();

        do {
            System.out.println("Робота с БД:");
            System.out.println("1 - Додавання уроку");
            System.out.println("2 - Видалення уроку");
            System.out.println("3 - Отримати всі уроки");
            System.out.println("4 - Отримати урок по id");
            System.out.println("0 - exit");

            Integer num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 0:
                    System.exit(-1);
                case 1: {
                    System.out.println("---------- Додавання уроку ----------");
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter updatedAt ( format \"YYYY-MM-DD\"): ");
                    String updatedAtS = sc.nextLine();
                    LocalDate updatedAt = LocalDate.parse(updatedAtS);
                    System.out.println("Enter homework_id: ");
                    Integer homework_id = sc.nextInt();
                    lessonDao.addLesson(name, updatedAt, homework_id);
                    break;
                }
                case 2: {
                    System.out.println("---------- Видалення уроку ----------");
                    System.out.println("Enter id ");
                    id = sc.nextInt();
                    System.out.println("-----------------------");
                    lessonDao.deleteLesson(id);
                    break;
                }
                case 3: {
                    System.out.println("---------- Отримати всі уроки ----------");
                    lessonDao.getAllLesson().forEach(System.out::println);
                    break;
                }
                case 4: {
                    System.out.println("---------- Отримати урок по id ----------");
                    System.out.println("Enter id ");
                    id = sc.nextInt();
                    lessonDao.getLessonById(id).forEach(System.out::println);
                    break;
                }
                default:
                    System.out.println("Некоректне значення, поторіть.");
            }
        } while (true);
//        sc.close();
    }
}