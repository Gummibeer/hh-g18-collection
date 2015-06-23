package de.g18.schulsportfest.Models;

import com.sun.xml.internal.ws.util.StringUtils;

public class Participant {

    private String forename;
    private String lastname;
    private int run;
    private int thrust;
    private int jump;
    private int score;
    private boolean certificate = false;
    private boolean winnersCertificate = false;

    public String getName()
    {
        return getForename() + " " + getLastname();
    }

    public String getForename() {
        return forename;
    }
    public void setForename(String forename) {
        this.forename = prepareName(forename);
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = prepareName(lastname);
    }

    public int getRun() {
        return run;
    }
    public void setRun(int run) {
        this.run = run;
    }

    public int getThrust() {
        return thrust;
    }
    public void setThrust(int thrust) {
        this.thrust = thrust;
    }

    public int getJump() {
        return jump;
    }
    public void setJump(int jump) {
        this.jump = jump;
    }

    public int getScore() {
        return score;
    }

    private String prepareName(String name)
    {
        return StringUtils.capitalize(name.trim());
    }

    public void calcCertificates()
    {
        score = run + thrust + jump;
        if(score > 130) {
            winnersCertificate = true;
        } else if(score > 100) {
            certificate = true;
        }
    }

    public boolean hasCertificate()
    {
        return certificate;
    }

    public boolean hasWinnerCertificate()
    {
        return winnersCertificate;
    }

    public String getCertificate()
    {
        if(winnersCertificate) {
            return "Siegerurkunde";
        } else if(certificate) {
            return "Urkunde";
        } else {
            return "Noob";
        }
    }
}
