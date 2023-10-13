package com.endpoints.Repository;

import com.endpoints.Controller.CarInput;
import com.endpoints.Domain.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Coche, String> {

}

