package de.g18.schulsportfest.gummibeer.Controller;

import de.g18.schulsportfest.gummibeer.Models.Participant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ParticipantsController {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private BufferedReader reader;
    private static Map<String, Participant> participants = new HashMap<>();
    private List<Participant> sortedParticipants;
    String certificateParticipants = "";
    String winnerCertificateParticipants = "";

    public ParticipantsController()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            addParticipants();
        } catch(Exception e) {
            e.printStackTrace();
        }

        sortParticipants();
        collectCertificates();

        end();
    }

    private void addParticipants() throws Exception
    {
        String newParticipant;
        do {
            Participant participant = new Participant();

            System.out.print("Vorname, Nachname: ");
            String name = reader.readLine();
            String[] names = name.split("[,]");
            participant.setForename(names[0]);
            participant.setLastname(names[1]);

            System.out.print("Punkte Lauf: ");
            String run = reader.readLine();
            participant.setRun(Integer.parseInt(run));

            System.out.print("Punkte Wurf: ");
            String thrust = reader.readLine();
            participant.setThrust(Integer.parseInt(thrust));

            System.out.print("Punkte Sprung: ");
            String jump = reader.readLine();
            participant.setJump(Integer.parseInt(jump));

            participant.calcCertificates();

            participants.put(name, participant);
            System.out.println(
                    participant.getName() + " -> " +
                            "L: " + participant.getRun() + " " +
                            "W: " + participant.getThrust() + " " +
                            "S: " + participant.getJump() + " -> " +
                            participant.getCertificate()
            );

            System.out.print("neuen Teilnehmer anlegen? (y/n): ");
            newParticipant = reader.readLine().toUpperCase();
        } while (newParticipant.equals("Y"));
    }

    private void end()
    {
        System.out.println("");
        System.out.println(ANSI_CYAN + "########## Urkunden #########" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Siegerurkunden: " + ANSI_RESET + winnerCertificateParticipants);
        System.out.println(ANSI_GREEN + "Urkunden: " + ANSI_RESET + certificateParticipants);

        System.out.println("");
        System.out.println(ANSI_CYAN + "########## Ranking ##########" + ANSI_RESET);
        int position = 1;
        for( Participant p : sortedParticipants ) {
            String color = "";
            if(position <= 3) {
                color = ANSI_YELLOW;
            } else if(position <= 5) {
                color = ANSI_GREEN;
            }
            System.out.println(color + position + ": " + p.getName() + "(" + p.getScore() + ")" + ANSI_RESET);
            position++;
        }
    }

    private void sortParticipants()
    {
        sortedParticipants = new ArrayList<>(participants.values());
        Collections.sort(sortedParticipants, new Comparator<Participant>() {
            public int compare(Participant p1, Participant p2) {
                Integer score1 = p1.getScore();
                Integer score2 = p2.getScore();
                return score2.compareTo(score1);
            }
        });
    }

    private void collectCertificates()
    {
        for( Participant p : participants.values()) {
            if(p.hasWinnerCertificate()) {
                if(!winnerCertificateParticipants.equals("")) {
                    winnerCertificateParticipants += ", ";
                }
                winnerCertificateParticipants += p.getName();
            }
            if(p.hasCertificate()) {
                if(!certificateParticipants.equals("")) {
                    certificateParticipants += ", ";
                }
                certificateParticipants += p.getName();
            }
        }
    }

}
