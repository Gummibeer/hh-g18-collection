package de.g18.sendefrequenzzuordnung.daniel_kuon;


import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

public class SenderLandscape {
    private List<Sender> senders;
    private Integer neededFrequencies;

    /**
     * Parses a list of senders from text and adds ist to the list of senders
     *
     * @param text List of senders in the format provided in the documentation
     */
    public void LoadFromText(String text) throws ParseException {
        //Check if input string has the correct format
        if (!Pattern.matches("^((\\*\\*.*?|\\d+(\\.\\d+)? +\\d+(\\.\\d+)? +\\d+(\\.\\d+)? *)(\\n|\\r|\\n\\r|))*$", text))
            throw new ParseException("Input is not in the correct format", -1);
        //reset the number of needed frequncies as it may change when we add new senders
        neededFrequencies = null;
        //Replace multiple spaces with a single one to simplify further parsing
        text = text.replaceAll(" {2,}", " ");
        //Check if senders has been initiated and initiate it otherwise
        if (senders == null)
            senders = new LinkedList<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //Ignore comment lines (starting with **)
            if (!line.startsWith("**")) {
                String[] values = line.split(" ");
                Sender newSender = new Sender(Double.parseDouble(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2]), "S" + String.format("%01d", senders.size() + 1));
                //Update all overlap counters
                for (Sender sender : senders) {
                    if (sender.IsWithinReach(newSender)) {
                        sender.IncrementOverlaps();
                        newSender.IncrementOverlaps();
                    }
                }
                senders.add(newSender);
            }
        }
    }

    /**
     * Parses a list of senders from a file and adds ist to the list of senders
     *
     * @param filePath Path of the file with the list of senders in the format provided in the documentation
     */
    public void LoadFromFile(String filePath) throws FileNotFoundException, ParseException {
        //Load file contents, join all lines to a single string and feed it to LoadFromText
        LoadFromText(new Scanner(new File(filePath)).useDelimiter("\\A").next());
    }

    /**
     * Removes all senders from landscape
     */
    public void ClearSenders() {
        senders = null;
        neededFrequencies = null;
    }

    /**
     * @return A copy of all senders in this landscape
     */
    public Sender[] GetSenders() {
        if (senders == null)
            return null;
        Sender[] out = new Sender[senders.size()];
        int index = 0;
        for (Sender sender : senders) {
            out[index] = new Sender(sender.getX(), sender.getY(), sender.getRadius(), sender.getName());
            out[index].setOverlaps(sender.getOverlaps());
            out[index].setFrequency(sender.getFrequency());
            index++;
        }
        return out;
    }

    public void CalculateFrequencies() {
        if (senders == null)
            throw new NullPointerException("Senders have not been loaded");
        if (senders.size() == 0)
            return;
        //Copy all senders to an array to optimize the sorting
        Sender[] senderArr = new Sender[senders.size()];
        senderArr = senders.toArray(senderArr);
        //Sort all senders by number of overlappings and their coordinates
        Arrays.sort(senderArr, new SenderComparator());
        boolean[][] overlappingMatrix = new boolean[senders.size()][];
        for (int i = 0; i < senders.size(); i++) {
            overlappingMatrix[i] = new boolean[senders.size()];
        }
        //iterate through all senders to check for overlapping senders
        for (int i = 0; i < senderArr.length - 1; i++) {
            //only check senders with an higher index than the current one because all
            // senders with an lower index have already been checked and a sender is
            // not overlapping itself to make further processing easier
            for (int j = i + 1; j < senderArr.length; j++) {
                if (senderArr[i].IsWithinReach(senderArr[j])) {
                    //Set both fields in the matrix to true so we can check if sender A overlaps with B without taking care of the order
                    overlappingMatrix[i][j] = true;
                    overlappingMatrix[j][i] = true;
                }
            }
        }

        System.out.print("\t ");
        for (int i = 0; i < senderArr.length; i++) {
            System.out.print(senderArr[i].getName() + "     ");
        }
        System.out.println();
        for (int i = 0; i < senderArr.length; i++) {
            System.out.println(senderArr[i].getName() + ": " + Arrays.toString(overlappingMatrix[i]));
        }
        //First sender gets frequency 1
        senderArr[0].setFrequency(1);
        for (int i = 1; i < senderArr.length; i++) {
            //Cache sender for speed optimizations
            Sender sender = senderArr[i];
            //If a sender has no overlappings it gets frequency 1
            if (sender.getOverlaps() == 0)
                sender.setFrequency(1);
            else {
                //Cache all frequencies from overlapping senders that already have a frequency
                Set<Integer> overlappingFreqs = new HashSet<>();
                for (int a = 0; a < overlappingMatrix[i].length; a++) {
                    if (overlappingMatrix[i][a] && senderArr[a].getFrequency() != null)
                        overlappingFreqs.add(senderArr[a].getFrequency());
                }

                //Set sender to lowest available frequency and update the number of needed frequencies
                int currentFrequency = 0;
                while (overlappingFreqs.contains(++currentFrequency)) {
                }
                sender.setFrequency(currentFrequency);
                if (neededFrequencies == null || neededFrequencies < currentFrequency)
                    neededFrequencies = currentFrequency;
            }
        }
    }

    /**
     * @return Number of frequencies needed so no sender interferes with another sender with the same frequency. Null if frequencies have not yet been calculated
     */
    public Integer getNeededFrequencies() {
        return neededFrequencies;
    }
}
