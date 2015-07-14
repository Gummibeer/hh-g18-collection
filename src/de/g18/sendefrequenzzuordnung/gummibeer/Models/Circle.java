package de.g18.sendefrequenzzuordnung.gummibeer.Models;

public class Circle {

    private float x;
    private float y;
    private float r;

    public boolean isOutside(Circle c2) {
        return distanceTo(c2) > ((r) + (c2.getR()));
    }

    public boolean isInside(Circle c2) {
        return distanceTo(c2) + r <= c2.getR();
    }

    public boolean isIntersecting(Circle c2) {
        return Math.abs((r - c2.getR())) <= distanceTo(c2) && distanceTo(c2) <= (r + c2.getR());
    }

    private double distanceTo(Circle c2) {
        return Math.sqrt(Math.pow(x - c2.getX(), 2) + Math.pow(y - c2.getY(), 2));
    }

    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }
    public void setR(float r) {
        this.r = r;
    }
}
