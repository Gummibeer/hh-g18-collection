package de.g18.sendefrequenzzuordnung.gummibeer.Models;

import de.g18.sendefrequenzzuordnung.gummibeer.Controller.AppController;

import java.util.HashSet;

public class Transmitter {

    public HashSet<Integer> possibleChannels = AppController.possibleChannels;
    public int channel = 0;
    public Circle area;

    public Transmitter(float x, float y, float r) {
        area = new Circle();
        area.setX(x);
        area.setY(y);
        area.setR(r);
    }

    public void checkTransmitter(Transmitter t2)
    {
        Circle c2 = t2.area;
        if(!area.isOutside(c2) && (area.isInside(c2) || area.isIntersecting(c2))) {
            t2.removePossibleChannel(channel);
        }
    }

    public void removePossibleChannel(int blockedChannel)
    {
        possibleChannels.remove(blockedChannel);
    }

}
