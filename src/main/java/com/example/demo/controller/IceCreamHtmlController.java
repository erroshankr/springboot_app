package com.example.demo.controller;

import com.example.demo.beans.IceCream;
import com.example.demo.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/html")
public class IceCreamHtmlController {

    @Autowired
    private IceCreamService iceCreamService;


    @GetMapping("/test")
    public String testMethod(){
         return "ice-cream";
    }


    @PostMapping("/create/icecream")
    public String createIceCream(@RequestBody IceCream iceCream, Model model){    // data flow : frontend --> Backend
        try {
            iceCreamService.createIceCream(iceCream); // data flow : backend --> frontend
            model.addAttribute("info", "SUCCESS");
        }catch (Exception e){
           model.addAttribute("error", "FAILURE");
        }
        model.addAttribute("iceCreamLi", iceCreamService.getAllIceCream());
        return "ice-cream";
    }

    @GetMapping("/fetchById/{id}")
    public String getIceCreamByID(@PathVariable String id, Model model) {
        IceCream ice = null;
        try {
             ice = iceCreamService.getIceCreamByID(Long.parseLong(id));
        }catch (Exception e){
            model.addAttribute("error", "FAILURE");
        }
        if(ice == null){
            model.addAttribute("warn", "NOT FOUND");
        }else{
            model.addAttribute("info", "SUCCESS");
            model.addAttribute("iceCreamLi", List.of(ice));
        }
        return "ice-cream";
    }

    @GetMapping("/fetchByColor/{color}")
    public String getIceCreamByColor(@PathVariable String color, Model model) {
        List<IceCream> icecreams = null;
        try {
            icecreams = iceCreamService.getIceCreamByColor(color);
        }catch (Exception e){
            model.addAttribute("error", "FAILURE");
        }
        if(icecreams.isEmpty()){
            model.addAttribute("warn", "Not found");
        }else{
            model.addAttribute("info", "SUCCESS");
            model.addAttribute("iceCreamLi", icecreams);
        }
        return "ice-cream";
    }

    @GetMapping("/get/all/icecream")
    public String getIceCreams(Model model) {
        try {
            model.addAttribute("iceCreamLi", iceCreamService.getAllIceCream());
            model.addAttribute("info", "SUCCESS");
        }catch (Exception e){
            model.addAttribute("error", "FAILURE");
        }
        return "ice-cream";
    }


    @DeleteMapping("/delete/icecream/{id}")
    public String deleteIceCreamByID(@PathVariable Long id, Model model) {
        try {
            iceCreamService.deleteIceCream(id);
            model.addAttribute("info", "SUCCESS");
        }catch (Exception e){
            model.addAttribute("error", "FAILURE");
        }
        model.addAttribute("iceCreamLi", iceCreamService.getAllIceCream());
        return "ice-cream";
    }

    @PutMapping("/update/icecream/{id}")
    public String updateIceCream(@PathVariable Long id, @RequestBody IceCream iceCream, Model model) {
        try {
            iceCreamService.updateIceCream(iceCream);
            model.addAttribute("iceCreamLi", iceCreamService.getAllIceCream());
            model.addAttribute("info", "SUCCESS");
        }catch (Exception e){
            model.addAttribute("error", "FAILURE");
        }
        return "ice-cream";
    }

}
