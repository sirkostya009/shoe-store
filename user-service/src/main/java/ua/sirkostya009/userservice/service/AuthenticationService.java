package ua.sirkostya009.userservice.service;

import ua.sirkostya009.userservice.dto.AuthenticationRequest;
import ua.sirkostya009.userservice.dto.UserDto;

public interface AuthenticationService {
    /**
     * Confirms if user exists, enabled, and generates a JWT with following claims:
     * issue date, expiration date, user id.
     */
    UserDto authenticate(AuthenticationRequest request);
}
