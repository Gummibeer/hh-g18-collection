package de.g18.AE_05_Bank;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Bitte Kundennummer eingeben: ");
            int kundenNummer = sc.nextInt();
            System.out.print("Bitte Kundenname eingeben: ");
            String kundenName = sc.next();
            System.out.print("Bitte Kundenvorname eingeben: ");
            String kundenVorname = sc.next();
            Kunde kunde1 = new Kunde(kundenName, kundenNummer);
            Konto konto1 = kunde1.anlegenKonto(Konto.GIROKONTO);
            Konto konto2 = kunde1.anlegenKonto(Konto.SPARKONTO);
            System.out.println("(1) " + kunde1.anzeigenKontostandsUebersicht());
            konto1.einzahlen(1000);
            System.out.println("(2) " + kunde1.anzeigenKontostandsUebersicht());
            konto2.einzahlen(100);
            System.out.println("(3) " + kunde1.anzeigenKontostandsUebersicht());
            konto1.auszahlen(400);
            System.out.println("(4) " + kunde1.anzeigenKontostandsUebersicht());
            konto2.auszahlen(100);
            System.out.println("(5) " + kunde1.anzeigenKontostandsUebersicht());
            Ueberweisung ueb = new Ueberweisung(konto1, konto2, 25, new java.util.Date());
            ueb.durchfuehrenUeberweisung();
            System.out.println("(6) " + kunde1.anzeigenKontostandsUebersicht());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}