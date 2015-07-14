package de.g18.sendefrequenzzuordnung.gummibeer.Controller;

import de.g18.sendefrequenzzuordnung.gummibeer.Models.Transmitter;

import java.util.Arrays;
import java.util.HashSet;

public class AppController {

    private HashSet<Transmitter> transmitters = new HashSet<>();
    public static HashSet<Integer> possibleChannels = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

    public void run()
    {
        // TODO: start ImportController
        loopTransmitters();
        // TODO: create Output-File
    }

    private void loopTransmitters()
    {
        for( Transmitter t : transmitters ) {
            for (int c : t.possibleChannels) {
                if (t.channel == 0 || c < t.channel) {
                    t.channel = c;
                }
            }
        }
    }
}
