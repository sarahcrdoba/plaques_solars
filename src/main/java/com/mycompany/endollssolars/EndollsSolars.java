/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.endollssolars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author sarah
 */
public class EndollsSolars {
    
    public static void main(String[] args) throws IOException {
        BufferedReader Consola = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Casa> casas = new ArrayList();
        
        String comando;
        
        do {
            System.out.print("> ");
            comando = Consola.readLine();
            String[] parts = comando.split(" ");
            String orden = parts[0];

            
            switch (orden) {
                case "addCasa":
                    float part3 = new Float(parts[3]);
                    Casa nueva = new Casa(parts[1], parts[2], part3);
                    casas.add(nueva);
                    break;
                
                case "addPlaca":
                    String nif = parts[1];
                    float part1 = new Float(parts[2]);
                    float part2 = new Float(parts[3]);
                    float parte3 = new Float(parts[4]);
                    Placa añadir = new Placa(part1, part2, parte3);
                    
                    for (Casa cliente : casas) {
                        if (nif.equalsIgnoreCase(cliente.getNif())) {
                            cliente.addPlaca(añadir);
                        }
                    }
                    break;
                
                case "addAparell":
                    float consum = new Float(parts[3]);
                    Aparell nuevo = new Aparell(parts[2], consum);
                    
                    for (Casa cliente : casas) {
                        if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                            cliente.addAparell(nuevo);
                        }
                    }
                    break;
                
                case "onCasa":
                    for (Casa cliente : casas) {
                        if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                            System.out.println(cliente.getInterruptor());
                            if ((cliente.getInterruptor()).equalsIgnoreCase("Activat")) {
                                System.out.println("ERROR: La casa ja té l'interruptor encès.");
                            } else {
                                cliente.turnOnCasa("Activat");
                            }
                        }
                    }                    
                    break;
                
                case "onAparell":                    
                    for (Casa cliente : casas) {
                        if  (parts[1].equalsIgnoreCase(cliente.getNif())) {
                            cliente.findAparato(parts[2], parts[0]);
                        }
                    }
                    break;
                
                case "offAparell":
                    for (Casa cliente : casas) {
                        if  (parts[1].equalsIgnoreCase(cliente.getNif())) {
                            cliente.findAparato(parts[2], parts[0]);
                        }
                    }
                    break;
                    
                case "list":
                    int contador = 0;
                    System.out.println("--- Endolls Solars, S.L. ---");
                    System.out.println("Cases enregistrades: " + casas.size());
                    System.out.println(" ");
                    for (Casa cliente: casas) {
                        contador = contador +1;
                        System.out.println("Casa" + contador);
                        cliente.listCasa();
                        System.out.println(" ");
                    }
                    break;
                    
                case "info":
                    for (Casa cliente: casas) {
                        if  (parts[1].equalsIgnoreCase(cliente.getNif())) {
                            cliente.listCasa();
                        }
                    }
                    break;
            }           
        } while (!comando.equalsIgnoreCase("quit"));
        
    }
    
}
