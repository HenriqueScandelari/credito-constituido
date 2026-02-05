package com.infuse.credito.api.controller;

import com.infuse.credito.api.controller.dto.AuthenticationDTO;
import com.infuse.credito.api.controller.dto.RegisterDTO;
import com.infuse.credito.api.model.User;
import com.infuse.credito.api.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final AuthorizationService service;

    public AuthenticationController(AuthenticationManager manager, AuthorizationService service) {
        this.manager = manager;
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO login) {
        var userPass = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        var auth = manager.authenticate(userPass);

        return ResponseEntity.ok().body(userPass);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO register) {
        if (service.findByLogin(register.login()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(register.password());
        User user = new User(register.login(), encodedPassword, register.role());
        service.save(user);
        return ResponseEntity.ok().build();
    }
}
