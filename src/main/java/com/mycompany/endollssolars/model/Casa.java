/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endollssolars.model;

import com.mycompany.endollssolars.model.Aparell;
import java.util.ArrayList;

/**
 *
 * @author sarah
 */
public class Casa {

    private String nif;
    private String nom;
    private float superficie;
    private boolean interruptor = true;
    private ArrayList<Placa> placas = new ArrayList();      // lista donde iran las placas
    private ArrayList<Aparell> aparells = new ArrayList();  // lista donde iran los aparatos

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

    public boolean getInterruptor() {
        return this.interruptor;
    }

    public void addPlaca(Placa placa) {     // este metodo nos permite añadir una placa a la lista, dentro de la casa seleccionada       
        placas.add(placa);
    }

    public void addAparell(Aparell aparell) {       // este metodo nos permite añadir un aparato a la lista, dentro de la casa seleccionada
        aparells.add(aparell);
    }

    public void turnOnCasa(boolean estado) {     // nos cambia el estado del interruptor general
        this.interruptor = estado;
    }

    public void turnOffAparells() {     // nos apaga todos los aparatos y la casa (en caso de caida de plomos)
        this.interruptor = false;
        for (Aparell aparato : aparells) {
            aparato.turnOffAparell(false);
        }
    }

    public void onAparell(String comando, String descripcio) {      // nos enciende un aparato
        Aparell encendre = null;
        encendre.turnOnAparell(true);
    }

    public void offAparell(String comando, String descripcio) {     // nos apaga un aparato
        Aparell apagar = null;
        apagar.turnOffAparell(false);
    }

    public Aparell findAparell(String descripcio) {     // nos encuentra un aparato
        for (Aparell aparato : aparells) {
            if ((aparato.getDescripcio()).equalsIgnoreCase(descripcio)) {   // comprueba si el aparato ya existe
                return aparato;
            }
        }
        return null;
    }

    public boolean comprobarPlaca(float placanueva) {       // nos calcula el espacio para instalar placas
        boolean espacio = false;
        float restant = superficie;
        for (Placa unaPlaca : placas) {
            restant = restant - unaPlaca.getSuperficie();   // por cada placa vamos restando el espacio que ocupanen la casa
        }
        restant = restant - placanueva;     //resta de la ultima placa para saber si cabe o no
        if (restant < 0) {     // si la superficie restante es menor a 0, entonces la placa ocupa más sitio del que puede
            espacio = false;    
        } else {
            espacio = true; 
        }
        return espacio;     // nos devuelve si cabe o no
    }

    public int totalPlaca() {   // nos devuelve el numero de placas
        return placas.size();
    }

    public int totalAparell() {  // nos devuelve el numero de aparatos
        return aparells.size();
    }

    public float superficieRestant() {  // nos devuelve la superficie disponible en la casa
        float restant;
        float total = 0;
        for (Placa placa : placas) {
            total = total + placa.getSuperficie();
        }
        restant = superficie - total;
        return restant;
    }

    public float potenciaTotal() {  // nos devuelve la potencia total de una casa
        float potencia = 0;
        for (Placa placa : placas) {
            potencia = potencia + placa.getPotencia();
        }
        return potencia;
    }

    public float inversioTotal() {  // nos devuelve el dinero invertido total
        float inversio = 0;
        for (Placa placa : placas) {
            inversio = inversio + placa.getPreu();
        }
        return inversio;
    }

    public float consumTotal() {    // nos devuelve el consumo total de los aparatos encendidos
        float consum = 0;
        for (Aparell aparell : aparells) {
            if (aparell.getInterruptor() == true) {
            consum = consum + aparell.getPotencia();
            }
        }
        return consum;
    }

    public ArrayList aparellsEncesos() {    // nos devuelve los aparatos encendidos en una casa
        ArrayList<String> encesos = new ArrayList();
        for (Aparell aparell : aparells) {
            if (aparell.getInterruptor() == true) {
                encesos.add(aparell.getDescripcio());
            }
        }
        return encesos;
    }

}
