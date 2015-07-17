package de.g18.vererbung.lolzd;

/**
 * Created by it3-hemsal on 24.09.2014.
 */
abstract class Mitarbeiter {

    private String name;
    private int persNr;
    private static int autoNr;

    public Mitarbeiter() {
        name = "Unbekannt";
        autoNr++;
        persNr = autoNr;

    }

    public Mitarbeiter(String name) {
        this.name = name;
        autoNr++;
        persNr = autoNr;
    }

    String getName() {
        return name;
    }

    public abstract double getBrutto();

    public void zeigeMitarbeiterdaten() {
        System.out.println("PersonalNr: " + persNr + "\nName: " + name);
    }


}
