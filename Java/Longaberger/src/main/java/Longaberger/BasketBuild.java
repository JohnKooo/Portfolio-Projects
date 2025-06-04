package Longaberger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BasketBuild {
    private char basket_type;
    private String accessory_type;
    private String state;
    private int customer_type;
    private double basket_amount;
    private double discount;
    private double subtotal;
    private double tax;
    private double total_cost;
    private double basket_cost;
    private double accessory_cost;
    private double tax_rate;
    private double customer_discount_rate;
    private String basket_name;
    private String accessory_name;
    private String customer_name;

    // accumulators bellow
    public char getBasket_type() {
        return basket_type;
    }

    public String getAccessory_type() {
        return accessory_type;
    }

    public String getState() {
        return state;
    }

    public int getCustomer_type() {
        return customer_type;
    }

    public double getBasket_amount() {
        return basket_amount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public double getBasket_cost() {
        return basket_cost;
    }

    public double getAccessory_cost() {
        return accessory_cost;
    }

    public double getTax_rate() {
        return tax_rate;
    }

    public double getCustomer_discount_rate() {
        return customer_discount_rate;
    }

    public String getBasket_name() {
        return basket_name;
    }

    public String getAccessory_name() {
        return accessory_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    // mutators bellow
    public void setBasket_type(char basket_type) {
        this.basket_type = basket_type;
    }

    public void setAccessory_type(String accessory_type) {
        this.accessory_type = accessory_type;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCustomer_type(int customer_type) {
        this.customer_type = customer_type;
    }

    public void setBasket_amount(double basket_amount) {
        this.basket_amount = basket_amount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public void setBasket_cost(double basket_cost) {
        this.basket_cost = basket_cost;
    }

    public void setAccessory_cost(double accessory_cost) {
        this.accessory_cost = accessory_cost;
    }

    public void setTax_rate(double tax_rate) {
        this.tax_rate = tax_rate;
    }

    public void setCustomer_discount_rate(double customer_discount_rate) {
        this.customer_discount_rate = customer_discount_rate;
    }

    public void setBasket_name(String basket_name) {
        this.basket_name = basket_name;
    }

    public void setAccessory_name(String accessory_name) {
        this.accessory_name = accessory_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    // default constructor bellow
    public BasketBuild(){
        setBasket_type('U');
        setAccessory_type("A4");
        setCustomer_type(1);
        setState("IA");
    }
    public BasketBuild(char basket_type, String accessory_type, int customer_type, String state){
        setBasket_type(basket_type);
        setAccessory_type(accessory_type);
        setCustomer_type(customer_type);
        setState(state);
    }

    public void calculations(){
        // setting all basket info below
        int basketIndex = 0;
        char[] basketCodes = {'C','W','K','M','U'};
        for (int i = 0; i < basketCodes.length; i++){
            if (getBasket_type() == basketCodes[i]){
                basketIndex = i;
                break;
            }
        }
        String[] basketLiterals = {"Cracker", "Wildflower", "Key", "Magazine", "Umbrella"};
        double[] basketCosts = {15.00, 53.25, 23.15, 34.20, 112.77};

        setBasket_cost(basketCosts[basketIndex]);
        setBasket_name(basketLiterals[basketIndex]);


        // setting all accessory info below
        int accessoryIndex = 0;
        String[] accessoryCodes = {"A1", "A2", "A3", "A4"};
        for (int i = 0; i < accessoryCodes.length; i++){
            if (getAccessory_type().equals(accessoryCodes[i])){
                accessoryIndex = i;
            }
        }
        String[] accessoryLiterals = {"Protector", "Liner", "Combo", "None"};
        double[] accessoryCosts = {4.75, 8.00, 10.55, 0.00};

        setAccessory_cost(accessoryCosts[accessoryIndex]);
        setAccessory_name(accessoryLiterals[accessoryIndex]);

        // setting customer info below
        String[] customerLiterals = {"Dealer", "Walk In", "Bus"};
        double[] customerCosts = {.50, 0, .10};

        setCustomer_discount_rate(customerCosts[getCustomer_type() - 1]);
        setCustomer_name(customerLiterals[getCustomer_type() - 1]);

        // setting tax rate below
        int stateIndex = 0;
        String[] stateNames = {"IA", "IL", "MO"};
        for (int i = 0; i <3; i++){
            if (getState().equals(stateNames[i])){
                stateIndex = i;
            }
        }
        double[] stateTaxRates = {.06, .0625, .04225};
        setTax_rate(stateTaxRates[stateIndex]);

        // all the switch's bellow set the correct values to the accumulators
        setBasket_amount(getBasket_cost() + getAccessory_cost());
        setDiscount(getBasket_amount() * getCustomer_discount_rate());
        setSubtotal(getBasket_amount() - getDiscount());
        setTax(getSubtotal() * getTax_rate());
        setTotal_cost(getSubtotal() + getTax());
    }

    @Override
    public String toString(){
        // the code bellow is to grab the date and format it into a more readable format.
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String readable_date = date.format(formatter);

        return ("The date today is: " + readable_date)+
         ("\nThe basket name is: " + getBasket_name())+
         ("\nThe accessory name is: " + getAccessory_name())+
         ("\nYour state is: " + getState())+
         ("\nYour customer type is: " + getCustomer_name())+
         String.format("\nYour basket cost is: " + "%,.2f%n" , getBasket_amount())+
         String.format("Your discount amount is: " + "%,.2f%n" , getDiscount())+
         String.format("Your subtotal is: " + "%,.2f%n" , getSubtotal())+
         String.format("Your tax is: " + "%,.2f%n", getTax())+
         String.format("Your total cost is: " + "%,.2f" , getTotal_cost());
    }
}
