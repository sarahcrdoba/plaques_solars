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
                        if (cliente.getNif() == nif) {
                            cliente.addPlaca(añadir);
                        }
                    }
                    break;

                case "addAparell":
                    float consum = new Float(parts[3]);
                    Aparell nuevo = new Aparell(parts[2], consum);

                    for (Casa cliente : casas) {
                        if (cliente.getNif() == parts[1]) {
                            cliente.addAparell(nuevo);
                        }
                    }
                    break;

                case "onCasa":
                    for (Casa cliente : casas) {
                        if (cliente.getNif() == parts[1]) {
                            if (cliente.getInterruptor() == "Activat") {
                                System.out.println("ERROR: La casa ja té l'interruptor encès.");
                            }
                            else {
                            cliente.turnOnCasa("Activat");
                        }
                        }
                    } 
                    break;
                    
                case "onAparell":      
                    

            }

        } while (comando != "quit");

    }

}