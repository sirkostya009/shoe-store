package ua.sirkostya009.userservice.dao;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    /**
     * Перегляд публічної інформації
     */
    VIEW_PUBLIC,
    /**
     * Додавати коментарі
     */
    ADD_COMMENTS;

    public interface Presets {
        Set<Role> STANDARD_USER = Set.of(VIEW_PUBLIC, ADD_COMMENTS);

        Set<Role> SUPER_USER = Arrays.stream(Role.values()).collect(Collectors.toSet());
    }
}
