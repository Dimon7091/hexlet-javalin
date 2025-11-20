package org.example.hexlet.Repository;

import lombok.Getter;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter

public class UserRepository {
    private static List<User> entities = new ArrayList<>();

    public static void save(User course) {
        // Формируется идентификатор
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<User> search(String term) {
        var courses = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return courses;
    }

    public static Optional<User> find(Long id) {
        var user = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
        return user;
    }
    public static List<User> getEntities() {
        return entities;
    }
}

