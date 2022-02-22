package com.example.hrspringbootdemo.controller;

import com.example.hrspringbootdemo.service.DemoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

    DemoServiceImpl demoService;

    public DemoController(DemoServiceImpl demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo")
    public String demoAsync1(@RequestParam(value = "name", defaultValue = "world") String name) throws InterruptedException {
        String cmt = demoService.demoMethod();
        String cmt2 = demoService.demoMethod();
        String cmt3 = demoService.demoMethod();
        Thread.sleep(20000);

        System.out.println(name + "  " + cmt + "  " + cmt2 + "  " + cmt3);
        return String.format("Hello %s!!   method : %s  method : %s  method : %s", name, cmt, cmt2, cmt3);
    }

    @GetMapping("/demoasync")
    public String demoAsync2(@RequestParam(value = "name", defaultValue = "world") String name) throws InterruptedException, ExecutionException {
        Future<String> cmt = demoService.demoAsyncMethod();
        Future<String> cmt2 = demoService.demoAsyncMethod();
        Future<String> cmt3 = demoService.demoAsyncMethod();

        while (true){
            if (cmt.isDone()){
                System.out.println(name + "  " + cmt.get() + "  " + cmt2.get() + "  " + cmt3.get());
                return String.format("Hello %s!!   method : %s  method : %s  method : %s", name, cmt.get(), cmt2.get(), cmt3.get());
            }
            System.out.println("loop");
            Thread.sleep(1000);
        }

    }
}
