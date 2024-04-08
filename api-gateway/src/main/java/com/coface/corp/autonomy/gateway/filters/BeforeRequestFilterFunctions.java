package com.coface.corp.autonomy.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.function.ServerRequest;
import java.util.function.Function;

@Slf4j
public abstract class BeforeRequestFilterFunctions {
    private final static String X_AUTH_TOKEN = "X-Auth-Token";
    public static Function<ServerRequest, ServerRequest> addRequestCookieHeader() {
        return (request) -> {
            String cookieValue = request.session().getId();
            log.debug("Cookie value : {}", cookieValue);
            return ServerRequest.from(request).header(X_AUTH_TOKEN, cookieValue).build();
        };
    }

}
