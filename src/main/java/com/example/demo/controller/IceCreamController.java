package com.example.demo.controller;

import com.example.demo.beans.IceCream;
import com.example.demo.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class IceCreamController {

    @Autowired
    private IceCream iceCream;

    @Autowired
    private IceCreamService iceCreamService;

    @GetMapping("/test")
    public String testMethod(){
        return "SUCCESS";
    }

    @GetMapping("/fetchById/{id}")
    public IceCream getIceCreamByID(@PathVariable String id) {
        System.out.println("Inside getIceCreamByID");
        IceCream i =  iceCreamService.getIceCreamByID(Integer.parseInt(id));
        if(i == null){
            return iceCream;
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
    public void createIceCream(@RequestBody IceCream iceCream){
         iceCreamService.createIceCream(iceCream);
    }

    @DeleteMapping("/delete/icecream/{id}")
    public void deleteIceCreamByID(@RequestParam Integer id){
        iceCreamService.deleteIceCream(id);
    }

    @PutMapping("/create/icecream")
    public void updateIceCream(@RequestBody IceCream iceCream){
        iceCreamService.updateIceCream(iceCream);
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