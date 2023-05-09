package ua.sirkostya009.userservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties("rsa")
public record RSAKeys(
        RSAPublicKey publicKey,
        RSAPrivateKey privateKey
) {
}
