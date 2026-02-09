/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model;

/**
 *
 * @author ruben
 */
public enum FITXERS {
    USUARI("usuaris", "nom contrasenya rol", "nom"),
    CLIENT("clients", "nif nom dataNeixament", "nif"),
    SERVEI("serveis", "id descripcio preu" ,"id"),
    RESERVA("reservas", "idReserva nifReserva numHabitacioReserva HoraDataEntrada HoraDataSortida preuTotalServeis preuFactura pagat serveisDemants estatActual" , "idReserva"),
    HABITACIO("habitacions", "numero preuNit estat", "numero");
    
    String nomFitxer;
    String lineaAtributs;
    String keyId;
    
    FITXERS(String nomFitxer, String lineaAtributs, String keyId) {
        this.nomFitxer = nomFitxer;
        this.lineaAtributs = lineaAtributs;
        this.keyId = keyId;
    }

    public String getNomFitxer() {
        return nomFitxer;
    }

    public void setNomFitxer(String nomFitxer) {
        this.nomFitxer = nomFitxer;
    }

    public String[] getLineaAtributs() {
        return lineaAtributs.split("\\s+");
    }

    public void setLineaAtributs(String lineaAtributs) {
        this.lineaAtributs = lineaAtributs;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    
    
}
