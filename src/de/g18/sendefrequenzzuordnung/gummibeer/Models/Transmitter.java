package de.g18.sendefrequenzzuordnung.gummibeer.Models;

import javafx.scene.shape.Circle;

import java.util.Arrays;
import java.util.HashSet;

public class Transmitter {

    private HashSet<Integer> possibleChannels = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
    private int channel;
    private Circle area;

    public Circle getArea() {
        return area;
    }

    public void checkCircle(Transmitter t2)
    {
        Circle c2 = t2.getArea();
        if(!isOutside(c2) && (isInside(c2) || isIntersecting(c2))) {
            t2.removeChannel(channel);
        }
    }

    public void removeChannel(int blockedChannel)
    {
        possibleChannels.remove(blockedChannel);
    }

    private boolean isOutside(Circle c2) {
        return distanceTo(c2) > ((area.getRadius()) + (c2.getRadius()));
    }

    private boolean isInside(Circle c2) {
        return distanceTo(c2) + area.getRadius() <= c2.getRadius();
    }

    private boolean isIntersecting(Circle c2) {
        return Math.abs((area.getRadius() - c2.getRadius())) <= distanceTo(c2) && distanceTo(c2) <= (area.getRadius() + c2.getRadius());
    }

    private double distanceTo(Circle c2) {
        return Math.sqrt(Math.pow(area.getCenterX() - c2.getCenterX(), 2) + Math.pow(area.getCenterY() - c2.getCenterY(), 2));
    }

}
