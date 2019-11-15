package com.dm.gateway.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.gateway.entity.User;
import com.dm.gateway.repository.UserRepository;
import com.dm.gateway.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Async
    @Transactional
    public CompletableFuture<User> saveAsync(User user) {
        log.debug("保存用户在线程" + Thread.currentThread());
        User user_ = userRepository.save(user);
        return CompletableFuture.completedFuture(user_);
    }

    @Override
    @Transactional
    public User save(User user) {
        User user_ = userRepository.save(user);
        try {
            Thread.sleep(10000);
          log.info(""+Thread.currentThread());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        throw new RuntimeException();
        return user_;
    }

}
