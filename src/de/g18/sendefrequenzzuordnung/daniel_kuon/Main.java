package de.g18.sendefrequenzzuordnung.daniel_kuon;

import java.text.ParseException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ParseException {
        SenderLandscape senderLandscape = new SenderLandscape();
        senderLandscape.LoadFromText("**\n" +
                "** Beispiel der Aufgabenstellung\n" +
                "**\n" +
                "30 110 12.5\n" +
                "65 100.3 27\n" +
                "34.2 60 31.9\n" +
                "114 100 18\n" +
                "87.43 72.57 12.5\n" +
                "94 120 12.5\n" +
                "78.28 42.168 22.119\n" +
                "118 60 28.5\n" +
                "145 38 22.12\n" +
                "125 122 22.12\n" +
                "140 82 17\n" +
                "145 102 27.5");
        senderLandscape.CalculateFrequencies();
        for (Sender sender : senderLandscape.GetSenders()) {
            System.out.println(sender.getName() + ": Frequenz " + sender.getFrequency());
        }
        System.out.println("Anzahl benötigter Frequenzen: " + senderLandscape.getNeededFrequencies());
    }
}

