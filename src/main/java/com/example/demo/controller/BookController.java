package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/icecream")
    public String getIceCream(@RequestParam String icecreamType){
        return "book"; // requires template resolution
    }

    public String createIceCream(String icecreamType){
        System.out.println("creating icecream");
        return icecreamType + " Ice-cream is created";
    }

}
