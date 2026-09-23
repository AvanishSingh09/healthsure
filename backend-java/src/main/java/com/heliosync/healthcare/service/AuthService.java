package com.heliosync.healthcare.service;

import com.heliosync.healthcare.dto.request.AuthRequest;
import com.heliosync.healthcare.dto.request.RegisterRequest;
import com.heliosync.healthcare.dto.response.AuthResponse;
import com.heliosync.healthcare.model.User;
import com.heliosync.healthcare.repository.UserRepository;
import com.heliosync.healthcare.security.JwtService;
import com.heliosync.healthcare.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        String role = request.getRole() != null ? request.getRole() : "PATIENT";
        
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        user = userRepository.save(user);
        
        SecurityUser securityUser = new SecurityUser(user);
        String jwtToken = jwtService.generateToken(securityUser);

        return AuthResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        SecurityUser securityUser = new SecurityUser(user);
        String jwtToken = jwtService.generateToken(securityUser);

        return AuthResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }
}
