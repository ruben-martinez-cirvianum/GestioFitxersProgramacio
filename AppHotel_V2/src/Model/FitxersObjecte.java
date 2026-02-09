/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Controlador.Controlador;
import Vista.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ruben
 */
public abstract class FitxersObjecte {
    protected ArrayList<Atribut> llistaAtributs;
    protected String keyId;
    protected String rutaFitxer;
    protected ArrayList<String> keys;

    public FitxersObjecte() {
        this.llistaAtributs = new ArrayList();
        this.keys = new ArrayList<>();
    }
    
    public abstract void constructorAtributs();
    
    public abstract void constructorObjecte();
        
    public void insertarAtributs(String[] atributs){
        for (int i = 0; i < llistaAtributs.size(); i++) {
            llistaAtributs.get(i).setValor(Controlador.conversor(llistaAtributs.get(i).getTipus(), atributs[i]));
        }
    }
    
    public void afegirAtribut(String key, Atribut atribut){
        this.keys.add(key);
        this.llistaAtributs.add(atribut);
    }

    public Object getAtribut(int index){
        return this.llistaAtributs.get(index);
    }
    
    public void setAtribut(int index, Atribut atribut){
        this.llistaAtributs.set(index, atribut);
    }

    public ArrayList<Atribut> getLlistaAtributs() {
        return llistaAtributs;
    }

    public void setLlistaAtributs(ArrayList<Atribut> llistaAtributs) {
        this.llistaAtributs = llistaAtributs;
    }

    public ArrayList<String> getAtributs() {
        return keys;
    }

    public void setAtributs(ArrayList<String> atributs) {
        this.keys = atributs;
    }
    
    public void assignarAtribut(int index, Object valor){
        this.llistaAtributs.get(index).setValor(valor);
    }
    
    public String formatRegistre() {
        ArrayList<String> llista = new ArrayList<>();
        for (Atribut llistaAtribut : llistaAtributs) {
            String linea = String.valueOf(llistaAtribut.getValor());
            llista.add(linea);
        }
        String lineaRegistre = String.join(" ", llista);
        return lineaRegistre.trim();
    }    
    
    @Override
    public String toString() {
        return "llistaAtributs=" + llistaAtributs + '}';
    }
}
