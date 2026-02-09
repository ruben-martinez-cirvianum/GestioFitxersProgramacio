/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controlador.*;

/**
 *
 * @author ruben
 */
public class Habitacio extends FitxersObjecte{

    public Habitacio(String inputAtributs) {
        super.keyId = "nif";
        super.rutaFitxer = "clients";
        constructorAtributs();
        insertarAtributs(Comandes.stringToArray(inputAtributs));

    } 
    
    public Habitacio() {
        super.keyId = "nif";
        super.rutaFitxer = "clients";
        constructorAtributs();
        
    }

    @Override
    public void constructorAtributs() { // numero preuNit estat
        afegirAtribut("numero", new Atribut(ATRIBUT_TIPUS.NUM));
        afegirAtribut("preuNit", new Atribut(ATRIBUT_TIPUS.PREU));
        afegirAtribut("estat", new Atribut(ATRIBUT_TIPUS.ESTAT));
    }  

    @Override
    public void constructorObjecte() {
        Comandes.print("Introdueix el (NUMERO) de la Habitacio", true); 
        llistaAtributs.get(0).setValor(Controlador.validarInput(ATRIBUT_TIPUS.NUM));
        Comandes.print("Introdueix el (PREU) de la Habitacio", true); 
        llistaAtributs.get(1).setValor(Controlador.validarInput(ATRIBUT_TIPUS.PREU));
         Comandes.print("Introdueix la (ESTAT) dde la Habitacio: ", true); 
        llistaAtributs.get(2).setValor(Controlador.validarInput(ATRIBUT_TIPUS.ESTAT));
    }
}
