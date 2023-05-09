package ua.sirkostya009.userservice.dto;

import ua.sirkostya009.userservice.dao.User;

public record UserDto(
        String username,
        String name,
        String jwt
) {
    public static UserDto from(User user, String jwt) {
        return new UserDto(
                user.getUsername(),
                user.getName(),
                jwt
        );
    }
}
