package ua.sirkostya009.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Filter that logs all incoming requests
 */
@Slf4j
@Component
public class LoggingFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Forwarding request " + toString(exchange.getRequest()));

        return chain.filter(exchange);
    }

    private String toString(ServerHttpRequest request) {
        return ("ServerHttpRequest(" +
                "id: %s, " +
                "cookies: %s, " +
                "queryParams: %s, " +
                "localAddress: %s, " +
                "remoteAddress: %s, " +
                "headers: %s, " +
                "path: %s, " +
                "sslInfo: %s)")
                .formatted(
                        request.getId(),
                        request.getCookies(),
                        request.getQueryParams(),
                        request.getLocalAddress(),
                        request.getRemoteAddress(),
                        request.getHeaders(),
                        request.getPath(),
                        request.getSslInfo()
                );
    }
}
