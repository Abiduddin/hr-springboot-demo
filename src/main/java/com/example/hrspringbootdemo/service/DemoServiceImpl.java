package com.example.hrspringbootdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class DemoServiceImpl {

    DemoAsyncServiceImpl demoAsyncService;

    public DemoServiceImpl(DemoAsyncServiceImpl demoAsyncService) {
        this.demoAsyncService = demoAsyncService;
    }

    public String demoMethod() throws InterruptedException {
        demoAsyncService.demoAsyncMethod();

        System.out.println("demo  ended! thread: " + Thread.currentThread().getName());
        return "fffff";
    }

    @Async
    public Future<String> demoAsyncMethod() throws InterruptedException {
        demoAsyncService.demoNonAsyncMethod();

        System.out.println("demo  ended! thread: " + Thread.currentThread().getName());

        return  new AsyncResult<String>("FFF FFF");
    }

}
