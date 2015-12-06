package de.g18.AE_05_Bank;

public class Girokonto extends Konto {

    private double dispo;

    /**
     * Bucht eine Auszahlung auf das Konto
     *
     * @param betrag Auszuzahlender Betrag
     */
    @Override
    public double auszahlen(double betrag) throws NegativerWertException {
        if (kontostand - betrag < -dispo)
            throw new NegativerWertException("Der einzuzahlende Betrag darf muss kleiner als der aktuelle Kontostand sein sein");
        return super.auszahlen(betrag);
    }

    /**
     * Gibt den aktuellen Disporahmen zurück
     */
    public double getDispo() {
        return dispo;
    }

    /**
     * Ändert den Disporahmen
     *
     * @param dispo Neuer Disporahmen
     */
    public void setDispo(double dispo) {
        this.dispo = dispo;
    }

    public Girokonto(int kontonummer) {
        super(kontonummer);
    }

    @Override
    protected String anzeigenKontoStandHeader(int tabs) {
        return super.anzeigenKontoStandHeader(tabs) + "\r\n" + TextHelfer.erzeugeTabs(tabs) + "Disporahmen: " + dispo;
    }


}
