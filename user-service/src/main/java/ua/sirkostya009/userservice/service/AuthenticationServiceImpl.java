package ua.sirkostya009.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import ua.sirkostya009.userservice.dto.AuthenticationRequest;
import ua.sirkostya009.userservice.dto.UserDto;
import ua.sirkostya009.userservice.exception.AuthenticationException;
import ua.sirkostya009.userservice.repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    @Override
    public UserDto authenticate(AuthenticationRequest request) {
        var user = repository.findByUsername(request.login())
                .orElseThrow(() -> new AuthenticationException("User does not exist"));

        if (!passwordEncoder.matches(request.password(), user.getPassword()))
            throw new AuthenticationException("Password does not match");

        var jwt = jwtEncoder.encode(
                JwtEncoderParameters.from(
                        JwtClaimsSet.builder()
                                .expiresAt(Instant.now().plus(7, ChronoUnit.DAYS))
                                .issuedAt(Instant.now())
                                .subject(user.getUsername())
                                .claim("scp", user.getRoles())
                                .claim("uid", user.getId())
                                .build()
                )
        ).getTokenValue();

        return UserDto.from(user, jwt);
    }
}
