package com.meritamerica.capstoneproject.controller;

import com.meritamerica.capstoneproject.models.AccountHolder;
import com.meritamerica.capstoneproject.models.User;
import com.meritamerica.capstoneproject.models.UserDTO;
import com.meritamerica.capstoneproject.security.models.AuthenticationRequest;
import com.meritamerica.capstoneproject.security.models.AuthenticationResponse;
import com.meritamerica.capstoneproject.security.models.RegisterRequest;
import com.meritamerica.capstoneproject.services.AccountHolderService;
import com.meritamerica.capstoneproject.AuthService;
import com.meritamerica.capstoneproject.services.MyUserDetailsService;
import com.meritamerica.capstoneproject.security.util.JwtUtil;

import com.meritamerica.capstoneproject.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    AuthService authService;

    @PostMapping(value = "/signin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("Reached");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsernameOrEmail(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException bce) {
            throw new Exception("Incorrect username or password", bce);
        }

        final UserDetails usernameOrEmail = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsernameOrEmail());
        final Integer userId = userService.getUserByUserName(authenticationRequest.getUsernameOrEmail()).getId();
        final String jwt = jwtTokenUtil.generateToken(usernameOrEmail);
        final UserDTO user = new UserDTO(jwt, usernameOrEmail.getAuthorities().toString(), userId);

        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/registerUser")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        return authService.registerUser(registerRequest);
    }

}