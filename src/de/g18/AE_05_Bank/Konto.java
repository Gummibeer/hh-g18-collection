package de.g18.AE_05_Bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Konto {
    protected int Kontonummer;
    protected double kontostand;

    /**
     * Gibt die Kontobewgungen zurück
     */
    public ArrayList<Kontobewegung> getMeineKontobewegungen() {
        return meineKontobewegungen;
    }

    private ArrayList<Kontobewegung> meineKontobewegungen;


    /**
     * Gibt den aktuellen Kontostand zurück
     */
    public double getKontostand() {
        return kontostand;
    }

    /**
     * Gibt die Kontonummer zurück
     */
    public int getKontonummer() {
        return Kontonummer;
    }

    /**
     * Ändert die Kontonummer
     *
     * @param kontonummer Neue Kontonummer
     */
    public void setKontonummer(int kontonummer) {
        this.Kontonummer = kontonummer;
    }

    public static int SPARKONTO = 0;
    public static int GIROKONTO = 1;

    /**
     * Bucht eine Einzahlung auf das Konto
     *
     * @param betrag Einzuzahlender Betrag
     */
    public double einzahlen(double betrag) throws NegativerWertException {
        if (betrag < 0)
            throw new NegativerWertException("Der einzuzahlende Betrag darf muss positiv sein");
        meineKontobewegungen.add(new Kontobewegung(betrag, new Date()));
        return kontostand += betrag;
    }

    /**
     * Bucht eine Auszahlung auf das Konto
     *
     * @param betrag Auszuzahlender Betrag
     */
    public double auszahlen(double betrag) throws NegativerWertException {
        if (betrag < 0)
            throw new NegativerWertException("Der einzuzahlende Betrag darf muss positiv sein");
        meineKontobewegungen.add(new Kontobewegung(-betrag, new Date()));
        return kontostand -= betrag;
    }


    /**
     * Erstellt ein neues Konto
     *
     * @param kontonummer Kontonummer
     * @param kontotyp    Tpy des Kontos. Sparkonto: 0 / Girokonto: 1
     */
    public static Konto neuesKonto(int kontonummer, int kontotyp) throws UnbekannterKontotypException {
        if (kontotyp == GIROKONTO)
            return new Girokonto(kontonummer);
        else if (kontotyp == SPARKONTO)
            return new Sparkonto(kontonummer);
        else
            throw new UnbekannterKontotypException();
    }

    protected Konto(int kontonummer) {
        Kontonummer = kontonummer;
        this.kontostand = 0;
        meineKontobewegungen = new ArrayList<>();
    }

    /**
     * Gib eine Übersicht des Kontos inklusive aller Kontobewgungne zurück
     */
    public String anzeigenKontostandUebersicht() {
        return anzeigenKontostandUebersicht(0);
    }

    /**
     * Gib eine Übersicht des Kontos inklusive aller Kontobewgungne zurück
     *
     * @param tabs Anzahl der Einrückungen vor jeder Zeile
     */
    String anzeigenKontostandUebersicht(int tabs) {
        String ret = anzeigenKontoStandHeader(tabs);
        if (meineKontobewegungen.size() > 0) {
            ret += "\r\n" + TextHelfer.erzeugeTabs(tabs) + "Kontobewegungen";
            for (int i = 0; i < meineKontobewegungen.size(); i++) {
                ret += "\r\n";
                if (i > 0)
                    ret += TextHelfer.erzeugeTabs(tabs + 1) + "----------------------\r\n";
                Kontobewegung bewegung = meineKontobewegungen.get(i);
                ret += TextHelfer.erzeugeTabs(tabs + 1) + "Betrag: " + bewegung.getBetrag() + "\r\n" + TextHelfer.erzeugeTabs(tabs + 1) + "Datum: " + new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss").format(bewegung.getDatum());
            }
        }
        return ret;
    }

    /**
     * Gibt die Kopfsaten des Konto zurück
     *
     * @param tabs Anzahl der Einrückungen vor jeder Zeile
     */
    protected String anzeigenKontoStandHeader(int tabs) {
        return TextHelfer.erzeugeTabs(tabs) + "Kontonummer: " + Kontonummer + "\r\n" + TextHelfer.erzeugeTabs(tabs) + "Kontostand: " + kontostand;
    }
}
