package de.g18.AE_05_Bank;


public class TextHelfer {
    /**
     * Erzeugt einen string mit Tba-Zeichen
     *
     * @param anzahl Anzahl der zu erzeugenden Tabs
     */
    public static String erzeugeTabs(int anzahl) {
        String ret = "";
        for (int i = 0; i < anzahl; i++) {
            ret += "\t";
        }
        return ret;
    }

}
