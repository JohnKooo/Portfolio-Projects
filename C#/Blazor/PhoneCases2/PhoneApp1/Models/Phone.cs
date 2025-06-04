using System.ComponentModel.DataAnnotations;

namespace PhoneApp2.Models;

public class Phone{
        public int Id { get; set; }
        public const int totalPhoneCost = 850;
        public string totalCostErrorString = $"Cost must be atleast 1$ and no greater {totalPhoneCost} than 500$!";
        public float totalBeforeTax = 0;
        public float totalTax = 0;
        public float grandTotal = 0;

        [Required(ErrorMessage="Brand required!")]
        [StringLength(25, ErrorMessage="Brand length too long!")]
        [RegularExpression(@"^[a-zA-Z]+$", ErrorMessage = "Brand must contain only alphabets")]
        [BrandsAllowed(new string[] {"Apple", "Samsung", "Razer", "TheAlmightyMotorola"})]
        public string Brand {get;set;}

        [Required(ErrorMessage ="Model required!")]
        [StringLength(25, ErrorMessage="Model length too long!")]
        [RegularExpression(@"^[a-zA-Z]+$", ErrorMessage = "Model must contain only alphabets")]
        public string Model {get;set;}

        [Required(ErrorMessage="Material required!")]
        [StringLength(30, ErrorMessage="Material length too long!")]
        [RegularExpression(@"^[a-zA-Z { }]+$", ErrorMessage = "Material must contain only alphabets")]
        [MaterialsAllowed(new string[] {"Carbon Fiber", "Metal", "Titanium", "Plastic", "Sheet Metal", "Clam Shell", "Faux Animal Fur", "Apples"})]
        public string Material {get;set;}

        [Required(ErrorMessage="Max cost required!")]
        [Range(1,totalPhoneCost, ErrorMessage = "Cost must be atleast 1$ and no greater than 850$!")]
        public float MaxCostAmount {get;set;}

        [Required(ErrorMessage="Trim color required!")]
        [StringLength(30, ErrorMessage="Trim Color length too long!")]
        [RegularExpression(@"^[a-zA-Z]+$", ErrorMessage = "Trim color must contain only alphabets")]
        public string TrimColor {get;set;}

        [Required(ErrorMessage="Accent color required!")]
        [StringLength(30, ErrorMessage="Accent color length too long!")]
        [RegularExpression(@"^[a-zA-Z]+$", ErrorMessage = "Accent color must contain only alphabets")]
        [AccentColorsAllowed(new string[] {"Blue", "Pink", "Yellow", "Green", "Greener", "Yellowish", "Blueberry"} )]
        public string AccentColor {get;set;}
    }
