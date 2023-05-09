package ua.sirkostya009.userservice.service;

import ua.sirkostya009.userservice.dto.RegistrationRequest;

public interface RegistrationService {
    void register(RegistrationRequest dto);

    void confirm(String token);
}
