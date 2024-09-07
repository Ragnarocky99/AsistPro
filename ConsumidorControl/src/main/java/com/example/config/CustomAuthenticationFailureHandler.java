package com.example.config;

import com.example.model.LoginAttempt;
import com.example.repository.LoginAttemptRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private LoginAttemptRepository loginAttemptRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        LoginAttempt loginAttempt = new LoginAttempt();
        loginAttempt.setEmail(request.getParameter("username"));
        loginAttempt.setTimestamp(new Date());
        loginAttempt.setSuccessful(false);
        loginAttempt.setIpAddress(request.getRemoteAddr());

        loginAttemptRepository.save(loginAttempt);

        // Redirige al login fallido
        response.sendRedirect("/login?error=true");
    }
}
