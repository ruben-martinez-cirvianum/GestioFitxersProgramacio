/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class GestioFitxers { // GESTIONA LA COMUNICACIO AMB ELS FITXERS

    // VARIABLE QUE DETERMINAN LA RUTA Y EL TIPUS DE FITXER, SERIA MILLOR UTILITZAR LA LLIBRERIA PATH
    public static final String RUTA_PER_DEFECTE = "src/fitxers/";
    public static final String TIPUS_FITXERS = ".txt";

    //ME INSPIRAT EN LA MANERA DE CONSULTAR EN UNA BASE DE DADES, SELECT, UPDATE, DELETE, INSERT
    // EN AQUEST CAS HE CREAT UN METODE QUE ENS PERMET FER LA FUNCIONALITAT DE UN SELECT PERO DE MANERA REDUIDA. 
    public static ArrayList<String> seleccionarLineas(String rutaFitxer, int minIndex, int maxIndex, String textACercar, int atribut) {
        ArrayList<String> lineasSeleccionades = new ArrayList<>();
        Integer contador = -1;
        try {
            File lector = new File(RUTA_PER_DEFECTE + rutaFitxer + TIPUS_FITXERS);
            Scanner sc = new Scanner(lector);
            while (sc.hasNextLine()) {
                contador++;
                String linea = sc.nextLine();
                if (intervalLineas(contador, minIndex, maxIndex)) {
                    String[] lineas = linea.split("\\s+");
                    if (!(textACercar == null)) {
                        if (lineas[atribut].toLowerCase().equals(textACercar.toLowerCase())) {
                            lineasSeleccionades.add(linea);
                        }
                    } else {
                        lineasSeleccionades.add(linea);
                    }
                }
            }
            if (lineasSeleccionades.isEmpty()) {
                lineasSeleccionades = null;
            }
        } catch (IOException e) {
            System.err.println("No s'ha pogut seleccionar les linies del Fitxer");
        }
        return lineasSeleccionades;
    }

    //AQUI SOBREESCRIC EL METODE VARIES VEGADE PER FICAR CONFIGUACIONS DEFAULTS PER UNA CERCA MES SENCILLA, 
    //HO FAIG CRIDAN EL METODE PERO AMB VALORS DEFAULS Y DIFERENTS INPUTS Y OUTPUTS
    public static String seleccionarLineas(String rutaFitxer, int index) {
        ArrayList<String> lineas = seleccionarLineas(rutaFitxer, index, index, null, 0);
        String linea = "No s'ha pugut selecionar";
        if (!lineas.isEmpty()) {
            linea = lineas.get(0);
        }
        return linea;
    }

    public static ArrayList<String> seleccionarLineas(String rutaFitxer) {
        return seleccionarLineas(rutaFitxer, -1, -1, null, 0);
    }

    public static ArrayList<String> seleccionarLineas(String rutaFitxer, String textACercar, int indexAtribut) {
        return seleccionarLineas(rutaFitxer, -1, -1, textACercar, indexAtribut);
    }

    public static ArrayList<String> seleccionarLineas(String rutaFitxer, int minIndex, int maxIndex) {
        return seleccionarLineas(rutaFitxer, minIndex, maxIndex, null, 0);
    }

    //AQUEST METODE SERVEIX PER DETERMINAR QUINA LINIA ES LLEGIDA DEPENENTS DE UNS PARAMETRES, AIXI PUC RETORNA EL QUE NECESSITI
    public static boolean intervalLineas(int contador, int minIndex, int maxIndex) {
        boolean valid = false;
        if (!(maxIndex == -1)) {
            if ((minIndex == maxIndex) && (contador == maxIndex)) {
                valid = true;
            } else {
                if (contador >= minIndex && contador < maxIndex) {
                    valid = true;
                }
            }
        } else {
            valid = true;
        }
        return valid;
    }

    //SERVEIX PER ELIMINAR LES LINEAS DEL ARRAY Y A CONTINUACIO GUARDARLO
    public static void eliminarLineas(String rutaFitxer, ArrayList<String> lineasABorrar) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas = seleccionarLineas(rutaFitxer);
        if (!(lineas == null)) {
            lineas.removeAll(lineasABorrar);
            escriureLineas(rutaFitxer, lineas);
        } else {
            System.err.println("No s'ha pogut eliminar la linea");
        }

    }

    //SERVEIX PER ELIMINAR UNA UNICA LINEA Y GUARDARLO
    public static void eliminarLineas(String rutaFitxer, String lineasABorrar) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas = seleccionarLineas(rutaFitxer);
        if (!(lineas == null)) {
            lineas.remove(lineasABorrar);
            escriureLineas(rutaFitxer, lineas);
        } else {
            System.err.println("No s'ha pogut eliminar la linea");
        }

    }

    //SERVEIX PER MODIFICAR LINEAS
    public static void actualizarLineas(String rutaFitxer, String antiguaLinea, String novaLinea) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas = seleccionarLineas(rutaFitxer);
        lineas.set(lineas.indexOf(antiguaLinea), novaLinea);
        escriureLineas(rutaFitxer, lineas);
    }

    //SERVEIX PER REESCRIURE EL DOCUMENT AL FER UNA MODIFICACIO
    public static void escriureLineas(String rutaFitxer, ArrayList<String> lineas) {
        try {
            FileWriter myWriter = new FileWriter(RUTA_PER_DEFECTE + rutaFitxer + TIPUS_FITXERS, false);
            for (String linea : lineas) {
                myWriter.write(linea + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("No s'ha pogut afegir el registre");
            e.printStackTrace();
        }
    }

    //FA LA FUNCIO DE AFEGIR UN NOU REGISTRE A EL DOCUMENT
    public static void insertarLinea(String rutaFitxer, String novaLinea) {
        try {
            FileWriter myWriter = new FileWriter(RUTA_PER_DEFECTE + rutaFitxer + TIPUS_FITXERS, true);
            myWriter.write(novaLinea + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("No s'ha pogut afegir el registre");
            e.printStackTrace();
        }
    }
    
        public static void insertarLineaLog(String rutaFitxer, String novaLinea) {
        try {
            FileWriter myWriter = new FileWriter(rutaFitxer + TIPUS_FITXERS, true);
            myWriter.write(novaLinea + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("No s'ha pogut afegir el registre");
            e.printStackTrace();
        }
    }

    //SERVEIX PER CREAR EL DOCUMENT NORMALMENT ES CREEN TOTS AL INICI DEL PROGRAMA
    public static void crearFitxer(String nomFitxer, String rutaFitxer) {
        try {
            File myObj = new File(rutaFitxer + nomFitxer + TIPUS_FITXERS);
            if (myObj.createNewFile()) {
                System.out.println("Fitxer creat: " + myObj.getName());
            }
        } catch (IOException e) {
        }
    }

    public static void crearFitxer(String nomFitxer) {
        crearFitxer(RUTA_PER_DEFECTE, nomFitxer);
    }

    //SERVEIX PER ELIMINAR UN FITXER NO GAIRE UTIL PERO NO ESTA MAL
    public static void eliminarFitxer(String rutaFitxers) {
        File fitxer = new File(rutaFitxers);
        fitxer.delete();
    }
    
    public static void creacioLog(String linia) {
        crearFitxer(LocalDate.now().toString(), "src/log/");
        insertarLineaLog("src/log/"+ LocalDate.now().toString(), (LocalDateTime.now() + ": " + linia));
    }

}
