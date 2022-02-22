package com.example.hrspringbootdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoAsyncServiceImpl {
    @Async
    public void demoAsyncMethod() throws InterruptedException {
        System.out.println("demo Async started! thread: " + Thread.currentThread().getName());
        Thread.sleep(3000);
        demoChild();
        demoChild();
        System.out.println("demo Async ended! thread: " + Thread.currentThread().getName());
    }

    private void demoChild() {
        System.out.println("demo AsyncChild started! thread: " + Thread.currentThread().getName());
        System.out.println("demo AsyncChild ended! thread: " + Thread.currentThread().getName());

    }

    public void demoNonAsyncMethod() throws InterruptedException {
        System.out.println("demo Async started! thread: " + Thread.currentThread().getName());
        Thread.sleep(3000);
        demoChild();
        demoChild();
        System.out.println("demo Async ended! thread: " + Thread.currentThread().getName());
    }
}
