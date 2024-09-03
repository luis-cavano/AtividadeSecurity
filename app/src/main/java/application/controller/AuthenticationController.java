package application.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.User;
import application.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody User user){
        UsernamePasswordAuthenticationToken token =
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = authManager.authenticate(token);

        return tokenService.generateToken(user);
    }
}
