package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.Controllers.CourseController;
import org.example.hexlet.Controllers.UserController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        Data.init();
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // Описываем, что загрузится по адресу /
        app.before(ctx -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String logDate = now.format(formatter);
            System.out.println("*** Время запроса: " + logDate + " ***");
        });
        app.get(NamedRoutes.mainPath(), ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("index.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.after(ctx -> {
            String body = ctx.result();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            assert body != null;
            byte[] hashBytes = md.digest(body.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            String sha256Hex = sb.toString();
            System.out.println(sha256Hex);
            ctx.header("X-Response_Digest", sha256Hex);

        });
        app.get(NamedRoutes.coursesPath(), CourseController::index);
        app.get(NamedRoutes.buildCoursePath(), CourseController::build);
        app.get(NamedRoutes.coursePath("{id}"), CourseController::show);
        app.post(NamedRoutes.coursesPath(), CourseController::create);


        // Юзеры
        app.get(NamedRoutes.usersPath(), UserController::index);
        app.get(NamedRoutes.buildUserPath(), UserController::build);
        app.get(NamedRoutes.userPath("{id}"), UserController::show);
        app.post(NamedRoutes.usersPath(), UserController::create);
        app.get(NamedRoutes.editUserPath("{id}"), UserController::edit);
        app.post(NamedRoutes.userPath("{id}"), UserController::update);
        app.get(NamedRoutes.deleteUserPath("{id}"), UserController::destroy);


        app.start(7070); // Стартуем веб-сервер
    }

}
