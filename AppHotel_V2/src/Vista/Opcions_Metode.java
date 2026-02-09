/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author ruben
 */
public class Opcions_Metode extends Opcions{
    private Runnable metode;

    public Opcions_Metode(String comanda, Runnable metode) {
        super.comanda = comanda;
        this.metode = metode;
    }

    public Runnable getMetode() {
        return metode;
    }

    public void setMetode(Runnable metode) {
        this.metode = metode;
    }
    
}
