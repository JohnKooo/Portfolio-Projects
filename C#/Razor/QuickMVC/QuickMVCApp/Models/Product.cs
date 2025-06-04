using System;
using System.ComponentModel.DataAnnotations;

namespace QuickMVCApp.Models;

public class Product
{
    [Key]
    public int Id { get; set; }
    [Required(ErrorMessage = "Name is required")]
    [StringLength(50, ErrorMessage = "Name cannot be longer than 50 characters")]
    [MinLength(12, ErrorMessage = "Name cannot be less than 12 characters")]
    public string Name { get; set; }
    [Range(1,50, ErrorMessage = "Price must be between 1 and 50")]
    public decimal Price { get; set; }
}
