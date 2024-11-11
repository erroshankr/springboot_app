package com.example.demo.repo;

import com.example.demo.beans.IceCream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IceCreamRepository extends JpaRepository<IceCream, Long> {

    List<IceCream> findAllByColor(String color);
}
