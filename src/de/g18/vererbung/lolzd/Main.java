package de.g18.vererbung.lolzd;

/**
 * Created with IntelliJ IDEA.
 * User: LoLZD
 * Date: 28.09.14
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Angestellter ang1 = new Angestellter("Herbert");
        Arbeiter ar1 = new Arbeiter("Hans");

        Angestellter ang2;
        ang2 = ang1;

        ang2.zeigePersonalDaten();

        ang1.zeigePersonalDaten();
        ar1.zeigePersonalDaten();

        System.out.println("--------------");
        System.out.println(ang1);
        System.out.println("--------------");
        System.out.println(ang2);
    }
}
