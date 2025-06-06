package com.example.POCBankService.controller;

import com.example.POCBankService.service.RedisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis") // Base URL for the controller
//NOTICED. do not forgot install redis on ubuntu. it will get the error connection problem.
//this is an example to see how set and get redis data.
public class RedisTestController {

    private final RedisExampleService redisExampleService;

    @Autowired
    public RedisTestController(RedisExampleService redisExampleService) {
        this.redisExampleService = redisExampleService;
    }

    @PostMapping("/set")
    public String setRedisValue(@RequestParam String key, @RequestParam String value) {
        redisExampleService.setValue(key, value);
        return "Value set in Redis";
    }

    @GetMapping("/get")
    public String getRedisValue(@RequestParam String key) {
        return redisExampleService.getValue(key);
    }
}
