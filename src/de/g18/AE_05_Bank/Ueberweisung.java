package de.g18.AE_05_Bank;

import java.util.Date;

public class Ueberweisung {

    private double betrag;
    private Date datum;
    private Konto vonKonto;
    private Konto nachKonto;

    /**
     * Gibt das Quellkonto zur�ck
     */
    public Konto getVonKonto() {
        return vonKonto;
    }

    /**
     * �ndert das Quellkonto
     *
     * @param konto Neues Quellkonto
     */
    public void setVonKonto(Konto konto) {
        this.vonKonto = konto;
    }

    /**
     * Gibt das Zielkonto zur�ck
     */
    public Konto getNachKonto() {
        return nachKonto;
    }

    /**
     * �ndert das Quellkonto
     *
     * @param konto Neues Quellkonto
     */
    public void setNachKonto(Konto konto) {
        this.nachKonto = konto;
    }

    /**
     * Gibt den Betrag der �berweisung zur�ck
     */
    public double getBetrag() {
        return betrag;
    }

    /**
     * �ndert den Betrag der �berweisung
     *
     * @param betrag Neuer �berweisungsbetrag
     */
    public void setBetrag(double betrag) throws NegativerWertException {
        if (betrag < 0)
            throw new NegativerWertException("Der Betrag muss positiv sein");
        this.betrag = betrag;
    }

    /**
     * Gibt das Datum der �berweisung zur�ck
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * �ndert das Datum der �berweisung
     *
     * @param datum Neues �berweisungsdatum
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
     * F�hrt dei �berweisung aus. Falls ein Fehler auftritt wird die �berweisung r�ckg�ngig gemacht.
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
