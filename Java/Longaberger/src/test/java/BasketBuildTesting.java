import Longaberger.BasketBuild;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasketBuildTesting {


    @Test
    public void basketBuildTest(){
        BasketBuild e = new BasketBuild();
        assertEquals('U', e.getBasket_type());
        assertEquals("A4", e.getAccessory_type());
        assertEquals(1, e.getCustomer_type());
        assertEquals("IA", e.getState());
    }
    @Test
    public void calculationsCTest(){
        BasketBuild e = new BasketBuild('C',"A1",1,"IA");
        e.calculations();
        assertEquals(19.75, e.getBasket_amount());
        assertEquals(9.875, e.getDiscount());
        assertEquals(9.875, e.getSubtotal());
        assertEquals(0.5925, e.getTax());
        assertEquals(10.4675, e.getTotal_cost());
    }
    @Test
    public void calculationsWTest(){
        BasketBuild e = new BasketBuild('W',"A2",2,"IL");
        e.calculations();
        assertEquals(61.25, e.getBasket_amount());
        assertEquals(0, e.getDiscount());
        assertEquals(61.25, e.getSubtotal());
        assertEquals(3.828125, e.getTax());
        assertEquals(65.078125, e.getTotal_cost());
    }
    @Test
    public void calculationsKTest(){
        BasketBuild e = new BasketBuild('K',"A3",3,"MO");
        e.calculations();
        assertEquals(33.7, e.getBasket_amount());
        assertEquals(3.3700000000000006, e.getDiscount());
        assertEquals(30.330000000000002, e.getSubtotal());
        assertEquals(1.2814425000000003, e.getTax());
        assertEquals(31.611442500000003, e.getTotal_cost());
    }
    @Test
    public void calculationsMTest(){
        BasketBuild e = new BasketBuild('M',"A4",1,"IA");
        e.calculations();
        assertEquals(34.2, e.getBasket_amount());
        assertEquals(17.1, e.getDiscount());
        assertEquals(17.1, e.getSubtotal());
        assertEquals(1.026, e.getTax());
        assertEquals(18.126, e.getTotal_cost());
    }
    @Test
    public void calculationsUTest(){
        BasketBuild e = new BasketBuild('U',"A1",1,"IA");
        e.calculations();
        assertEquals(117.52, e.getBasket_amount());
        assertEquals(58.76, e.getDiscount());
        assertEquals(58.76, e.getSubtotal());
        assertEquals(3.5256, e.getTax());
        assertEquals(62.285599999999995, e.getTotal_cost());
    }
    @Test
    public void toStringTest(){
        BasketBuild e = new BasketBuild('U',"A1",1,"IA");
        e.calculations();
        String output = """
                The date today is: 08/01/2023
                The basket name is: Umbrella
                The accessory name is: Protector
                Your state is: IA
                Your customer type is: Dealer
                Your basket cost is: 117.52
                Your discount amount is: 58.76
                Your subtotal is: 58.76
                Your tax is: 3.53
                Your total cost is: 62.29""";

        assertEquals(output, e.toString());
    }


}
