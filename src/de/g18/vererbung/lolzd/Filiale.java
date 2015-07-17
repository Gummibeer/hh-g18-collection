package de.g18.vererbung.lolzd;

/**
 * Created with IntelliJ IDEA.
 * User: LoLZD
 * Date: 28.09.14
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class Filiale {

    private Angestellter leiter;
    private Arbeiter mitarbeiter[];

    public Filiale() {
        leiter = new Angestellter("Chef Müller");
        leiter.setBrutto(5000);
        mitarbeiter = new Arbeiter[3];
        mitarbeiter[0] = new Arbeiter("Herbert");
        mitarbeiter[0].setStdLohn(7);
        mitarbeiter[0].setStunden(120);
        mitarbeiter[1] = new Arbeiter("Hans");
        mitarbeiter[1].setStdLohn(6);
        mitarbeiter[1].setStunden(100);
        mitarbeiter[2] = new Arbeiter("Hermann");
        mitarbeiter[2].setStdLohn(10);
        mitarbeiter[2].setStunden(130);
    }

    public void ausgebenLeiter() {
        leiter.zeigePersonalDaten();
    }

    public void zeigeMitarbeiter() {
        for (Arbeiter a : mitarbeiter) {
            System.out.println("-----------");
            a.zeigePersonalDaten();
        }
    }

    public static void main(String[] args) {
        Filiale fil1 = new Filiale();
        fil1.ausgebenLeiter();
        fil1.zeigeMitarbeiter();

    }
}
