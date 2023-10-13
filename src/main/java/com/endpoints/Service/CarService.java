package com.endpoints.Service;

import com.endpoints.Controller.AlreadyExistsException;
import com.endpoints.Controller.CarInput;
import com.endpoints.Controller.CarOutPut;
import com.endpoints.Domain.Coche;
import com.endpoints.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void addCoche(CarInput coche) throws AlreadyExistsException {
        if (getHashMap().containsKey(coche.getMatricula())) {
            throw new AlreadyExistsException("El coche ya existe");
        } else {
            carRepository.save(Coche.getCoche(coche));
        }
    }

    public CarOutPut getCocheById(String matricula) throws CarNotExistsException {
        if (getHashMap().containsKey(matricula)) {
            CarOutPut coche = getHashMap().get(matricula);
            return coche;
        } else throw new CarNotExistsException("El coche no existe");
    }

    private HashMap<String, CarOutPut> getHashMap() {
        List<Coche> coches = carRepository.findAll();
        HashMap<String, CarOutPut> cochesHashmap = new HashMap<>();
        for (Coche coche : coches) {
            cochesHashmap.put(coche.getMatricula(), CarOutPut.getCoche(coche));
        }
        return cochesHashmap;
    }
}
