package org.example.hexlet.repository;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class CourseRepository {
    // Тип зависит от того, с какой сущностью идет работа в упражнении
    private static List<Course> entities = new ArrayList<Course>();

    public static void save(Course course) {
        // Формируется идентификатор
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        var courses = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return courses;
    }

    public static Optional<Course> find(Long id) {
        var course = entities.stream()
                .filter(entity -> Objects.equals(entity.getId(), id))
                .findAny();
        return course;
    }

    public static List<Course> findAll(int pageNumber, int pageSize) {
        var begin = (pageNumber - 1) * pageSize;
        var end = begin + pageSize;

        return entities.stream().skip(begin).limit(end - begin).toList();
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(course -> course.getName().equalsIgnoreCase(name));
    }

    public static List<Course> getEntities() {
        return entities;
    }
}