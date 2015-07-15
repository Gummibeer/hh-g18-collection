package de.g18.sendefrequenzzuordnung.daniel_kuon;

import java.util.Collections;

public class Sender {
    private double x;
    private double y;
    private double radius;
    private String name;
    private int overlaps;
    //This must be an Integer so it can be set to null if no frequency is chosen yet
    private Integer frequency;

    /**
     * @return X coordinate of this sender
     */
    public double getX() {
        return x;
    }

    /**
     * @param x New X coordinate of this sender
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return Y Coordinate of this sender
     */
    public double getY() {
        return y;
    }

    /**
     * @param y New Y coordinate of this sender
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return Range of this sender
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius New range of this sender
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Checks if another sender is withing reach of this one
     *
     * @param sender The other sender
     * @return true if both senders overlap each other
     */
    public boolean IsWithinReach(Sender sender) {
        //Calculate the distance between the two senders using pythagoras algorithm.
        // The signals of the two senders overlap if the sum of both ranges is greater than the distance between them
        return sender.radius + radius > Math.sqrt(Math.pow(sender.x - x, 2) + Math.pow(sender.y - y, 2));
    }

    public Sender(double x, double y, double radius, String name) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.name = name;
        this.overlaps = 0;
    }

    /**
     * @return Name of this sender
     */
    public String getName() {
        return name;
    }

    /**
     * @param name New name of this sender
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The number of sender that overlap with this one
     */
    public int getOverlaps() {
        return overlaps;
    }

    /**
     * @param overlaps The number of sender that overlap with this one
     */
    public void setOverlaps(int overlaps) {
        this.overlaps = overlaps;
    }

    /**
     * @return The frequency to which this sender is tuned. Is null if no frequency is set.
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * @param frequency The frequency to which this sender is tuned.
     */
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sender)) return false;

        Sender sender = (Sender) o;

        return !(name != null ? !name.equals(sender.name) : sender.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    /**
     * Increments the overlaps counter
     *
     * @return Incremented number of overlaps
     */
    public int IncrementOverlaps() {
        return ++overlaps;
    }
}
