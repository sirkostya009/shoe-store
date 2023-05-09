package ua.sirkostya009.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.sirkostya009.userservice.dto.RegistrationRequest;
import ua.sirkostya009.userservice.service.RegistrationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class RegistrationController {
    private final RegistrationService service;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegistrationRequest dto) {
        service.register(dto);
    }

    @GetMapping("/confirm")
    public void confirm(@RequestParam String token) {
        service.confirm(token);
    }
}
