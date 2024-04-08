package com.coface.corp.autonomy.programservice.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class ProgramController {

    @GetMapping("/api/program")
    public String getProgram(@RequestHeader("X-Auth-Token") String cookieHeader) {
        final String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        final String loggedInUse = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        System.out.println("User Name " + loggedInUserName);
        System.out.println("User Right " + loggedInUse);
        System.out.println("cookieHeader " + cookieHeader);
        return "Hello";

    }
}
