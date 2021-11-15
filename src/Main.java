import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int capacity; int stops;
        List<String> listOfInputs=new ArrayList<>(); BusProb bp = new BusProb();
        /*Can be used for test case 12,15,17*/
       /* capacity=18; stops=8;
        listOfInputs.add("+12412 +5465 +5241 +52425 +21032 +21315");
        listOfInputs.add("+5645 +56412 +41524 -12412 -21032 -21315");
        listOfInputs.add("+56456 +46423 +12412 -5645 -52425 -5241 -5465");
        listOfInputs.add("+1543 +1873 +28466 -12412 -56456 -41524");
        listOfInputs.add("+35456 +36874 +4654 +12412 -1543");
        listOfInputs.add("+4879 +4131 +532 +562 -28466 -12412");
        listOfInputs.add("+65446 +10412 +12412 +68723 -532");
        listOfInputs.add("+7545 +8651 -4131 -562"); String query="2";
        String actual=bp.output(capacity, stops, listOfInputs, query);
        System.out.println(actual);
        System.out.println(actual.hashCode());  //93.6, 1325126904
*/
        capacity=30;
        stops=12;
        listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
        listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
        listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
        listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
        listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
        listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
        listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
        listOfInputs.add("+141 +142");
        listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
        listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
        listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
        listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
        String query1="2";
        String actual1=bp.output(capacity, stops, listOfInputs, query1);
        System.out.println(actual1);
        System.out.println(actual1.hashCode());      //99.0, 1609639898


    }
}
