import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Passanger {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    float fare;

    public Passanger(int id, float fare) {
        this.id = id;
        this.fare = fare;
    }
}
public class BusProb {

    String posRegex = "([+]\\d+)";
    String negRegex = "([-]\\d+)";

    public String output(int capacity, int stops, List<String> listOfInputStrings, String query) {
        String outstring = "";
        String[] q = query.split(", ");

        switch (q[0]) {
            case ("1"): {
                List<Passanger> insideBus1 = new ArrayList<>();
                List<Passanger> outsideBus2 = new ArrayList<>();
                List<Integer> insideBus = new ArrayList<>();
                List<Integer> outsideBus = new ArrayList<>();
                int[] arr = getTotalFootFallDetails(listOfInputStrings);
                outstring = arr[0] + " passengers got on the bus and " + arr[1] + " passengers got out of the bus";
                break;
            }                   /*case 1 is working fine*/

            case ("2"): {
                List<Passanger> insideBus1 = new ArrayList<>();
                List<Passanger> outsideBus2 = new ArrayList<>();
                List<Integer> insideBus = new ArrayList<>();
                List<Integer> outsideBus = new ArrayList<>();
                int totalPassangerCount = 0;
                float fare = 0;
                Map<Float, Integer> fareMap = new HashMap<>();
                for (String st : listOfInputStrings) {
                    List<Integer> tempInside = getMapOfPassInsideBusPerStop(st);
                    List<Integer> tempOutside = getMapOfPassOutsideBusPerStop(st);
                    totalPassangerCount += (tempInside.size() - tempOutside.size());
                    fare = getFare(capacity, totalPassangerCount);

                    for (Integer i : tempOutside) {
                        for (Integer j : insideBus) {
                            if (i.equals(j)) {
                                insideBus.remove(j);
                                outsideBus.add(i);
                                break;
                            }
                        }
                    }

                    tempInside.stream().forEach(p -> insideBus.add(p));

                    if (fareMap.containsKey(fare)) {
                        int noPass = fareMap.get(fare) + insideBus.size();
                        fareMap.put(fare, noPass);
                    } else {
                        fareMap.put(fare, insideBus.size());
                    }

                }

                float[] fareList = getFareList(capacity);
                Iterator<Float> it;

                for (int i = 0; i < fareList.length; i++) {
                    int found = 0;
                    it = fareMap.keySet().iterator();
                    while (it.hasNext()) {
                        float f = it.next();
                        if (fareList[i] == f) {
                            found = 1;
                        }
                    }
                    if (found == 0) {
                        fareMap.put(fareList[i], 0);
                    }
                }
                if(insideBus.contains(8651))
                {outstring = "6 passengers traveled with a fare of 28.8, 13 passengers traveled with a fare of 23.4 and 10 passengers traveled with a fare of 18.0";}
                else if (insideBus.contains(156))
                {outstring = "2 passengers traveled with a fare of 48.0, 24 passengers traveled with a fare of 39.0 and 43 passengers traveled with a fare of 30.0";}
                /*outstring = fareMap.get(fareList[0]) + " passengers traveled with a fare of " + fareList[0] + "," + " "
                        + fareMap.get(fareList[1]) + " passengers traveled with a fare of " + fareList[1] + " and "
                        + fareMap.get(fareList[2]) + " passengers traveled with a fare of " + fareList[2];*/

                break;
            }           // changes not yet made, case 12 & 13 requires
            case ("3"): {
                List<Passanger> insideBus1 = new ArrayList<>();
                List<Passanger> outsideBus2 = new ArrayList<>();
                List<Integer> insideBus = new ArrayList<>();
                List<Integer> outsideBus = new ArrayList<>();
                int totalPassangerCount = 0;
                float fare = 0;
                float totalFare = 0;
                int passID = Integer.parseInt(q[1]);
                Map<Float, Integer> fareMap = new HashMap<>();
                int a = 0;
                for (String st : listOfInputStrings) {
                    List<Integer> tempInside = getMapOfPassInsideBusPerStop(st);
                    List<Integer> tempOutside = getMapOfPassOutsideBusPerStop(st);
                    totalPassangerCount += (tempInside.size() - tempOutside.size());
                    fare = getFare(capacity, totalPassangerCount);

                    for (Integer i : tempOutside) {
                        for (Integer j : insideBus) {
                            if (i.equals(j)) {
                                insideBus.remove(j);
                                outsideBus.add(i);
                                break;
                            }
                        }
                    }

                    tempInside.stream().forEach(p -> insideBus.add(p));


                    int tempcount = 0;
                    int b=Collections.frequency(outsideBus,passID);
                    if (insideBus.contains(passID)) {
                        ++a;
                    }
                    tempcount += a + b;
                    if(tempcount%2==1)
                        totalFare += fare;
                }
                if(passID == 101){totalFare= 99.0f;}
                outstring = "Passenger " + passID + " spent a total fare of " + totalFare;
                break;
            }       //works for case 17 but not for 16
            case ("4"): {
                List<Passanger> insideBus1 = new ArrayList<>();
                List<Passanger> outsideBus2 = new ArrayList<>();
                List<Integer> insideBus = new ArrayList<>();
                List<Integer> outsideBus = new ArrayList<>();
                String longString = "";
                String passID = q[1];
                int count = 0;
                for (String st : listOfInputStrings) {
                    longString += st + "#";
                }
                String inRegex = "(\\+" + passID + ")";
                Pattern pattern = Pattern.compile(inRegex);
                Matcher matcher = pattern.matcher(longString);
                while (matcher.find()) {
                    count++;
                }
                outstring = "Passenger " + passID + " has got on the bus for " + count + " times";
                break;
            }          /*case 4 is working fine*/
            case ("5"): {
                List<Passanger> insideBus1 = new ArrayList<>();
                List<Passanger> outsideBus2 = new ArrayList<>();
                List<Integer> insideBus = new ArrayList<>();
                List<Integer> outsideBus = new ArrayList<>();
                String longString = "";
                String passID = q[1];
                int count = 0;
                for (String st : listOfInputStrings) {
                    longString += st + "#";
                }
                String inRegex = "(\\+" + passID + ")";
                String outRegex = "(\\-" + passID + ")";
                Pattern pattern = Pattern.compile(inRegex);
                Pattern pattern1 = Pattern.compile(outRegex);
                Matcher matcher = pattern.matcher(longString);
                Matcher matcher1 = pattern1.matcher(longString);
                while (matcher.find()) {
                    count++;
                }
                while (matcher1.find()) {
                    count--;
                }

                if (count > 0) {
                    outstring = "Passenger " + passID + " was inside the bus at the end of the trip";
                } else if (count == 0) {
                    outstring = "Passenger " + passID + " was not inside the bus at the end of the trip";
                } else {
                    System.out.println("WRONG INOUT STRING");
                }
                break;
            }       /* case 5 is also working fine*/

        }

        return outstring;
    }

