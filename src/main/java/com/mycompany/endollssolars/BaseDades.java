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
public class BaseDades {

    private ArrayList<Casa> casas = new ArrayList();    // lista donde gaurdaremos todas las casas

    public Casa trobarNif(String nif){      // nos devuelve una casa
        if (!casas.isEmpty()) {
        for (Casa clientes : casas) {
            if ((clientes.getNif()).equalsIgnoreCase(nif)) {    // si el cliente coincide con el nif que le pasamos
                return clientes;                                                                 // nos devuelve esa casa
            }
        }
        }
        return null;    // devuelve null si no se encuentra la casa
    }
    
    public void afegirCasa(Casa casa){      // nos añade una casa a la lista
        casas.add(casa);
    }
    
    public ArrayList getBd(){       // arraylist que nos permitirá pasar las casas al main para hacer el list
        return casas;
    }
}
