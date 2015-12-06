package de.g18.AE_05_Bank;

import java.util.ArrayList;

public class Kunde {

    private String Name;
    private int kundennummer;
    private int kontoindex = 0;
    private ArrayList<Konto> kontenListe;

    /**
     * Gibt die Kundennummer zurück
     */
    public int getKundennummer() {
        return kundennummer;
    }

    /**
     * Ändert die Kundennummer
     *
     * @param kundennummer Neue Kundennummer
     */
    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    /**
     * Gibt den Namen des Kunden zurück
     */
    public String getName() {
        return Name;
    }

    /**
     * Ändert den Namen des Kunden
     *
     * @param name Neuer Name
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Erstellt einen neuen Kunden
     *
     * @param name         Name des Kunden
     * @param kundennummer Kundennummer des Kunden
     */
    public Kunde(String name, int kundennummer) {
        kontenListe = new ArrayList<>();
        this.Name = name;
        this.kundennummer = kundennummer;
    }

    /**
     * Fügt dem Kunden ein neues Konto hinzu
     */
    public void hinzufuegenKonto(Konto konto) {
        kontenListe.add(konto);
    }

    /**
     * Gibt den addierten Kontostand aller Konten zurück
     */
    public double getKontostand() {
        double kontostand = 0;
        for (Konto konto : kontenListe)
            kontostand += konto.getKontostand();
        return kontostand;
    }

    /**
     * Legt ein neues Konto an, generiert eine Kontonummer und fügt es den Konten des Kunden hinzu
     *
     * @param kontotyp Type des neuen Kontos. 0: Sparkonto / 1: Girokonto
     */
    public Konto anlegenKonto(int kontotyp) throws UnbekannterKontotypException {
        Konto konto = Konto.neuesKonto(kundennummer * 100000 + (kontoindex++), kontotyp);
        kontenListe.add(konto);
        return konto;
    }

    /**
     * Gibt ein Konto des Kunden zurück
     *
     * @param index Index des Kontos
     */
    public Konto getKonto(int index) {
        return kontenListe.get(index);
    }

    public String anzeigenKontostandsUebersicht() {
        return anzeigenKontostandsUebersicht(0);
    }

    public String anzeigenKontostandsUebersicht(int tabs) {
        String ret = TextHelfer.erzeugeTabs(tabs) + "Name: " + Name + "\r\n Kundennummer: " + kundennummer;
        for (int i = 0; i < kontenListe.size(); i++) {
            if (i > 0)
                ret += "\r\n" + TextHelfer.erzeugeTabs(tabs) + "----------------------";
            ret += "\r\n" + kontenListe.get(i).anzeigenKontostandUebersicht(tabs + 1);
        }
        return ret;
    }

    public Kunde() {
        kontenListe = new ArrayList<>();
    }
}
