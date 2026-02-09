/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Model.*;

/**
 *
 * @author ruben
 */
public class Menu_Client extends Menu {

    public Menu_Client(ROLS rol) {
        setRol(rol);
    }
    
@Override
    public void inicialitzarMenu() {
        afegirOpcioMetode("Consultar Reserva", () -> cercarObjecte(FITXERS.RESERVA));
        afegirOpcioMetode("Llista de les Meves Reservas", () -> llistarObjecte(FITXERS.RESERVA, 1));
        afegirOpcioMetode("Tornar a Iniciar Sessio", () -> tornar(true));
    }
}
