package com.spboot.demotest.err;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping(value = PATH)
    public String error() {
        return  "Error haven";
    }

    @GetMapping("/errorHaven")
    public String errorHaven() {
        return "You have reached the haven of errors!!!";
    }
}