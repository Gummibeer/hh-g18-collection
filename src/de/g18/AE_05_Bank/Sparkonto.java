package de.g18.AE_05_Bank;

public class Sparkonto extends Konto {
    /**
     * Bucht eine Auszahlung auf das Konto
     *
     * @param betrag Auszuzahlender Betrag
     */
    @Override
    public double auszahlen(double betrag) throws NegativerWertException {
        if (kontostand < betrag)
            throw new NegativerWertException("Der einzuzahlende Betrag darf muss kleiner als der aktuelle Kontostand sein sein");
        return super.auszahlen(betrag);
    }

    private double zinssatz;

    /**
     * Gibt den Zinssatz zur�ck
     */
    public double getZinssatz() {
        return zinssatz;
    }

    /**
     * �ndert den Zinssatz
     *
     * @param zinssatz Neuer Zinssatz
     */
    public void setZinssatz(double zinssatz) {
        this.zinssatz = zinssatz;
    }

    public Sparkonto(int kontonummer) {
        super(kontonummer);
    }

    @Override
    protected String anzeigenKontoStandHeader(int tabs) {
        return super.anzeigenKontoStandHeader(tabs) + "\r\n" + TextHelfer.erzeugeTabs(tabs) + "Zinssatz: " + zinssatz;
    }
}
