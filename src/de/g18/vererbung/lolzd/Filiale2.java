package de.g18.vererbung.lolzd;

/**
 * Created with IntelliJ IDEA.
 * User: LoLZD
 * Date: 28.09.14
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class Filiale2 {

    private Mitarbeiter mitarbeiter[];

    public Filiale2() {

        mitarbeiter = new Mitarbeiter[4];
        mitarbeiter[0] = new Angestellter("Chef Müller");
        ((Angestellter) mitarbeiter[0]).setBrutto(5000);
        mitarbeiter[1] = new Arbeiter("Herbert");
        ((Arbeiter) mitarbeiter[1]).setStdLohn(7);
        ((Arbeiter) mitarbeiter[1]).setStunden(120);
        mitarbeiter[2] = new Arbeiter("Hans");
        ((Arbeiter) mitarbeiter[2]).setStdLohn(6);
        ((Arbeiter) mitarbeiter[2]).setStunden(80);
        mitarbeiter[3] = new Arbeiter("Hermann");
        ((Arbeiter) mitarbeiter[3]).setStdLohn(12);
        ((Arbeiter) mitarbeiter[3]).setStunden(100);

    }


    public void zeigeMitarbeiter() {
        for (Mitarbeiter a : mitarbeiter) {
            System.out.println("-----------");
            if (a instanceof Arbeiter) {
                ((Arbeiter) a).zeigePersonalDaten();
            } else {
                ((Angestellter) a).zeigePersonalDaten();
            }
        }
    }

    public void zeigePersonalkosten() {
        double gesamtSumme = 0;
        for (Mitarbeiter a : mitarbeiter) {
            gesamtSumme += a.getBrutto();
        }
        System.out.println("Personalkosten = " + gesamtSumme + "€");
    }

    public static void main(String[] args) {
        Filiale2 fil1 = new Filiale2();
        fil1.zeigeMitarbeiter();
        fil1.zeigePersonalkosten();

    }
}
