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
    private ArrayList<Aparell> aparells = new ArrayList();

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
        System.out.println("placa añadida");
        placas.add(placa);
    }

    public void addAparell(Aparell aparell) {
        aparells.add(aparell);
    }

    public void turnOnCasa(String estado) {
        this.interruptor = estado;
    }

    public void findAparato(String descripcio, String comando) {
        for (Aparell aparato : aparells) {
            if (aparato.getDescripcio().equalsIgnoreCase(descripcio)) {
                if (comando.equalsIgnoreCase("onAparell")) {
                    aparato.turnOnAparell("Activat");
                }
                else if (comando.equalsIgnoreCase("offAparell")) {
                    aparato.turnOffAparell("Desactivat");
                }

            }
        }
    }
    
    public void listCasa() {
        double resta;
        resta = superficie;
        for (Placa unaPlaca: placas) {
           resta = resta  -  unaPlaca.getSuperficie();          
        }
        
        System.out.println("Client: " + nif + " - " + nom);
        System.out.println("Superfície de teulada: " + superficie);
        System.out.println("Superfície disponible: " + resta);
        System.out.println("Interruptor general: " + interruptor);
        System.out.println("Plaques solars instal·lades: " + placas.size());
        System.out.println("Aparells registrats: " + aparells.size());

    }

}
