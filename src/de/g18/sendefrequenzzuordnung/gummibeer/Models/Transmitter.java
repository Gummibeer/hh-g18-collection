package de.g18.sendefrequenzzuordnung.gummibeer.Models;

import java.util.Arrays;
import java.util.HashSet;

public class Transmitter {

    private HashSet<Integer> possibleChannels = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
    private int channel = 0;
    private Circle area;

    public Transmitter(float x, float y, float r) {
        area = new Circle();
        area.setX(x);
        area.setY(y);
        area.setR(r);
    }

    public void checkTransmitter(Transmitter t2)
    {
        Circle c2 = t2.getArea();
        if(!area.isOutside(c2) && (area.isInside(c2) || area.isIntersecting(c2))) {
            t2.removePossibleChannel(channel);
            for( int c : possibleChannels ) {
                if(channel == 0 || c < channel) {
                    channel = c;
                }
            }
        }
    }

    public Circle getArea() {
        return area;
    }

    public void removePossibleChannel(int blockedChannel)
    {
        possibleChannels.remove(blockedChannel);
    }

}
