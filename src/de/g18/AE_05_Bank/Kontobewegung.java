package de.g18.AE_05_Bank;

import java.util.Date;

/**
 * Stellt eine Aein- oder AUszhalung auf einem Konto dar
 */
public class Kontobewegung {

    private double betrag;
    private Date datum;

    /**
     * Gibt den Betrag zur�ck
     */
    public double getBetrag() {
        return betrag;
    }

    /**
     * Gibt das Datum zur�ck
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Erstellt eine neue Kontobewegung
     *
     * @param betrag Betrag der Kontobewegung
     * @param datum  Datum der Kontobewegung
     */
    public Kontobewegung(double betrag, Date datum) {
        this.betrag = betrag;
        this.datum = datum;
    }


}
