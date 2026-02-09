/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.ROLS;
import Model.ATRIBUT_TIPUS;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ruben
 */
public class Controlador { // SON METODES UTILS PER LA INTERACCIO AMB EL USUARI

    public static int validarOpcio(String input, Integer rang) {
        int opcioValida = -1;
        boolean valid = true;
        for (int i = 0; i < input.length(); i++) {
            if (!input.matches("[0-9]+")) {
                valid = false;
            }
        }
        if (valid) {
            int opcio = Integer.parseInt(input);
            if (opcio <= rang) {
                opcioValida = Integer.parseInt(input);
            } else {
                System.err.print("Opcio no valida, no esta dintre de les funcions, torna a provar: ");
            }
        } else {
            System.err.print("Opcio no valida, no has introduit un valor valid, torna a provar: ");
        }
        return opcioValida;
    }

    public static String validarComanda(String input, int numOpcions, String opcionsValides) {
        boolean valid = false;
        if (input.matches("[A-Za-z]")) { //Identificar si es Int o String
            for (int i = 0; i < opcionsValides.length(); i++) {
                if (input.charAt(0) == opcionsValides.charAt(i)) {
                    valid = true;
                }
            }
            if (!valid) {
                input = "Z";
                System.err.print("Comanda no valida, torna a probar: ");
            }
        } else if (input.matches("[0-9]")) {
            if (validarOpcio(input, numOpcions) == -1) {
                input = "Z";
            }
        } else {
            System.err.print("Comanda no valida, torna a probar: ");
            input = "Z";
        }
        return input;
    }

    public static int gestorPagines(int inputPagina, int size, boolean seguentPagina) {

        if (seguentPagina) {
            if (size == 10) {

                inputPagina++;
            }
        } else {
            inputPagina--;
        }

        if (inputPagina < 1) {
            inputPagina = 1;
        }

        return inputPagina;
    }

    public static Object conversor(ATRIBUT_TIPUS tipus, String valor) {
        Object obj = null;
        try {
            switch (tipus) {
                case ATRIBUT_TIPUS.DNI, ATRIBUT_TIPUS.PASSWORD, ATRIBUT_TIPUS.STRING ->
                    obj = valor;
                case ATRIBUT_TIPUS.DATE ->
                    obj = conversor_DATE(valor);
                case ATRIBUT_TIPUS.NUM ->
                    obj = conversor_NUM(valor);
                case ATRIBUT_TIPUS.ROLS ->
                    obj = conversor_ROLS(valor);
                case ATRIBUT_TIPUS.PREU ->
                    obj = conversor_PREU(valor);
                case ATRIBUT_TIPUS.ESTAT ->
                    obj = conversor_ESTAT(valor);
                case ATRIBUT_TIPUS.TIME ->
                    obj = conversor_TIME(valor);
            }
        } catch (Exception e) {
            System.err.println("No cumpleix els requisits");
        }
        return obj;
    }

    public static boolean format(ATRIBUT_TIPUS tipus, Object valor) {
        boolean valid = false;
        try {
            switch (tipus) {
                case ATRIBUT_TIPUS.DNI ->
                    valid = format_DNI((String) valor);
                case ATRIBUT_TIPUS.PASSWORD ->
                    valid = format_PASSWORD((String) valor);
                case ATRIBUT_TIPUS.STRING -> valid = (valor.getClass() == String.class);
                case ATRIBUT_TIPUS.DATE -> valid = (valor.getClass() == LocalDate.class);
                case ATRIBUT_TIPUS.NUM -> valid = (valor.getClass() == Integer.class);
                case ATRIBUT_TIPUS.ROLS -> valid = (valor.getClass() == ROLS.class);
                case ATRIBUT_TIPUS.PREU -> valid = (valor.getClass() == Double.class);
                case ATRIBUT_TIPUS.ESTAT -> valid = (valor.getClass() == Boolean.class);
                case ATRIBUT_TIPUS.TIME -> valid = (valor.getClass() == LocalDateTime.class);

            }
        } catch (Exception e) {
            System.err.println("No cumpleix els requisits");
        }
        return valid;
    }

    public static boolean format_DNI(String text) {
        boolean valid = false;
        if (text.matches("[0-9]{8}[A-Z]{1}")) {
            valid = true;
        }
        return valid;
    }

    public static LocalDate conversor_DATE(String valor) {
        return LocalDate.parse(valor);
    }

    public static Integer conversor_NUM(String valor) {
        return Integer.parseInt(valor);
    }

    public static boolean format_PASSWORD(String text) {
        boolean valid = false;
        if (text.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$")) {
            valid = true;
        }
        return valid;
    }

    public static ROLS conversor_ROLS(String rol) {
        return ROLS.valueOf(rol.toUpperCase());
    }

    public static Object validarInput(ATRIBUT_TIPUS tipus) {
        Object atribut = null;
        do {
            atribut = conversor(tipus, Comandes.scanner());
        } while (!format(tipus, atribut));
        return atribut;
    }

    private static double conversor_PREU(String valor) {
        return Double.parseDouble(valor);      
    }

    private static boolean conversor_ESTAT(String valor) {
        return Boolean.getBoolean(valor);
    }

    private static Object conversor_TIME(String valor) {
    return LocalDateTime.parse(valor);
    }

}
