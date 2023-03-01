/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endollssolars;

/**
 *
 * @author sarah
 */
public class Aparell {

    private String descripcio;
    private float potencia;
    private String interruptor = "Apagat";

    public Aparell(String descripcio, float potencia) {
        this.descripcio = descripcio;
        this.potencia = potencia;
    }

    public String getDescripcio() {
        return this.descripcio;
    }

    public float getPotencia() {
        return this.potencia;
    }

    public String getInterruptor() {
        return this.interruptor;
    }

    public void turnOnAparell(String estado) {
        this.interruptor = estado;
    }
    
    public void turnOffAparell(String estado) {
        this.interruptor = estado;
    }
}
