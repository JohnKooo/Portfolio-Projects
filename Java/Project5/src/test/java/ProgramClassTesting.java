import org.junit.jupiter.api.Test;
import org.main.objects.Trip;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramClassTesting {
    @Test
    public void testingGuardingIfForNoTrips() {
        ArrayList<Trip> trips = new ArrayList<>();
        String error = "";
        for (int i = 0; i < trips.size(); i++) {
            System.out.println((i + 1) + ": " + trips.get(i).toString());
        }
        while (true) {
            if (trips.size() == 0){
                error = ("You dont have any trips!");
                break;
            }
            try {
                System.out.println("Enter the number of the trip you want to remove:\n");
                int userChoice = 1;
                if (trips.get(userChoice - 1) == null) {
                    error = ("Please select a current trip shown!");
                }else {
                    trips.remove(userChoice - 1);
                    break;
                }
            } catch (Exception e) {
                System.out.println("error!");
            }
        }

        assertEquals("You dont have any trips!", error);
    }
}
