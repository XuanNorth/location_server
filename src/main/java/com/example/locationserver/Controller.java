package com.example.locationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired Service service;
    @PostMapping("/{longitude}/{latitude}")
    void receiveLocation(@PathVariable double longitude, @PathVariable double latitude) {
        service.checkLocation(latitude, longitude);
    }
}
