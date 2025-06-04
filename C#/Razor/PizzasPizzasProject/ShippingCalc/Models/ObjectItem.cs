using System;
using System.ComponentModel.DataAnnotations;

namespace ShippingCalc.Models;

public enum PizzaSize
{
    Small,
    Medium,
    Large
}
public enum CrustType
{
    Thin,
    Regular,
    Stuffed
}

public class ObjectItem
{
    [Key]
    public int Id { get; set;}
    public PizzaSize PizzaSize { get; set; }
    public CrustType CrustType { get; set;}
    public List<string> NumberOfToppings { get; set; }
    public float NumberOfPizzas { get; set; }

    public float BaseCost { get; set; }
    public float CrustCost { get; set; }
    public float ToppingCost { get; set; }
    public float SubTotal { get; set; }
    public float TotalCost { get; set; }

}
