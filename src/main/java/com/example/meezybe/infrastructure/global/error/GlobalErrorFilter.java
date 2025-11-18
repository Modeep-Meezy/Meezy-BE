package com.example.meezybe.infrastructure.global.error;

import com.example.meezybe.infrastructure.global.error.exception.ErrorProperty;
import com.example.meezybe.infrastructure.global.error.exception.GlobalErrorCode;
import com.example.meezybe.infrastructure.global.error.exception.MeezyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class GlobalErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (MeezyException e) {
            writeErrorResponse(response, e.getErrorProperty());

        } catch (Exception e) {
            if (e.getCause() instanceof MeezyException meezyException) {
                writeErrorResponse(response, meezyException.getErrorProperty());
            } else {
                writeErrorResponse(response, GlobalErrorCode.INTERNAL_SERVER_ERROR);
            }
        }
    }

    private void writeErrorResponse(HttpServletResponse response, ErrorProperty errorProperty) throws IOException {
        response.setStatus(errorProperty.getStatus().value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ErrorResponse errorResponse = ErrorResponse.of(errorProperty);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
