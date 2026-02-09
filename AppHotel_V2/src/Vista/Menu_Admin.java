/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Model.*;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class Menu_Admin extends Menu{

    public Menu_Admin(ROLS rol) {
        setRol(rol);
    }

    @Override
    public void inicialitzarMenu() {
        afegirOpcioMetode("Donar Alta Usuari", () -> afegirObjecte(FITXERS.USUARI));
        afegirOpcioMetode("Cercar Usuari", () -> cercarObjecte(FITXERS.USUARI));
        afegirOpcioMetode("Llistar Usuari", () -> llistarObjecte(FITXERS.USUARI,1));
        afegirOpcioMetode("Tornar a Iniciar Sessio", () -> tornar(true));       
    }
    
    
    
}
