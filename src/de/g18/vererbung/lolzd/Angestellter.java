package de.g18.vererbung.lolzd;

/**
 * Created by it3-hemsal on 24.09.2014.
 */
public class Angestellter extends Mitarbeiter {

    private double brutto;

    public Angestellter() {
    }

    public Angestellter(String name) {
        super(name);
        this.brutto = 0;
    }

    public void zeigePersonalDaten() {
        zeigeMitarbeiterdaten();
        System.out.println("Brutto :" + brutto);
    }

    @Override
    public String toString() {

        return this.getClass().getName() + "@" + getName();


    }

    @Override
    public double getBrutto() {

        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }
}
