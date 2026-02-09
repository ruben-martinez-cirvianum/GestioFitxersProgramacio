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
public class Servei extends FitxersObjecte{

    public Servei(String inputAtributs) {
        super.keyId = "id";
        super.rutaFitxer = "serveis";
        constructorAtributs();
        insertarAtributs(Comandes.stringToArray(inputAtributs));

    } 
    
    public Servei() {
        super.keyId = "id";
        super.rutaFitxer = "serveis";
        constructorAtributs();
        
    }

    @Override
    public void constructorAtributs() { //id descripcio preu
        afegirAtribut("id", new Atribut(ATRIBUT_TIPUS.NUM));
        afegirAtribut("descripcio", new Atribut(ATRIBUT_TIPUS.STRING));
        afegirAtribut("preu", new Atribut(ATRIBUT_TIPUS.PREU));
    }  

    @Override
    public void constructorObjecte() {
        Comandes.print("Introdueix el (ID) de Servei", true); 
        llistaAtributs.get(0).setValor(Controlador.validarInput(ATRIBUT_TIPUS.NUM));
        Comandes.print("Introdueix el (DESCRIPCIO) de Servei", true); 
        llistaAtributs.get(1).setValor(Controlador.validarInput(ATRIBUT_TIPUS.STRING));
         Comandes.print("Introdueix la (PREU) de Servei: ", true); 
        llistaAtributs.get(2).setValor(Controlador.validarInput(ATRIBUT_TIPUS.PREU));
    }
}
