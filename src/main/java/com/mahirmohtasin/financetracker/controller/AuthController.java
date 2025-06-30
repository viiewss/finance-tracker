package com.mahirmohtasin.financetracker.controller;

import com.mahirmohtasin.financetracker.dto.AuthenticationRequest;
import com.mahirmohtasin.financetracker.dto.AuthenticationResponse;
import com.mahirmohtasin.financetracker.dto.RegisterRequest;
import com.mahirmohtasin.financetracker.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
