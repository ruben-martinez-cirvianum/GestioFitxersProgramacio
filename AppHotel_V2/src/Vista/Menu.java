/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Model.Atribut;
import Controlador.*;
import Model.*;

import Model.FitxersObjecte;
import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public abstract class Menu {

    protected ArrayList<Opcions> menus;
    protected ArrayList<Opcions> menusMod;
    protected FitxersObjecte objecteSeleccionat;
    protected boolean sortir = false;
    protected ROLS rol;
    protected String lineaSelecionada;
    protected FITXERS tipusFitxerSelecionat;


    public Menu() {
        menus = new ArrayList<>();
        menusMod = new ArrayList<>();
    }

    public void iniciarMenu() {
        sortir = true;
        menusMod.add(new Opcions_Metode("Eliminar", ()-> eliminarObjecte()));
        menusMod.add(new Opcions_Metode("Modificar", ()-> modificarObjecte()));

        inicialitzarMenu();
        while (sortir) {
            System.out.println("MENU: " + rol.name());
            execMenu(menus);
        }
    }

    public void execMenu(ArrayList<Opcions> llistOpcions) {
        mostrarMenu(llistOpcions);
        controladorMenu(llistOpcions);
    }
    
    public void execMenu(ArrayList<Opcions> llistOpcions, String textExtra) {
        mostrarMenu(llistOpcions, textExtra);
        controladorMenu(llistOpcions);
    }

    public abstract void inicialitzarMenu();

    /* MENU */
    public void mostrarMenu(ArrayList<Opcions> llistaOpcions) {
        for (int i = 0; i < llistaOpcions.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + llistaOpcions.get(i).getComanda());
        }
    }
    
    public void mostrarMenu(ArrayList<Opcions> llistaOpcions, String textExtra) {
        for (int i = 0; i < llistaOpcions.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + llistaOpcions.get(i).getComanda() + " " +  textExtra);
        }
    }

    public void controladorMenu(ArrayList<Opcions> llistaOpcions) {
        int opcioValida = -1;
        do {
            Comandes.print("Escull una opcio: ", false);
            int opcio = Controlador.validarOpcio(Comandes.scanner(), llistaOpcions.size() + 1);
            if (opcio == -1) {
            } else {
                opcioValida = opcio;
            }
        } while (opcioValida == -1);
        Opcions opcio = llistaOpcions.get(opcioValida - 1);
        Comandes.print("-".repeat(100), true);
        Comandes.print(("Has escollit: " + opcio.getComanda()), true);

        if (opcio instanceof Opcions_Metode opcioMetode) {
            opcioMetode.getMetode().run();
        } else if (opcio instanceof Opcions_SubMenu opcioSubMenu) {
            execMenu(opcioSubMenu.getSubmenu());
        }
    }

    public void afegirOpcioMetode(String comanda, Runnable metode) {
        menus.add(new Opcions_Metode(comanda, metode));
    }

    public void afegirOpcioSubMenu(String comanda, ArrayList<Opcions> Opcions) {
        menus.add(new Opcions_SubMenu(comanda, Opcions));
    }

    public void tornar(boolean tornarLogin) {
        sortir = !tornarLogin;
    }
    public void execLlista(FITXERS tipusFitxers){
        llistarObjecte(tipusFitxers, 1);
    }

    public void llistarObjecte(FITXERS tipusFitxer, int page) {
        ArrayList<String> llista = GestioFitxers.seleccionarLineas(tipusFitxer.getNomFitxer(),(page*10)-10, page*10);
        visualitzarLlista(llista, tipusFitxer, page, 100);
        Comandes.print("Escull una opcio: ", false);
        interpretLlista(controladorLlista(llista), tipusFitxer, page, llista);
    }

    public void interpretLlista(String input, FITXERS tipusFitxer, int page, ArrayList<String> llista) {
        switch (input.toUpperCase()) {
            case "A" -> {
                page = Controlador.gestorPagines(page, llista.size(), false);
                llistarObjecte(tipusFitxer, page);
            }
            case "D" -> {
                page = Controlador.gestorPagines(page, llista.size(), true);
                llistarObjecte(tipusFitxer, page);
            }
            case "R" -> tornar(false);
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> menuLlista(llista.get(Controlador.validarOpcio(input, llista.size())), tipusFitxer);
        }
    }
    
    public void menuLlista(String llista, FITXERS tipusFitxers) {
        this.lineaSelecionada = llista;
        this.objecteSeleccionat = creacioObjecte(tipusFitxers, llista);
        this.tipusFitxerSelecionat = tipusFitxers;
        execMenu(menusMod, tipusFitxers.getNomFitxer().substring(0, tipusFitxers.getNomFitxer().length()-1));

    }

    public String controladorLlista(ArrayList<String> llista) {
        int numOpcions = llista.size() - 1;
        String opcioValida = null;
        do {
            String opcio = Comandes.scanner();
            opcio = opcio.toUpperCase();
            if (!(Controlador.validarComanda(opcio, numOpcions, "ADR").equalsIgnoreCase("Z"))) {
                opcioValida = opcio;
            }
        } while (opcioValida == null);
        return opcioValida;
    }

    public void visualitzarLlista(ArrayList<String> llista, FITXERS tipusFitxers, int pagina, Integer ancho) {
        System.out.println("-".repeat(ancho));
        System.out.println(Comandes.centrarText("TAULA SELECCIONADA: " + tipusFitxers + " | PAGINA (" + pagina + ")", ancho));
        System.out.println("-".repeat(ancho));
        System.out.println("NUM" + Comandes.atributsToString(tipusFitxers.getLineaAtributs()));
        System.out.println("-".repeat(ancho));

        for (int i = 0; i < llista.size(); i++) {
            if (!(llista.get(i) == null)) {
                System.out.println(Comandes.centrarText(i + "", 3) + "| " + llista.get(i));
            }
        }
        System.out.println("-".repeat(ancho));
        System.out.println(Comandes.centrarText("[<-(A)] [Seleccionar " + tipusFitxers.getNomFitxer().toUpperCase() + "] [Tornar(R)] [(D)->]", ancho));
        System.out.println("-".repeat(ancho));
    }

    public void afegirObjecte(FITXERS tipusFitxers) {
        FitxersObjecte obj = creacioObjecte(tipusFitxers);
        obj.constructorObjecte();
        GestioFitxers.insertarLinea(tipusFitxers.getNomFitxer(), obj.formatRegistre());
        GestioFitxers.creacioLog("S'ha afegit un nou registre (" + tipusFitxers.getNomFitxer()+") : [" + obj.formatRegistre() + "]");

    }
    
    public FitxersObjecte creacioObjecte(FITXERS tipusFitxers){
        FitxersObjecte obj = null;
        switch (tipusFitxers) {
            case FITXERS.CLIENT -> obj = new Client();
            case FITXERS.USUARI -> obj = new Usuari();
            case FITXERS.HABITACIO -> obj = new Habitacio();
            case FITXERS.RESERVA -> obj = new Reserva();
            case FITXERS.SERVEI -> obj = new Servei();
        }
        return obj;
    }
    
    public FitxersObjecte creacioObjecte(FITXERS tipusFitxers, String inputAtributs){
        FitxersObjecte obj = null;
        switch (tipusFitxers) {
            case FITXERS.CLIENT -> obj = new Client(inputAtributs);
            case FITXERS.USUARI -> obj = new Usuari(inputAtributs);
            case FITXERS.HABITACIO -> obj = new Habitacio(inputAtributs);
            case FITXERS.RESERVA -> obj = new Reserva(inputAtributs);
            case FITXERS.SERVEI -> obj = new Servei(inputAtributs);
        }
        return obj;
    }

    public void eliminarObjecte() {
        GestioFitxers.eliminarLineas(tipusFitxerSelecionat.getNomFitxer(), objecteSeleccionat.formatRegistre());
        GestioFitxers.creacioLog("S'ha eliminat un registre: [" + objecteSeleccionat.formatRegistre() + "]");
    }
    
    public void modificarObjecte() {
        ArrayList<String> llistaAtributs = objecteSeleccionat.getAtributs();
        for (int i = 0; i < llistaAtributs.size(); i++) {
            System.out.println(i+ ". " + llistaAtributs.get(i));
        }
        Comandes.print("Seleciona la opcio que vols modificar:", false);
        Atribut atributSelecionat;
        atributSelecionat = (Atribut) objecteSeleccionat.getAtribut(Controlador.validarOpcio(Comandes.scanner(), llistaAtributs.size()));
        atributSelecionat.setValor(Controlador.validarInput(atributSelecionat.getTipus()));
        GestioFitxers.actualizarLineas(tipusFitxerSelecionat.getNomFitxer(), lineaSelecionada, objecteSeleccionat.formatRegistre());
        GestioFitxers.creacioLog("S'ha modificat el registre: [" + objecteSeleccionat.formatRegistre() + "]");

    }

    public void cercarObjecte(FITXERS tipusFitxers) {
        Comandes.print("Introdueix el " + tipusFitxers.getKeyId() + " de " + tipusFitxers.getNomFitxer().substring(0, tipusFitxers.getNomFitxer().length()-1).toUpperCase() + " del fitxer (" + tipusFitxers.getNomFitxer().toUpperCase() +"): ", false);
        String linea = GestioFitxers.seleccionarLineas(tipusFitxers.getNomFitxer(), Comandes.scanner(), 0).get(0); // FALTA IMPLEMENTA CERCA
        
// tendria que ser un array
        if(linea == null){
            System.out.println("-".repeat(100));
            System.err.println("No s'ha trobat el " + tipusFitxers.getNomFitxer().substring(0, tipusFitxers.getNomFitxer().length()-1).toUpperCase());
            tornar(false);
        } else {
            System.out.println("-".repeat(100));
            System.out.println("S'ha trobat el seguent servei: (" + linea +")");
            menuLlista(linea, tipusFitxers);   
        }
    }

    public ROLS getRol() {
        return rol;
    }

    public void setRol(ROLS rol) {
        this.rol = rol;
    }
}
