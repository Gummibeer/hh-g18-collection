package de.g18.vererbung.lolzd;

/**
 * Created by it3-hemsal on 24.09.2014.
 */
public class Arbeiter extends Mitarbeiter {

    private double stdLohn;
    private double stunden;

    public Arbeiter() {
    }

    public Arbeiter(String name) {
        super(name);
        this.stdLohn = 0;
        this.stunden = 0;
    }

    public void zeigePersonalDaten() {
        zeigeMitarbeiterdaten();
        System.out.println("StundenLohn :" + stdLohn);
        System.out.println("Stunden :" + stunden);
        System.out.println("Gesamt Brutto :" + getBrutto());
    }

    @Override
    public double getBrutto() {
        return stdLohn * stunden;
    }

    public double getStdLohn() {
        return stdLohn;
    }

    public void setStdLohn(double stdLohn) {
        this.stdLohn = stdLohn;
    }

    public double getStunden() {
        return stunden;
    }

    public void setStunden(double stunden) {
        this.stunden += stunden;
    }
}
