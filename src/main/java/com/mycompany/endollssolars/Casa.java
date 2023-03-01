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
        System.out.println("OK: Placa afegida a la casa.");
        placas.add(placa);
    }

    public void addAparell(Aparell aparell) {
        System.out.println("OK: Aparell afegit a la casa.");
        aparells.add(aparell);
    }

    public void turnOnCasa(String estado) {
        this.interruptor = estado;
    }

    public void turnOffAparells() {
        for (Aparell aparato : aparells) {
            aparato.turnOffAparell("Apagat");
        }
    }

    public void findAparato(String descripcio, String comando, Casa cliente) {
        float sumap = 0;
        float sumaa = 0;
        for (Placa placa : placas) {
            sumap = sumap + placa.getPotencia();
        }
        for (Aparell aparato : aparells) {
            if (aparato.getDescripcio().equalsIgnoreCase(descripcio)) {
                if (comando.equalsIgnoreCase("onAparell")) {
                    if (this.interruptor.equalsIgnoreCase("Activat")) {
                        if ((aparato.getInterruptor()).equalsIgnoreCase("Apagat")) {
                            aparato.turnOnAparell("Activat");
                            for (Aparell aparatos : aparells) {
                                if ((aparatos.getInterruptor()).equalsIgnoreCase("Activat")) {
                                    sumaa = sumaa + aparato.getPotencia();
                                }
                            }
                            if (sumaa > sumap) {
                                cliente.turnOffAparells();
                                this.interruptor = "Apagat";
                                System.out.println(Condiciones.PLOMS_SALTATS);
                            } else {
                                System.out.println("OK: Aparell encès.");
                            }
                        }
                    } else {
                        System.out.println(Condiciones.APARELL_ENCES);
                    }
                } else {
                    System.out.println(Condiciones.INTERRUPTOR_APAGAT);
                }

            } else if (comando.equalsIgnoreCase("offAparell")) {
                if ((aparato.getInterruptor()).equalsIgnoreCase("Activat")) {
                    aparato.turnOffAparell("Desactivat");
                    System.out.println("OK: Aparell apagat.");
                } else {
                    System.out.println(Condiciones.APARELL_APAGAT);
                }
            }
        }
    }

    public boolean comprobarPlaca(float placanueva) {
        boolean espacio = false;
        double resta;
        resta = superficie;
        for (Placa unaPlaca : placas) {
            resta = resta - unaPlaca.getSuperficie();
        }

        if (placanueva > superficie && placanueva > resta) {
            espacio = false;
        } else {
            espacio = true;
        }
        return espacio;
    }

    public String comprobarAparell(String nom) {
        int indice1 = 0;
        for (Aparell aparato : aparells) {
            if (!(nom.equalsIgnoreCase(aparato.getDescripcio()))) {
                indice1 = indice1 + 1;
            }
        }
        if (aparells.size() == indice1) {
            nom = "registrar";
        } else {
            nom = "registrado";
        }
        return nom;
    }

    public void listCasa() {
        double resta;
        resta = superficie;
        for (Placa unaPlaca : placas) {
            resta = resta - unaPlaca.getSuperficie();
        }

        System.out.println("Client: " + nif + " - " + nom);
        System.out.println("Superfície de teulada: " + superficie);
        System.out.println("Superfície disponible: " + resta);
        System.out.println("Interruptor general: " + interruptor);
        if (placas.size() > 0) {
            System.out.println("Plaques solars instal·lades: " + placas.size());
        } else {
            System.out.println("No té plaques solars instal·lades.");
        }
        if (aparells.size() > 0) {
            System.out.println("Aparells registrats: " + aparells.size());
        } else {
            System.out.println("No té cap aparell elèctric registrat.");
        }
    }

    public void infoCasa() {
        float suma = 0;
        float inversio = 0;
        float consum = 0;
        String nombre = "a";
        for (Placa placa : placas) {
            suma = suma + placa.getPotencia();
            inversio = inversio + placa.getPreu();
        }
        for (Aparell aparato: aparells){
        if ((aparato.getInterruptor()).equalsIgnoreCase("Activat")){
            consum = consum + aparato.getPotencia();
            nombre = aparato.getDescripcio();
        }
    }
        System.out.println("Client: " + nif + " - " + nom);
        if (placas.size() > 0) {
            System.out.println("Plaques solars instal·lades: " + placas.size());
        } else {
            System.out.println("No té plaques solars instal·lades.");
        }
        System.out.println("Potència total: " + suma + "W");
        System.out.println("Inversió total: " + inversio + "€");
        if (aparells.size() > 0) {
            System.out.println("Aparells registrats: " + aparells.size());
        } else {
            System.out.println("No té cap aparell elèctric registrat.");
        }
        System.out.println("Consum actual: " + consum + "W");
        
        if (consum > 0){
            System.out.println("Aparells encesos:");
            for (Aparell aparato : aparells){
                if ((aparato.getInterruptor()).equalsIgnoreCase("Activat")) {
                    System.out.println("    -" + aparato.getDescripcio());
                }
            }
        }
        
    }

}
