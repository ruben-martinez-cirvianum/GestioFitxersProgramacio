/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controlador.Comandes;
import Controlador.Controlador;
import java.util.HashMap;

/**
 *
 * @author ruben
 */
public class Usuari extends FitxersObjecte{

    public Usuari(String inputAtributs) {
        super.keyId = "nom";
        super.rutaFitxer = "usuaris";
        constructorAtributs();
        insertarAtributs(Comandes.stringToArray(inputAtributs));
    } 
    
    public Usuari() {
        super.keyId = "nom";
        super.rutaFitxer = "usuaris";
        constructorAtributs();

    }

    @Override
    public void constructorAtributs() {
        afegirAtribut("nom", new Atribut(ATRIBUT_TIPUS.STRING));
        afegirAtribut("contrasenya", new Atribut(ATRIBUT_TIPUS.PASSWORD));
        afegirAtribut("rol", new Atribut(ATRIBUT_TIPUS.ROLS));
    }   

    @Override
    public void constructorObjecte() {
        Comandes.print("Introdueix el (NOM) del Usuari", true); 
        this.llistaAtributs.get(0).setValor(Controlador.validarInput(ATRIBUT_TIPUS.STRING));
        Comandes.print("Introdueix el (CONTRASENYA) del Usuari ([A-Z][a-z][0-9])", true); 
        this.llistaAtributs.get(1).setValor(Controlador.validarInput(ATRIBUT_TIPUS.PASSWORD));
        Comandes.print("Introdueix la (ROLS) del Client: (ADMIN, RECEPCIO, CLIENT)", true); 
        this.llistaAtributs.get(2).setValor(Controlador.validarInput(ATRIBUT_TIPUS.ROLS));    
    }
}
