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

            if (parts[0].equalsIgnoreCase("addCasa") || parts[0].equalsIgnoreCase("addPlaca") || parts[0].equalsIgnoreCase("addAparell") || parts[0].equalsIgnoreCase("onCasa")
                    || parts[0].equalsIgnoreCase("onAparell") || parts[0].equalsIgnoreCase("offAparell") || parts[0].equalsIgnoreCase("list") || parts[0].equalsIgnoreCase("info")
                    || parts[0].equalsIgnoreCase("quit")) {

                switch (orden) {

                    case "addCasa":
                        int indice = 0;
                        if (parts.length == 4) {
                            float part3 = Float.parseFloat(parts[3]);
                            for (Casa cliente : casas) {
                                if (!(cliente.getNif()).equalsIgnoreCase(parts[1])) {
                                    indice = indice + 1;
                                }
                            }
                            if (casas.size() == indice) {
                                if (part3 >= 10) {
                                    Casa nueva = new Casa(parts[1], parts[2], part3);
                                    casas.add(nueva);
                                    System.out.println("OK: Casa registrada.");
                                } else {
                                    System.out.println(Condiciones.SUPERFICIE_CASA);
                                }
                            } else {
                                System.out.println(Condiciones.CASA_REGISTRADA);
                            }
                        } else {
                            System.out.println(Condiciones.PARAMETRES + Condiciones.ADDCASA);
                        }
                        break;

                    case "addPlaca":
                        if (parts.length == 5) {
                            String nif = parts[1];
                            float part1 = Float.parseFloat(parts[2]);
                            float part2 = Float.parseFloat(parts[3]);
                            float parte3 = Float.parseFloat(parts[4]);

                            if (part1 > 0 && part2 > 0 && parte3 > 0) {

                                Placa añadir = new Placa(part1, part2, parte3);
                                for (Casa cliente : casas) {
                                    if (nif.equalsIgnoreCase(cliente.getNif())) {
                                        if (cliente.comprobarPlaca(part1) == false) {
                                            System.out.println(Condiciones.ESPAI_PLACA);
                                        } else {
                                            cliente.addPlaca(añadir);
                                        }
                                    } else {
                                        System.out.println(Condiciones.CASA_NOREGISTRADA);
                                    }
                                }
                            } else {
                                if (part1 <= 0) {
                                    System.out.println(Condiciones.SUPERFICIE_CASA);
                                } else if (part2 <= 0) {
                                    System.out.println(Condiciones.PREU_PLACA);
                                } else if (parte3 <= 0) {
                                    System.out.println(Condiciones.POTENCIA);
                                }
                            }
                        } else {
                            System.out.println(Condiciones.PARAMETRES + Condiciones.ADDPLACA);
                        }
                        break;

                    case "addAparell":
                        if (parts.length == 4) {
                        String nom = parts[2];
                        float potencia = Float.parseFloat(parts[3]);
                        for (Casa cliente : casas) {
                            if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                                if ((cliente.comprobarAparell(nom)).equalsIgnoreCase("registrar")) {
                                    if (potencia > 0) {
                                        Aparell nuevo = new Aparell(nom, potencia);
                                        cliente.addAparell(nuevo);
                                    } else {
                                        System.out.println(Condiciones.POTENCIA);
                                    }
                                } else {
                                    System.out.println(Condiciones.APARELL_REGISTRAT);
                                }
                            } else {
                                System.out.println(Condiciones.CASA_NOREGISTRADA);
                            }
                        }
                        } else {
                            System.out.println(Condiciones.PARAMETRES + Condiciones.ADDAPARELL);
                        }

                            break;
                        
                    case "onCasa":
                        if (parts.length == 2) {
                        for (Casa cliente : casas) {
                            if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                                if ((cliente.getInterruptor()).equalsIgnoreCase("Activat")) {
                                    System.out.println(Condiciones.CASA_ENCESA);
                                } else {
                                    cliente.turnOnCasa("Activat");
                                    System.out.println("OK: Interruptor general activat.");
                                }
                            } else {
                                System.out.println(Condiciones.CASA_NOREGISTRADA);
                            }
                        }
                        } else {
                            System.out.println(Condiciones.COMANDA + Condiciones.ONCASA);
                        }
                        break;

                    case "onAparell":
                        if (parts.length == 3) {
                        for (Casa cliente : casas) {
                            if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                                cliente.findAparato(parts[2], parts[0], cliente);
                            }
                        }
                        } else {
                            System.out.println(Condiciones.PARAMETRES + Condiciones.ONAPARELL);
                        }
                        break;

                    case "offAparell":
                        if (parts.length == 3 ) {
                        for (Casa cliente : casas) {
                            if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                                cliente.findAparato(parts[2], parts[0], cliente);
                            } else {
                                System.out.println(Condiciones.CASA_NOREGISTRADA);
                            }
                        }
                        } else{
                            System.out.println(Condiciones.PARAMETRES + Condiciones.OFFAPARELL);
                        }
                        break;

                    case "list":
                        if (!casas.isEmpty()){
                        int contador = 0;
                        System.out.println("--- Endolls Solars, S.L. ---");
                        System.out.println("Cases enregistrades: " + casas.size());
                        System.out.println(" ");
                        for (Casa cliente : casas) {
                            contador = contador + 1;
                            System.out.println("Casa" + " " +contador);
                            cliente.listCasa();
                            System.out.println(" ");
                        }
                        } else {
                            System.out.println("No hi ha cases registrades.");
                        }
                        break;

                    case "info":
                        for (Casa cliente : casas) {
                            if (parts[1].equalsIgnoreCase(cliente.getNif())) {
                                cliente.infoCasa();
                            }else {
                System.out.println(Condiciones.COMANDA);
                        }
                        break;
                }
            } 
            }
        }while (!comando.equalsIgnoreCase("quit"));
    }
}
