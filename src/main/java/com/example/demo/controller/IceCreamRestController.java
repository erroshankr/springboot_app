package com.example.demo.controller;

import com.example.demo.beans.IceCream;
import com.example.demo.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class IceCreamRestController { // CRUD Operations

   /* @Autowired
    private IceCream iceCream;*/

    @Autowired
    private IceCreamService iceCreamService;

    @GetMapping("/test")
    public String testMethod(){
        return "SUCCESS";
    }

    @GetMapping("/fetchById/{id}")
    public IceCream getIceCreamByID(@PathVariable String id) {
        System.out.println("Inside getIceCreamByID");
        IceCream i =  iceCreamService.getIceCreamByID(Long.parseLong(id));
        if(i == null){
            return null;
        }else{
            return i;
        }
    }

    @GetMapping("/fetchByColor/{color}")
    public List<IceCream> getIceCreamByColor(@PathVariable String color) {
        return iceCreamService.getIceCreamByColor(color);
    }

    @GetMapping("/get/all/icecream")
    public List<IceCream> getIceCreams() {
        return iceCreamService.getAllIceCream();
    }

    @PostMapping("/create/icecream")
    public void createIceCream(@RequestBody IceCream iceCream){    // data flow : frontend --> Backend
         iceCreamService.createIceCream(iceCream); // data flow : backend --> frontend
    }

    @DeleteMapping("/delete/icecream/{id}")
    public void deleteIceCreamByID(@PathVariable Long id){
        iceCreamService.deleteIceCream(id);
    }

    @PutMapping("/update/icecream/{id}")
    public void updateIceCream(@PathVariable Long id, @RequestBody IceCream iceCream){
        iceCreamService.updateIceCream(id, iceCream);
    }

   /* @GetMapping("/icecream")
    public String getBooks(){
        return createIceCream("");
    }
*/
   /* public String createIceCream(String icecreamType){
        return icecreamType + " Ice-cream is created";
    }*/

}

// GET --> READ
// POST --> Create new resource
// PUT --> Updates existing resource
// DELETE --> delete a resource