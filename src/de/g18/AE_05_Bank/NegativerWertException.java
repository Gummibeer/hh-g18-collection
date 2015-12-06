package de.g18.AE_05_Bank;

public class NegativerWertException extends Exception {
    public NegativerWertException(String fehler) {
        super(fehler);
    }
}
