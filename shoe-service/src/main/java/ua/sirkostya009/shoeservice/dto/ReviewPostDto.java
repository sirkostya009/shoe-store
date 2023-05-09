package ua.sirkostya009.shoeservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ReviewPostDto(
        @PositiveOrZero
        @Max(5)
        Integer rating,
        @NotBlank
        @NotNull
        String text
) {
}
