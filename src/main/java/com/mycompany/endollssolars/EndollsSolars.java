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

    static BaseDades bd = new BaseDades();     // instancia para llamar a la base de datos

    public static void main(String[] args) throws IOException {
        BufferedReader Consola = new BufferedReader(new InputStreamReader(System.in));

        String comando;     // variable del input

        do {        // hará todo el main mientras se cumpla la condicion
            System.out.print("> ");
            comando = Consola.readLine();
            String[] parts = comando.split(" ");    // nos permite separar el comando en partes
            String orden = parts[0];    // variable del comando principal

            switch (orden.toLowerCase()) {        // se le pasa una orden (ej addcasa) y el switch nos enviará al caso con ese nombre

                case "addcasa":
                    if (parts.length == 4) {    // le decimos que el comando tiene que tener 4 elementos para hacerse correctamente
                        addCasa(parts[1], parts[2], parts[3]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDCASA);   // error comando mal estructurado
                    }
                    break;      // el break nos permite salir del caso para poder pedir otro comando

                case "addplaca":
                    if (parts.length == 5) {
                        addPlaca(parts[1], parts[2], parts[3], parts[4]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDPLACA);
                    }
                    break;

                case "addaparell":
                    if (parts.length == 4) {
                        addAparell(parts[1], parts[2], parts[3]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ADDAPARELL);
                    }
                    break;

                case "oncasa":
                    if (parts.length == 2) {
                        onCasa(parts[1]);
                    } else {
                        System.out.println(Condiciones.COMANDA + Condiciones.ONCASA);
                    }
                    break;

                case "onaparell":
                    if (parts.length == 3) {
                        onAparell(parts[1], parts[2]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.ONAPARELL);
                    }
                    break;

                case "offaparell":
                    if (parts.length == 3) {
                        offAparell(parts[1], parts[2]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.OFFAPARELL);
                    }
                    break;

                case "list":
                    if (parts.length == 1) {
                        list();
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.LIST);
                    }
                    break;

                case "info":
                    if (parts.length == 2) {
                        info(parts[1]);
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.INFO);
                    }
                    break;
                    
                case "quit":
                    if (parts.length == 1) {
                        break;
                    } else {
                        System.out.println(Condiciones.PARAMETRES + Condiciones.QUIT);
                    }

                default:
                    System.out.println(Condiciones.COMANDA);
            }

        } while (!comando.equalsIgnoreCase("quit"));        // final del do: mientras el comando no sea quit
    }

    public static void addCasa(String nif, String nom, String superficie) {
        Casa cliente = bd.trobarNif(nif);       // variable para trabajar sobre una casa de la base de datos
        if (cliente == null) {      // comprobamos que la casa no está registrada
            if (Float.parseFloat(superficie) >= 10) {  
                Casa nueva = new Casa(nif, nom, Float.parseFloat(superficie));
                bd.afegirCasa(nueva);       // método que añade una casa
                System.out.println("OK: Casa registrada.");
            } else {
                System.out.println(Condiciones.SUPERFICIE_CASA);   
            }
        } else {
            System.out.println(Condiciones.CASA_REGISTRADA);   
        }
    }

    public static void addPlaca(String nif, String superficie, String preu, String potencia) {
        Casa cliente = bd.trobarNif(nif);
        Float part2 = Float.valueOf(superficie);
        Float part3 = Float.valueOf(preu);
        Float part4 = Float.valueOf(potencia);

        if (part2 > 0 && part3 > 0 && part4 > 0) {     // supercicie, precio y potencia han de ser mayores a 0
            Placa nueva = new Placa(part2, part3, part4);
            if (cliente != null) {      // comprobamos que la casa existe
                if (cliente.comprobarPlaca(part2) == true) {    // método que comprueba si hay espacio        
                    cliente.addPlaca(nueva);
                    System.out.println("OK: Placa afegida a la casa.");
                } else {
                    System.out.println(Condiciones.ESPAI_PLACA);
                }
            } else {
                System.out.println(Condiciones.CASA_NOREGISTRADA);
            }
        } else {    // en este else ponemos los errores correspondientes a la superficie, precio y potencia
            if (part2 <= 0) {
                System.out.println(Condiciones.SUPERFICIE_CASA);
            } else if (part3 <= 0) {
                System.out.println(Condiciones.PREU_PLACA);
            } else if (part4 <= 0) {
                System.out.println(Condiciones.POTENCIA);
            }
        }
    }

    public static void addAparell(String nif, String descripcio, String potencia) {
        Casa cliente = bd.trobarNif(nif);
        if (cliente != null) {
            if (cliente.findAparell(descripcio) == null) {    // llamamos al metodo en casa que nos dice si el aparato existe
                if (Float.parseFloat(potencia) > 0) {
                    Aparell nuevo = new Aparell(descripcio, Float.parseFloat(potencia));
                    cliente.addAparell(nuevo);
                    System.out.println("OK: Aparell afegit a la casa.");
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

    public static void onCasa(String nif) {
        Casa cliente = bd.trobarNif(nif);
        if (cliente != null) {
            if (cliente.getInterruptor() == true) {       // si el interruptor general esta encendido
                System.out.println(Condiciones.CASA_ENCESA);      // dará el error, la casa ya está encendida
            } else {
                cliente.turnOnCasa(true);      // activa la casa
                System.out.println("OK: Interruptor general activat.");
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }
    }

    public static void onAparell(String nif, String descripcio) {
        Casa cliente = bd.trobarNif(nif);
        if (cliente != null) {
            Aparell encendre = cliente.findAparell(descripcio);     // comprobamos si el aparato existe
            if (encendre != null) {
                if (cliente.getInterruptor() == true) {      // el interruptor general tiene que estar encendido
                    if (encendre.getInterruptor() == false) {       // el aparato tiene que estar apagado
                        encendre.turnOnAparell(true);
                        if (cliente.consumTotal() > cliente.potenciaTotal()) {  // comprobamos si saltan los plomos
                            cliente.turnOffAparells();      // método que apaga la casa
                            System.out.println(Condiciones.PLOMS_SALTATS);
                        } else {
                            System.out.println("OK: Aparell encés.");
                        }
                    } else {
                        System.out.println(Condiciones.APARELL_ENCES);  
                    }
                } else {
                    System.out.println(Condiciones.INTERRUPTOR_APAGAT);
                }
            } else {
                System.out.println(Condiciones.APARELL_NOREGISTRAT);
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }
    }

    public static void offAparell(String nif, String descripcio) {
        Casa cliente = bd.trobarNif(nif);
        if (cliente != null) {
            Aparell apagar = cliente.findAparell(descripcio);   // comprobamos si el aparato existe
            if (apagar != null) {
                if (apagar.getInterruptor() == true) {      // el aparato tiene que estar encendido
                    apagar.turnOffAparell(false);
                    System.out.println("OK: Aparell apagat.");
                } else {
                    if (apagar.getInterruptor() == false) {     // aparato que ya está apagado
                        System.out.println(Condiciones.APARELL_APAGAT);
                    }
                }
            } else {
                if (cliente.findAparell(descripcio) == null) {     // no ha encontrado ningun aparato
                    System.out.println(Condiciones.APARELL_NOREGISTRAT);
                }
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }
    }

    public static void list() {
        ArrayList<Casa> casas = bd.getBd();     // creamos una arraylist con el método de la base de datos para poder utilizar las casas
        if (!casas.isEmpty()) {      // comprobamos que la lista de casas no esté vacia
            int contador = 0;
            System.out.println("--- Endolls Solars, S.L. ---");
            System.out.println("Cases enregistrades: " + casas.size() + "\n");     // total de casas registradas
            for (Casa cliente : casas) {
                 contador = contador + 1;        // contador para numerar las casas registradas
                System.out.println("Casa" + " " + contador);             
                System.out.println("Client: " + cliente.getNif() + " - " + cliente.getNom());
                System.out.println("Superfície de teulada: " + cliente.getSuperficie());
                System.out.println("Superfície disponible: " + cliente.superficieRestant());
                if (cliente.getInterruptor() == true) {     // creamos 2 mensajes para que no nos salga true/false
                System.out.println("Interruptor general: encès");
                } else {
                    System.out.println("Interruptor general: apagat");
                }
                if (cliente.totalPlaca() > 0) {     // comprobamos si tiene placas instaladas
                    System.out.println("Plaques solars instal·lades: " + cliente.totalPlaca());
                } else {
                    System.out.println("No té plaques solars instal·lades.");
                }
                if (cliente.totalAparell() > 0) {       // comprobamos si tiene aparatos registrados
                    System.out.println("Aparells registrats: " + cliente.totalAparell() + "\n");
                } else {
                    System.out.println("No té cap aparell elèctric registrat. \n");
                }
            }
        } else {
            System.out.println("No hi ha cases registrades.");
        }
    }

    public static void info(String nif) {
        Casa cliente = bd.trobarNif(nif);
        if (cliente != null) {
        ArrayList<String> encesos = cliente.aparellsEncesos();  // aquí guardamos los aparatos encendidos ya que no necesitamos los apagados          
            System.out.println("Client: " + nif + " - " + cliente.getNom());
            if (cliente.totalPlaca() > 0) {     // comprobamos si tiene placas instaladas
                System.out.println("Plaques solars instal·lades: " + cliente.totalPlaca());
            } else {
                System.out.println("No té plaques solars instal·lades.");
            }
            System.out.println("Potència total: " + cliente.potenciaTotal() + "W");
            System.out.println("Inversió total: " + cliente.inversioTotal() + "€");
            if (cliente.totalAparell() > 0) {   // comprobamos si tiene aparatos registrados
                System.out.println("Aparells registrats: " + cliente.totalAparell());
            } else {
                System.out.println("No té cap aparell elèctric registrat.");
            }
            System.out.println("Consum actual: " + cliente.consumTotal() + "W");

            if (cliente.consumTotal() > 0) {    // si el consumo es mayor a 0 hay aparatos encendidos
                System.out.println("Aparells encesos:");
                for (String aparells : encesos) {       // bucle de aparatos encendidos
                    System.out.println("    -" + aparells);
                }
            } else {
                System.out.println(" ");    // si no hay nada encendido, que no haga el print de arriba
            }
        } else {
            System.out.println(Condiciones.CASA_NOREGISTRADA);
        }
    }

}
