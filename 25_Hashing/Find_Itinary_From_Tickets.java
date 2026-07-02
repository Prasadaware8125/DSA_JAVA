import java.util.HashSet;
import java.util.HashMap;
// "Chennai" -> "Bengaluru"
// "Mumbai" -> "Delhi"
// "Goa" -> "Chennai"
// "Delhi" -> "Goa"

// "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Bengaluru"

public class Find_Itinary_From_Tickets {
    // O(n) for finding starting point
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet() ) {
            revMap.put(tickets.get(key), key);
        }

        for( String key : tickets.keySet() ) {
            if( !revMap.containsKey(key) ) {
                return key;     // Start
            }
        }

        return null;
    }

    // TC = O(n)
    public static void find_itinary_from_tickets(HashMap<String, String> tickets) {
        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet() ) {
            System.out.print(" -> "+tickets.get(start));
            start = tickets.get(start);
        }
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        find_itinary_from_tickets(tickets);
    }
}