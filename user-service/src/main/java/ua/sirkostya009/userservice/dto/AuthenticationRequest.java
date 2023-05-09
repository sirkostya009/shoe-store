package ua.sirkostya009.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationRequest(
        @NotBlank
        String login,
        @NotBlank
        @Size(min = 8)
        String password
) {
}
