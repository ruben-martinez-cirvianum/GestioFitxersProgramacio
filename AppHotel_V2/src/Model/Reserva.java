/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controlador.*;
import java.time.LocalDateTime;

/**
 *
 * @author ruben
 */
public class Reserva extends FitxersObjecte{

    public Reserva(String inputAtributs) {
        super.keyId = "idReserva";
        super.rutaFitxer = "reservas";
        constructorAtributs();
        insertarAtributs(Comandes.stringToArray(inputAtributs));

    } 
    
    public Reserva() {
        super.keyId = "idReserva";
        super.rutaFitxer = "reservas";
        constructorAtributs();
        
    }

    @Override
    public void constructorAtributs() { //idReserva nifReserva numHabitacioReserva HoraDataEntrada HoraDataSortida preuTotalServeis preuFactura pagat 
        afegirAtribut("idReserva", new Atribut(ATRIBUT_TIPUS.NUM));
        afegirAtribut("nifReserva", new Atribut(ATRIBUT_TIPUS.DNI));
        afegirAtribut("numHabitacioReserva", new Atribut(ATRIBUT_TIPUS.NUM));
        afegirAtribut("HoraDataEntrada", new Atribut(ATRIBUT_TIPUS.TIME));
        afegirAtribut("HoraDataSortida", new Atribut(ATRIBUT_TIPUS.TIME));
        afegirAtribut("preuTotalServeis", new Atribut(ATRIBUT_TIPUS.PREU));
        afegirAtribut("preuFactura", new Atribut(ATRIBUT_TIPUS.PREU));
        afegirAtribut("pagat", new Atribut(ATRIBUT_TIPUS.ESTAT));
        afegirAtribut("serveisDemanats", new Atribut(ATRIBUT_TIPUS.STRING));
    }  

    @Override
    public void constructorObjecte() {
        llistaAtributs.get(0).setValor((GestioFitxers.seleccionarLineas("reservas")==null)? 1 : GestioFitxers.seleccionarLineas("reservas").size()+1);
        Comandes.print("Introdueix el (NIF) del Client", true); 
        llistaAtributs.get(1).setValor(Controlador.validarInput(ATRIBUT_TIPUS.DNI));
        Comandes.print("Introdueix el (NUM HABITACIO) de la Reserva", true); 
        llistaAtributs.get(2).setValor(Controlador.validarInput(ATRIBUT_TIPUS.NUM));
        llistaAtributs.get(3).setValor(LocalDateTime.now());
        llistaAtributs.get(4).setValor(LocalDateTime.now());
        llistaAtributs.get(5).setValor(0.00);
        llistaAtributs.get(6).setValor(Boolean.FALSE);
    }
}
