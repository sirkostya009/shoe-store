package ua.sirkostya009.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sirkostya009.userservice.dto.AuthenticationRequest;
import ua.sirkostya009.userservice.dto.UserDto;
import ua.sirkostya009.userservice.service.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/authenticate")
    public UserDto login(@RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }
}
