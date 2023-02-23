/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endollssolars;

import java.util.ArrayList;

/**
 *
 * @author sarah
 */
public class Casa {

    private String nif;
    private String nom;
    private float superficie;
    private String interruptor = "Activat";
    private ArrayList<Placa> placas = new ArrayList();
    private ArrayList <Aparell> aparells = new ArrayList();
    
    public Casa(String nif, String nom, float superficie) {
        this.nif = nif;
        this.nom = nom;
        this.superficie = superficie;
    }

    public String getNif() {
        return this.nif;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public float getSuperficie() {
        return this.superficie;
    }
    
    public String getInterruptor() {
        return this.interruptor;
    }
    
    public void addPlaca(Placa placa) {
        placas.add(placa);
    }
    
    public void addAparell(Aparell aparell) {
        aparells.add(aparell);
    }
    
    public void turnOnCasa(String estado) {
        this.interruptor = estado;        
    }
}
