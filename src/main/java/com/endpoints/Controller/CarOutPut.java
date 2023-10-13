package com.endpoints.Controller;

import com.endpoints.Domain.Coche;

public class CarOutPut {
    private String matricula;
    private String marca;
    private String modelo;
    private int year;

    public CarOutPut() {
    }

    public CarOutPut(String matricula, String marca, String modelo, int year) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }
    public static CarOutPut getCoche(Coche coche){
        return new CarOutPut(coche.getMatricula(), coche.getMarca(),coche.getModelo(),coche.getYear());
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
