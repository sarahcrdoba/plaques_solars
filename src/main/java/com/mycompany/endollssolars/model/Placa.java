/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endollssolars.model;

/**
 *
 * @author sarah
 */
public class Placa {
    private float superficie;
    private float preu;
    private float potencia;
    
    public Placa(float superficie, float preu, float potencia) {
        this.superficie = superficie;
        this.preu = preu;
        this.potencia = potencia;
    }
    
    public float getSuperficie() {
        return this.superficie;
    }
    
    public float getPreu() {
        return this.preu;
    }
    
    public float getPotencia() {
        return this.potencia;
    }
        
}
