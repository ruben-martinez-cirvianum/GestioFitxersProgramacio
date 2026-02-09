/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Comandes { // AQUI S'EXECUTEN METODES RECURRENTS DE UTILITAT PER TOT EL PROGRAMA

    // HE CREAT UN METODE PER FACILITAR EL PRINT PER TERMINAL, TAMBE EM PREMET MODIFICAR TOT
    public static void print(String text, boolean ln) {
            if (ln) {
                System.out.println(text);
            } else {
                System.out.print(text);
            }
    }

    /*HE CREAT UN METODE QUE S'ENCARREGARA DE AGAFAR LES DADES DEL ESCANER, 
    PER EVITAR PROBLEMES AMB EL ESCANER TOTS EL RESULTATS SERAN TIPUS STRING*/
    public static String scanner() {
        Scanner sc = new Scanner(System.in);
        String text = null;
        do { // EVITA UNA DADA INCORRECTA I FA QUE TORNIS A ENTRA UNA DADA VALIDA
            try {
                text = sc.nextLine();
                if (text.trim().isEmpty()) {
                    throw new Exception("Input no valid");
                }
                break; // valid string
            } catch (Exception e) {
                System.err.println("Input no valid. Torna a intentar-ho.");
            }
        } while (text != null);
        return text.trim();
    }

    // ES UN METODO QUE EM SERVEIX PER CENTRAR EL TEXT EN ELS MENUS
    public static String centrarText(String text, Integer lenght) {
        lenght = lenght - text.length();
        int x = (lenght % 2 == 0) ? lenght / 2 : lenght / 2 + 1;
        int y = (lenght % 2 == 0) ? lenght / 2 : lenght / 2;
        return " ".repeat(x) + text + " ".repeat(y);
    }

    // ES UN CONVERSOR QUE TRANSFORMA UNA LLISTA(ARRAY) A UNA LINEA(STRING) 
    public static String atributsToString(String[] atributs) {
        String linea = "";
        for (String atribut : atributs) {
            linea = linea.concat(" | " + atribut);
        }
        return linea;
    }
    
    // ES UN CONVERSOR QUE TRANSFORMA UNA LINEA(STRING) A UNA LLISTA(ARRAY)
    public static String[] stringToArray(String linea) {
        String[] array = linea.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }
}
