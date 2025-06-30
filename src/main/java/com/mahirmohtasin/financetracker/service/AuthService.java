package com.mahirmohtasin.financetracker.service;

import com.mahirmohtasin.financetracker.dto.AuthRequest;
import com.mahirmohtasin.financetracker.dto.AuthResponse;
import com.mahirmohtasin.financetracker.dto.RegisterRequest;
import com.mahirmohtasin.financetracker.model.User;
import com.mahirmohtasin.financetracker.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userService.save(user);
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails user = userService.loadUserByUsername(request.getEmail());
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
}
