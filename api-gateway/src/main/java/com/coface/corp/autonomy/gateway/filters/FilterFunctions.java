package com.coface.corp.autonomy.gateway.filters;

import org.springframework.cloud.gateway.server.mvc.common.Shortcut;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static org.springframework.web.servlet.function.HandlerFilterFunction.ofRequestProcessor;

/**
 * This filter must be declared in the spring.factories file
 */
public interface FilterFunctions {
    @Shortcut
    static HandlerFilterFunction<ServerResponse, ServerResponse> addRequestCookieHeader() {
        return ofRequestProcessor(BeforeRequestFilterFunctions.addRequestCookieHeader());
    }

    class FilterSupplier implements org.springframework.cloud.gateway.server.mvc.filter.FilterSupplier {
        @Override
        public Collection<Method> get() {
            return Arrays.asList(FilterFunctions.class.getMethods());
        }

    }
}
