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
public class Client extends FitxersObjecte{

    public Client(String inputAtributs) {
        super.keyId = "nif";
        super.rutaFitxer = "clients";
        constructorAtributs();
        insertarAtributs(Comandes.stringToArray(inputAtributs));

    } 
    
    public Client() {
        super.keyId = "nif";
        super.rutaFitxer = "clients";
        constructorAtributs();
        
    }

    @Override
    public void constructorAtributs() {
        afegirAtribut("nif", new Atribut(ATRIBUT_TIPUS.STRING));
        afegirAtribut("nom", new Atribut(ATRIBUT_TIPUS.STRING));
        afegirAtribut("data", new Atribut(ATRIBUT_TIPUS.DATE));
    }  

    @Override
    public void constructorObjecte() {
        Comandes.print("Introdueix el (NIF) del Client", true); 
        llistaAtributs.get(0).setValor(Controlador.validarInput(ATRIBUT_TIPUS.DNI));
        Comandes.print("Introdueix el (NOM) del Client", true); 
        llistaAtributs.get(1).setValor(Controlador.validarInput(ATRIBUT_TIPUS.STRING));
         Comandes.print("Introdueix la (DATA NEIXAMENT) del Client: (YYYY-MM-DD)", true); 
        llistaAtributs.get(2).setValor(Controlador.validarInput(ATRIBUT_TIPUS.DATE));
    }
}
