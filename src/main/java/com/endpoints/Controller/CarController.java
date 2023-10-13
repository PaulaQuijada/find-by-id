package com.endpoints.Controller;

import com.endpoints.Domain.Coche;
import com.endpoints.Service.CarNotExistsException;
import com.endpoints.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping("/coches/{id}")
    public ResponseEntity<CarOutPut> getCocheById(@PathVariable String id){
       try{ CarOutPut coche = carService.getCocheById(id);
            return ResponseEntity.ok(coche);
        }
       catch (CarNotExistsException e){
           System.out.println(e.getMessage());
           return  ResponseEntity.notFound().build();
       }
    }
    @PostMapping("/coches")
    public ResponseEntity<String> addCoche(@RequestBody CarInput coche) {
        try {
            carService.addCoche(coche);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }
}
