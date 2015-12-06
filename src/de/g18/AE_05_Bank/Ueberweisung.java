package de.g18.AE_05_Bank;

import java.util.Date;

public class Ueberweisung {

    private double betrag;
    private Date datum;
    private Konto vonKonto;
    private Konto nachKonto;

    /**
     * Gibt das Quellkonto zurück
     */
    public Konto getVonKonto() {
        return vonKonto;
    }

    /**
     * Ändert das Quellkonto
     *
     * @param konto Neues Quellkonto
     */
    public void setVonKonto(Konto konto) {
        this.vonKonto = konto;
    }

    /**
     * Gibt das Zielkonto zurück
     */
    public Konto getNachKonto() {
        return nachKonto;
    }

    /**
     * Ändert das Quellkonto
     *
     * @param konto Neues Quellkonto
     */
    public void setNachKonto(Konto konto) {
        this.nachKonto = konto;
    }

    /**
     * Gibt den Betrag der Überweisung zurück
     */
    public double getBetrag() {
        return betrag;
    }

    /**
     * Ändert den Betrag der Überweisung
     *
     * @param betrag Neuer Überweisungsbetrag
     */
    public void setBetrag(double betrag) throws NegativerWertException {
        if (betrag < 0)
            throw new NegativerWertException("Der Betrag muss positiv sein");
        this.betrag = betrag;
    }

    /**
     * Gibt das Datum der Überweisung zurück
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Ändert das Datum der Überweisung
     *
     * @param datum Neues Überweisungsdatum
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Ueberweisung(Konto vonKonto, Konto nachKonto, double betrag, Date datum) {
        this.betrag = betrag;
        this.datum = datum;
        this.vonKonto = vonKonto;
        this.nachKonto = nachKonto;
    }

    public Ueberweisung() {
    }

    /**
     * Führt dei Überweisung aus. Falls ein Fehler auftritt wird die Überweisung rückgängig gemacht.
     */
    public void durchfuehrenUeberweisung() throws NegativerWertException {
        vonKonto.auszahlen(betrag);
        try {
            nachKonto.einzahlen(betrag);
        } catch (Exception e) {
            vonKonto.einzahlen(betrag);
            throw e;
        }
    }
}
