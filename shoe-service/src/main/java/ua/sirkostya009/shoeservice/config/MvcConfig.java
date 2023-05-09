package ua.sirkostya009.shoeservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ua.sirkostya009.shoeservice.resolver.UserIdResolver;
import ua.sirkostya009.shoeservice.resolver.UsernameResolver;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    private final UserIdResolver userIdResolver;
    private final UsernameResolver usernameResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userIdResolver);
        resolvers.add(usernameResolver);
    }
}
