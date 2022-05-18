package com.alnicode.restapi.controller;

import com.alnicode.restapi.dto.AuthenticationRequest;
import com.alnicode.restapi.dto.AuthenticationResponse;
import com.alnicode.restapi.security.JwtUtil;
import com.alnicode.restapi.service.impl.CustomUserDetailsService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> getToken(@NotNull @Valid AuthenticationRequest request) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final var userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final var jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