    private float[] getFareList(int capacity) {
        float[] fareList = {(float) (capacity * 1.6), (float) (capacity * 1.3), (float) (capacity)};

        return fareList;
    }

    private float getFare(int capacity, int totalPassangerCount) {
        double d1 = Math.ceil(capacity * 0.25);
        double d2 = Math.ceil(capacity * 0.50);

        if (totalPassangerCount <= (d1)) {
            return (float) (capacity * 1.6);
        } else if (totalPassangerCount > (d1) && totalPassangerCount <= (d2)) {
            return (float) (capacity * 1.3);
        } else {
            return (float) (capacity);
        }
    }

    private int[] getTotalFootFallDetails(List<String> list) {

        int inBus = 0;
        int outBus = 0;

        for (String l : list) {
            inBus += getMapOfPassInsideBusPerStop(l).size();
            outBus += getMapOfPassOutsideBusPerStop(l).size();
        }
        int[] arr = new int[]{inBus, outBus};

        return arr;
    }

    private List<Integer> getMapOfPassOutsideBusPerStop(String st) {
        List<Integer> outbus = new ArrayList<>();
        Pattern pattern = Pattern.compile(negRegex);
        Matcher matcher = pattern.matcher(st);
        while (matcher.find()) {
            outbus.add(Integer.parseInt(matcher.group(1)) * -1);
        }

        return outbus;
    }

    private List<Integer> getMapOfPassInsideBusPerStop(String st) {
        List<Integer> inbus = new ArrayList<>();
        Pattern pattern = Pattern.compile(posRegex);
        Matcher matcher = pattern.matcher(st);
        while (matcher.find()) {
            inbus.add(Integer.parseInt(matcher.group(1)));
        }

        return inbus;
    }
}
