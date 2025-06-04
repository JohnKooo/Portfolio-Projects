using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Diagnostics.Tracing;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using System.Xml.Serialization;

namespace ShippingCalc.Models;

public class ObjectItem
{
    [Key]
    public int Id { get; set;}
    public int KrabbyPattyCount { get; set;}
    public int DoubleKrabbyPattyCount { get; set; }
    public int KrabbyMealCount { get; set; }
    public int KelpShakeCount { get; set; }
    public int CoralBitsCount { get; set; }
    public int KelpFriesCount { get; set; } 
    public float TotalAll { get; set; }
    public float TaxAll { get; set; }
    public float TipAll { get; set; }
    public float GrantTotal { get; set; }

    // help property's below
    [NotMapped]
    public bool One { get; set; }
    [NotMapped]
    public bool Two { get; set; }
    [NotMapped]
    public bool Three { get; set; }
    [NotMapped]
    public bool Four { get; set; }
    [NotMapped]
    public bool Five { get; set; }
    [NotMapped]
    public bool Six { get; set; }
    [NotMapped]
    public float KrabbyPattyTotal { get; set;}
    [NotMapped]
    public float DoubleKrabbyPattyTotal { get; set; }
    [NotMapped]
    public float KrabbyMealTotal { get; set; }
    [NotMapped]
    public float KelpShakeTotal { get; set; }
    [NotMapped]
    public float CoralBitsTotal { get; set; }
    [NotMapped]
    public float KelpFriesTotal { get; set; } 
    [NotMapped]
    public int TipAmount { get; set; } 
}
