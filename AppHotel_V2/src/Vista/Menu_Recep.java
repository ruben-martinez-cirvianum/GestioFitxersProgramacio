/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class Menu_Recep extends Menu {

    public Menu_Recep(ROLS rol) {
        setRol(rol);
    }

    @Override
    public void inicialitzarMenu() {
        ArrayList<Opcions> opcionsClients = new ArrayList<>();
            opcionsClients.add(new Opcions_Metode("Donar Alta Client", () -> afegirObjecte(FITXERS.CLIENT)));
            opcionsClients.add(new Opcions_Metode("Cercar Client", () -> cercarObjecte(FITXERS.CLIENT)));
            opcionsClients.add(new Opcions_Metode("Llistar Clients", () -> llistarObjecte(FITXERS.CLIENT, 1)));
            opcionsClients.add(new Opcions_Metode("Tornar", () -> tornar(false)));
        afegirOpcioSubMenu("Gestio Clients", opcionsClients);
         ArrayList<Opcions> opcionsHabitacions = new ArrayList<>();
            opcionsHabitacions.add(new Opcions_Metode("Donar Alta Habitacio", () -> afegirObjecte(FITXERS.HABITACIO)));
            opcionsHabitacions.add(new Opcions_Metode("Cercar Habitacio", () -> cercarObjecte(FITXERS.HABITACIO)));
            opcionsHabitacions.add(new Opcions_Metode("Llistar Habitacio", () -> llistarObjecte(FITXERS.HABITACIO, 1)));
            opcionsHabitacions.add(new Opcions_Metode("Tornar", () -> tornar(false)));
        afegirOpcioSubMenu("Gestio Habitacions", opcionsHabitacions);
        ArrayList<Opcions> opcionsServeis = new ArrayList<>();
            opcionsServeis.add(new Opcions_Metode("Donar Alta Servei", () -> afegirObjecte(FITXERS.SERVEI)));
            opcionsServeis.add(new Opcions_Metode("Cercar Servei", () -> cercarObjecte(FITXERS.SERVEI)));
            opcionsServeis.add(new Opcions_Metode("Llistar Serveis", () -> llistarObjecte(FITXERS.SERVEI, 1)));
            opcionsServeis.add(new Opcions_Metode("Tornar", () -> tornar(false)));
        afegirOpcioSubMenu("Gestio Serveis", opcionsServeis);
        ArrayList<Opcions> opcionsReserves = new ArrayList<>();
            opcionsReserves.add(new Opcions_Metode("Donar Alta Reserves", () -> afegirObjecte(FITXERS.RESERVA)));
            opcionsReserves.add(new Opcions_Metode("Cercar Reserva", () -> cercarObjecte(FITXERS.RESERVA)));
            opcionsReserves.add(new Opcions_Metode("Llistar Reserva", () -> llistarObjecte(FITXERS.RESERVA, 1)));
            opcionsReserves.add(new Opcions_Metode("Tornar", () -> tornar(false)));
        afegirOpcioSubMenu("Gestio Reserves", opcionsReserves);
        afegirOpcioMetode("Tornar a Iniciar Sessio", () -> tornar(true));
    }
}
