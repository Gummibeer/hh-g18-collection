package de.g18.sendefrequenzzuordnung.gummibeer.Controller;

import de.g18.sendefrequenzzuordnung.gummibeer.Models.Transmitter;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class AppController {

    private List<Transmitter> transmitters = new ArrayList<>();
    public static Map<Integer, Integer> possibleChannels = new HashMap<>();

    public void run()
    {
        init();
        // TODO: start ImportController
        loopTransmitters();
        // TODO: create Output-File
    }

    private void init()
    {
        int i = 1;
        while(i <= 11) {
            possibleChannels.put(i, 2412 + ((i - 1) * 5));
            i++;
        }
    }

    private void loopTransmitters()
    {
        for( Transmitter t : transmitters ) {
            for( Transmitter t2 : transmitters ) {
                t.checkTransmitter(t2);
            }
            for ( Map.Entry<Integer, Integer> c : t.possibleChannels.entrySet() ) {
                if (t.channel == 0 || c.getKey() < t.channel) {
                    t.channel = c.getKey();
                    t.frequency = c.getValue();
                }
            }
        }
    }
}
