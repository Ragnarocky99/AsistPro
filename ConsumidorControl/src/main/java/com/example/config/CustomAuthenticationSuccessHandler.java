package com.example.config;

import com.example.model.LoginAttempt;
import com.example.repository.LoginAttemptRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private LoginAttemptRepository loginAttemptRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        LoginAttempt loginAttempt = new LoginAttempt();
        loginAttempt.setEmail(request.getParameter("username"));
        loginAttempt.setTimestamp(new Date());
        loginAttempt.setSuccessful(true);
        loginAttempt.setIpAddress(request.getRemoteAddr());

        loginAttemptRepository.save(loginAttempt);

        // Redirige al usuario al éxito de login
        response.sendRedirect("/");
    }
}
