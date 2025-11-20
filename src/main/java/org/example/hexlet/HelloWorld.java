package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.Repository.CourseRepository;
import org.example.hexlet.Repository.UserRepository;
import org.example.hexlet.dto.CoursePage;
import org.example.hexlet.dto.CoursesPage;
import org.example.hexlet.dto.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import java.util.*;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        List<Course> coursesList = new LinkedList<>();
        var course1 = new Course("Java", "Курс джава от нуля до джуна");
        var course2 = new Course("Phyton", "Курс пайтон от нуля до джуна");
        var course3 = new Course("SQL", "Курс базы данных от нуля до джуна");
        var course4 = new Course("PHP", "Бэкэнд разработчик на php от нуля до джуна");
        var course5 = new Course("JavaScript","Фронтенд разработчик на javascript от нуля до джуна");

        CourseRepository.save(course1);
        CourseRepository.save(course2);
        CourseRepository.save(course3);
        CourseRepository.save(course4);
        CourseRepository.save(course5);

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            String searchTerm = (term != null) ? term.trim().toLowerCase() : "";
            ArrayList<Course> courses;
            if (!searchTerm.isEmpty()) {
                courses = CourseRepository.getEntities().stream()
                        .filter(c -> c.getName().toLowerCase().startsWith(term.toLowerCase()))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {
                courses = new ArrayList<>(CourseRepository.getEntities());
            }
            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });

        app.get("/courses/{id}", ctx -> {
            var id = Long.getLong("id");
            var course = CourseRepository.find(id);
            var page = new CoursePage(course.get());
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.get("/users", ctx -> {
            var users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));

        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.start(7070); // Стартуем веб-сервер
    }

}
