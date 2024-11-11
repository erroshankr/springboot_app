package com.example.demo.service;

import com.example.demo.beans.IceCream;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class IceCreamService {

    public static Map<Integer, IceCream> iceCreamMap = new HashMap<>();

    public IceCream getIceCreamByID(int id){
         return iceCreamMap.get(id);
    }

    public void createIceCream(IceCream iceCream){
        iceCreamMap.put(iceCream.getId(), iceCream);
    }

    public void updateIceCream(IceCream iceCream){
        iceCreamMap.put(iceCream.getId(), iceCream);
    }
    public void deleteIceCream(int id){
        iceCreamMap.remove(id);
    }

    public List<IceCream> getAllIceCream(){
        return new ArrayList<>(iceCreamMap.values());
    }

    public List<IceCream> getIceCreamByColor(String color){
        List<IceCream> iceCreamList = new ArrayList<>();
        for(IceCream iceCream : iceCreamMap.values()){
            if(iceCream.getColor().equals(color)){
                iceCreamList.add(iceCream);
            }
        }
        return iceCreamList;
    }
}
