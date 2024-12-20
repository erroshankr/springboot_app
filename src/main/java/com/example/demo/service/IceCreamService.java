package com.example.demo.service;

import com.example.demo.beans.IceCream;
import com.example.demo.repo.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IceCreamService {


    @Autowired
    private IceCreamRepository iceCreamRepository;

    public IceCream getIceCreamByID(Long id){
         Optional<IceCream> opt =  iceCreamRepository.findById(id);
         if(opt.isPresent()){
             return opt.get();
         }
         return null;
    }

    public void createIceCream(IceCream iceCream){
        iceCreamRepository.save(iceCream);
    }

    public void updateIceCream(Long id, IceCream iceCream){
        Optional<IceCream> opt = iceCreamRepository.findById(id);
        if(opt.isPresent()){
           IceCream updatedIceCream = opt.get();
           updatedIceCream.setName(iceCream.getName());
           updatedIceCream.setPrice(iceCream.getPrice());
           updatedIceCream.setFlavour(iceCream.getFlavour());
           updatedIceCream.setColor(iceCream.getColor());
           iceCreamRepository.save(updatedIceCream);
        }
    }

    public void deleteIceCream(Long id){
        iceCreamRepository.deleteById(id);
    }

    public List<IceCream> getAllIceCream(){
        return iceCreamRepository.findAll();
    }

    public List<IceCream> getIceCreamByColor(String color){
       return iceCreamRepository.findAllByColor(color);
    }
}
