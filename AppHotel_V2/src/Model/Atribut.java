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
public class Atribut {

    private ATRIBUT_TIPUS tipus;
    private Object valor;

    public Atribut(ATRIBUT_TIPUS tipus) {
        this.tipus = tipus;
    }
    
    public Atribut(ATRIBUT_TIPUS tipus, String atribut) {
        this.tipus = tipus;
        this.valor = atribut;
    }

    public ATRIBUT_TIPUS getTipus() {
        return tipus;
    }

    public void setTipus(ATRIBUT_TIPUS tipus) {
        this.tipus = tipus;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}    

