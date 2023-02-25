/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endollssolars;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author sarah
 */
public class Condiciones {
    private ArrayList <String> error = new ArrayList();
    
    private ArrayList <String> ok = new ArrayList();
    
    public Condiciones() {
        this.error.addAll(List.of("ERROR: Número de paràmetres incorrecte d'ús.\nÚs: addCasa [nif] [nom] [superficie]", "ERROR: Superficie incorrecta. Ha de ser més gran de 10.", "ERROR: Ja hi ha una casa registrada amb aquest nif", 
                "ERROR: No hi ha cap casa registrada amb aquest nif.", "ERROR: Superfície incorrecta. Ha de ser més gran de 0.", "ERROR: No hi ha espai disponible per a instal·lar aquesta placa.",
                "ERROR: Preu incorrecte. Ha de ser més gran de 0.", "ERROR: Potència incorrecte. Ha de ser més gran de 0.", "ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.",
                "ERROR: La casa ja té l'interruptor encès.", "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.", "ERROR: L'aparell ja està encès.",
                "ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.", "ERROR: Han saltat els ploms. La casa ha quedat completament apagada.", "ERROR: L'aparell ja està apagat.",
                "ERROR: Número de paràmetres incorrecte.\nÚs: addPlaca [nif] [superficie] [preu] [potència]", "ERROR: Número de paràmetres incorrecte.\nÚs: addAparell [nif] [descripció] [potència]",
                "ERROR: Número de paràmetres incorrecte.\nÚs: onCasa [nif]", "ERROR: Número de paràmetres incorrecte \nÚs: onAparell [nif] [descripció aparell]", "ERROR: Número de paràmetres incorrecte.\nÚs: offAparell [nif] [descripció aparell]",
                "ERROR: Número de paràmetres incorrecte.\nÚs: list", "ERROR: Número de paràmetres incorrecte.\nÚs: info [nif]", "ERROR: Número de paràmetres incorrecte.\nÚs: quit"));
        
        this.ok.addAll(List.of("OK: Casa registrada.", "OK: Placa afegida a la casa.", "OK: Aparell afegit a la casa.", "OK: Aparell encès.", "OK: Aparell apagat."));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
