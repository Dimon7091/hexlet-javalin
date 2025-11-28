package org.example.hexlet.Controllers;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CourseController {
    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        String searchTerm = (term != null) ? term.trim().toLowerCase() : "";

        var pageStr = ctx.queryParam("page");
        int currentPage = (pageStr != null) ? Integer.parseInt(pageStr) : 1;  // Если pageStr null, то page = 1
        if (currentPage < 1) currentPage = 1;
        var pageSize = 5;
        var totalCourses = CourseRepository.getEntities().size();
        var totalPages = (int) Math.ceil((double) totalCourses / pageSize);

        List<Course> courses = CourseRepository.findAll(currentPage, pageSize);
        if (!searchTerm.isEmpty()) {
            courses = CourseRepository.findAll(currentPage, pageSize).stream()
                    .filter(c -> c.getName().toLowerCase().startsWith(term.toLowerCase()))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        var page = new CoursesPage(courses, term, currentPage, totalPages);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id).get();
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
        System.out.println(course.getName());
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = "";
        var description = "";

        try {
            name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Название должно быть больше двух символов")
                    .check(value -> !CourseRepository.existsByName(value),
                            "Такое название курса уже существует")
                    .get();
            description = ctx.formParamAsClass("description", String.class).
                    check(value -> value.trim().length() > 10, "Описание должно быть больше десяти символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        } catch (ValidationException e) {
            ctx.status(422);
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}
