package com.endpoints.Domain;

import com.endpoints.Controller.CarInput;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coche {
    @Id
    private String matricula;
    private String marca;
    private String modelo;
    private int year;

    public Coche(){}

    public Coche(String matricula, String marca, String modelo, int year) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }
    public static Coche getCoche(CarInput coche){
        return new Coche(coche.getMatricula(), coche.getMarca(), coche.getModelo(), coche.getYear());
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
