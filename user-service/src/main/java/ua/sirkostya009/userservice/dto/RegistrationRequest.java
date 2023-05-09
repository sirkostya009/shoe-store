package ua.sirkostya009.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ua.sirkostya009.userservice.constraint.EmailAddress;

public record RegistrationRequest(
        @NotNull
        @NotBlank
        String name,
        @EmailAddress
        String email,
        @Size(min = 3)
        @NotNull
        String username,
        @Size(min = 8)
        @NotNull
        String password
) {
}
