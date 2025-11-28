package org.example.hexlet;

import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

public class Data {
    public static void init() {
        List<Course> coursesList = new LinkedList<>();
        var course1 = new Course("Java", "Курс джава от нуля до джуна");
        var course2 = new Course("Phyton", "Курс пайтон от нуля до джуна");
        var course3 = new Course("SQL", "Курс базы данных от нуля до джуна");
        var course4 = new Course("PHP", "Бэкэнд разработчик на php от нуля до джуна");
        var course5 = new Course("JavaScript","Фронтенд разработчик на javascript от нуля до джуна");
        var course6 = new Course("Опять Java", "Курс джава от нуля до джуна");
        var course7 = new Course("Phyton", "Курс пайтон от нуля до джуна");
        var course8 = new Course("SQL", "Курс базы данных от нуля до джуна");
        var course9 = new Course("PHP", "Бэкэнд разработчик на php от нуля до джуна");
        var course10 = new Course("JavaScript","Фронтенд разработчик на javascript от нуля до джуна");
        var course11 = new Course("Go", "Курс гоу от нуля до джуна");
        var course12 = new Course("Базы данных", "Курс базы данных от нуля до джуна");
        var course13 = new Course("PHP", "Бэкэнд разработчик на php от нуля до джуна");
        var course14 = new Course("JavaScript","Фронтенд разработчик на javascript от нуля до джуна");

        CourseRepository.save(course1);
        CourseRepository.save(course2);
        CourseRepository.save(course3);
        CourseRepository.save(course4);
        CourseRepository.save(course5);
        CourseRepository.save(course6);
        CourseRepository.save(course7);
        CourseRepository.save(course8);
        CourseRepository.save(course9);
        CourseRepository.save(course10);
        CourseRepository.save(course11);
        CourseRepository.save(course12);
        CourseRepository.save(course13);
        CourseRepository.save(course14);

        var user1 = new User("Dima", "dimarik79rus@gamil.com", "1234");
        var user2 = new User("Vova", "vova@gamil.com", "1234");
        var user3 = new User("Xron", "xron@gamil.com", "1234");
        var user4 = new User("Dron", "dron@gamil.com", "1234");
        UserRepository.save(user1);
        UserRepository.save(user2);
        UserRepository.save(user3);
        UserRepository.save(user4);
    }
}
