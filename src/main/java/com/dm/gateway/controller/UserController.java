package com.dm.gateway.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.gateway.entity.User;
import com.dm.gateway.service.UserService;

import reactor.core.publisher.Mono;

@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String save() {
        User user = new User();
        user.setName("李东");
        ;
        return user.toString();
    }

    @GetMapping("async")
    public Mono<Long> saveAsync() {
        User user = new User();
        user.setName("李东");
        System.out.println("接受在线程" + Thread.currentThread());
        return Mono.fromFuture(userService.saveAsync(user)).map(User::getId);
    }

}
