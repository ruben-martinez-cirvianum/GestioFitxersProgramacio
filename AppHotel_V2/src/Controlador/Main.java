/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Model.Atribut;
import Vista.*;
import Model.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ruben
 */

public class Main {

    // INICIALITZACIO DE ATRIBUTS
    private static FitxersObjecte sessioActual;
    private static Menu menuActual;
    private static boolean tancarApp;

    public static void main(String[] args) {
        iniciarAPP();
    }

    //JUNTA ELS METODES NECESARIS PER INICIAR LA APP CORRECTAMENT Y LA MANTE OBERTA FINS QUE DECIDEIXIS SORTIR
    private static void iniciarAPP() {
        tancarApp = true;
        crearFitxers();
        do {
            ferLogin();
        } while (tancarApp);
    }

    //AQUEST METODE GENERARA EL FITXERS NECESARIS PER LA PERSISTENCIA
    public static void crearFitxers() {
        GestioFitxers.crearFitxer("usuaris");
        GestioFitxers.crearFitxer("clients");
        GestioFitxers.crearFitxer("serveis");
        GestioFitxers.crearFitxer("reservas");
        GestioFitxers.crearFitxer("habitacions");
    }

    // MENU LOGIN
    public void menuLogin() {

    }

    //GESTIO DE USUARIS Y LOGIN
    public static void ferLogin() {
        String nom = null;
        String contrasenya = null;
        do { // LOOP PER EVITA
            Comandes.print("Introdueix nom Usuari: ", false);
            nom = Comandes.scanner();
            Comandes.print("Introdueix Contrasenya: ", false);
            contrasenya = Comandes.scanner();
        } while (!tryLogin(nom, contrasenya));
        carregarMenu();
    }

    private static boolean tryLogin(String nom, String contrasenya) {
        boolean loginCorrecte = false;
        String usuariLogin = cercarUsuari(nom); // Cerca el usuari
        if (usuariLogin != null) { // Verifica que no es null, si es null vol dir que no s'ha trobat
            if (validarContrasenya(usuariLogin, contrasenya)) { // Valida que la contrasenya es correcte
                loginCorrecte = true;
                carregarSessio(usuariLogin); // Carrega el Usuari en la APP
            } else {
                Comandes.print("Contrsenya Incorrecte", true);
            }
        } else {
            Comandes.print("Usuari no Trobat, torna a intentar-ho!!!", true);
        }
        return loginCorrecte; // Retorna si el login s'ha fet sense problemes
    }

    private static String cercarUsuari(String nom) {
        String usuariTrobat = null;
        try {
            ArrayList<String> liniaActual = GestioFitxers.seleccionarLineas(FITXERS.USUARI.getNomFitxer(), nom, 0);
            if (!(liniaActual == null)) {
                usuariTrobat = liniaActual.get(0);
            }
        } catch (Exception e) {
        }
        System.out.println("-".repeat(100));
        return usuariTrobat;
    }

    private static boolean validarContrasenya(String usuari, String contrasenya) {
        boolean esValida = false;
        String[] atributs = Comandes.stringToArray(usuari);
        if (atributs[1].equals(contrasenya)) {
            esValida = true;
        }
        return esValida;
    }

    private static void carregarSessio(String usuari) {
        sessioActual = new Usuari(usuari);
    }

    /* GESTIO MENUS */
    private static void carregarMenu() {
        Atribut linea = (Atribut)sessioActual.getAtribut(2);
        switch ((ROLS) linea.getValor()) {
            case CLIENT ->
                menuActual = new Menu_Client(ROLS.CLIENT);
            case ADMIN ->
                menuActual = new Menu_Admin(ROLS.ADMIN);
            case RECEPCIO ->
                menuActual = new Menu_Recep(ROLS.RECEPCIO);
        }
        menuActual.iniciarMenu();
    }
}
