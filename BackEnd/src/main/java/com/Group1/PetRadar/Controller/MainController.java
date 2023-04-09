package com.Group1.PetRadar.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
@CrossOrigin
public class MainController {

    @GetMapping("/getSomething/{id}")
    public String getSomething(@PathVariable("id") int id) {
        return "dummy";
    }

    @PostMapping("/postSomething")
    public String postSomething() {

        return "dummy";
    }

    @DeleteMapping("deleteSomething/{id}")
    public String deleteMedicalById(@PathVariable("id") int id) {

        return "dummy";
    }


}
