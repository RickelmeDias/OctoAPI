package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.dtos.authentication.req.AuthenticationReqDTO;
import com.octopodius.OctoAPI.dtos.authentication.res.AuthenticationTokenResDTO;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.security.jwt.JwtTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity<AuthenticationTokenResDTO> login(@RequestBody @Valid AuthenticationReqDTO authReqDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authReqDto.email(), authReqDto.password());
        Authentication auth = manager.authenticate(token);
        User user = (User) auth.getPrincipal();
        AuthenticationTokenResDTO tokenRes = new AuthenticationTokenResDTO(jwtTokenService.generateToken(user));
        return ResponseEntity.ok(tokenRes);
    }

}
