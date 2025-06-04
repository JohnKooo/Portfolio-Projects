import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.main.exceptions.NoObjectFoundException;
import org.main.objects.Agent;
import org.main.objects.Guest;
import org.main.objects.Nationality;
import org.main.objects.Trip;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripClassTesting {
    @Test
    public void addingGuestToAnArrayListTest_AddOneGuest() {
        Trip a = new Trip();
        Guest g = new Guest();
        a.addGuest(g);
        assertEquals(g,a.getGuest().get(0));
    }

    @Test
    public void testingAllSettersInTripClass(){
        LocalDate dateNow = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(6);
        Agent a = new Agent("Joe", "Mo", Nationality.USA,"123-123-1234",20000);
        ArrayList<Guest> g = new ArrayList<>();
        g.add(new Guest("John","Ko", Nationality.USA,true,true));

        Trip t = new Trip(a,g,1000,dateNow,endDate);

        assertEquals("Joe",t.getAgent().getFirstName());
        assertEquals("Mo",t.getAgent().getLastName());
        assertEquals(Nationality.USA,t.getAgent().getNationality());
        assertEquals("123-123-1234",t.getAgent().getPhoneNumber());
        assertEquals(20000,t.getAgent().getSalary());
        assertEquals("John",t.getGuest().get(0).getFirstName());
        assertEquals("Ko",t.getGuest().get(0).getLastName());
        assertEquals(Nationality.USA,t.getGuest().get(0).getNationality());
        assertEquals(true,t.getGuest().get(0).getMealPlan());
        assertEquals(true,t.getGuest().get(0).getPaid());
        assertEquals(1000,t.getCost());
        assertEquals(dateNow,t.getStartDate());
        assertEquals(endDate,t.getEndDate());
    }

    @Test
    public void testingCustomExceptions(){
        Trip t = new Trip();
        System.out.println("??");
        Assertions.assertThrows(NoObjectFoundException.class, () -> t.addGuest(null));
    }

}
