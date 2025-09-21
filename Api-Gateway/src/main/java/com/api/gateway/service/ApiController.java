package com.api.gateway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway-test")
@RequiredArgsConstructor
public class ApiController {



    @GetMapping("/test")
    public String testApi() {
        return "This api is working";
    }
}
