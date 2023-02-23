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
    private float consum;
    private String interruptor = "Activat";
    
    public Aparell(String descripcio, float consum) {
        this.descripcio = descripcio;
        this.consum = consum;           
    }
    
    public String getDescripcio() {
    return this.descripcio;
}
    
    public float getConsum() {
        return this.consum;
    }
    
    public String getInterruptor() {
        return this.interruptor;
    }
}
