package de.g18.sendefrequenzzuordnung.daniel_kuon;

/**
 * Somparator for senders
 */
public class SenderComparator implements java.util.Comparator<Sender> {
    @Override
    public int compare(Sender o1, Sender o2) {
        //Check if o1 and o2 have a different number of overlaps.
        if (o1.getOverlaps() < o2.getOverlaps())
            return 1;
        else if (o1.getOverlaps() > o2.getOverlaps())
            return -1;
        //Check if o1 and o2 have a different x coordinate
        if (o1.getX() < o2.getX())
            return -1;
        else if (o1.getX() > o2.getX())
            return 1;
        //Check if o1 and o2 have a different y coordinate
        if (o1.getY() < o2.getY())
            return -1;
        else if (o1.getY() > o2.getY())
            return 1;

        //o1 and o2 have the same ranking
        return 0;
        //return o1.getOverlaps()>o2.getOverlaps()?-1:o1.getOverlaps()<o2.getOverlaps()?1:o1.getX()<o2.getX()?-1:o2.getX()<o1.getX()?1:o1.getY()<o2.getY()?-1:o2.getY()<o1.getY()?1:0;
    }
}
