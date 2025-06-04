import org.example.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testingLabel {
    @Test
    public void defaultConstructorsTesting(){
        Label newLabel = new Label();
        assertEquals("Nurds", newLabel.getProductName());
        assertEquals(60, newLabel.getCaloriesPerServing());
        assertEquals(9, newLabel.getServingPerContainer());
        assertEquals(0, newLabel.getSodiumPerServing());
    }

    @Test
    public void OverloadedConstructorsTesting(){
        Label newLabel = new Label("candy", 10, 5, 2);
        assertEquals("candy", newLabel.getProductName());
        assertEquals(10, newLabel.getCaloriesPerServing());
        assertEquals(5, newLabel.getServingPerContainer());
        assertEquals(2, newLabel.getSodiumPerServing());
    }

    @Test
    public void toStringTesting(){
        Label newLabel = new Label();

        String newLabelString = newLabel.toString();
        assertEquals("1 Serving Of: Nurds\n" +
                "Calories: 60\n" +
                "Sodium: 0.0\n" +
                "\n" +
                "\n" +
                "Serving of Whole Container: \n" +
                "Calories: 540\n" +
                "Sodium: 0.0\n" +
                "This Would be less than the daily limit!", newLabelString);
    }

    @Test
    public void MethodTesting(){
        Label a = new Label();

        assertEquals(540, a.totalNumCalories());
        assertEquals(0, a.totalNumSodium());
    }

    @Test
    public void validationTestingForConstructorsBelow(){
        Label a = new Label("",-1,-1,-1);

        assertEquals("Null", a.getProductName());
        assertEquals(0, a.getCaloriesPerServing());
        assertEquals(0, a.getServingPerContainer());
        assertEquals(0, a.getSodiumPerServing());
    }


}
