/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class Opcions_SubMenu extends Opcions{

    private ArrayList<Opcions> submenu;

    public Opcions_SubMenu(String comanda, ArrayList<Opcions>  submenu) {
        super.comanda = comanda;
        this.submenu = submenu;
    }

    public ArrayList<Opcions> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(ArrayList<Opcions> submenu) {
        this.submenu = submenu;
    }

}
