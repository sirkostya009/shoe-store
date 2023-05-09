package ua.sirkostya009.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.sirkostya009.userservice.dao.Role;
import ua.sirkostya009.userservice.dao.User;
import ua.sirkostya009.userservice.dto.RegistrationRequest;
import ua.sirkostya009.userservice.exception.RegistrationException;
import ua.sirkostya009.userservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public void register(RegistrationRequest dto) {
        if (repository.findByUsername(dto.username()).isPresent())
            throw new RegistrationException("Username already taken");

        repository.save(User.builder()
                .name(dto.name())
                .email(dto.email())
                .username(dto.username())
                .password(encoder.encode(dto.password()))
                .roles(Role.Presets.STANDARD_USER)
                .build());
    }

    @Override
    public void confirm(String token) {
        // TODO: implement confirmation: ConfirmationToken, isEnabled in User, etc.
    }
}
