package com.dm.gateway.service;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.dm.gateway.entity.User;

public interface UserService {

    public User save(User user);

    public CompletableFuture<User> saveAsync(User user);

}
