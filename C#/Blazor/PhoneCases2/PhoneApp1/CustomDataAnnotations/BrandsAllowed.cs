using System.ComponentModel.DataAnnotations;

namespace PhoneApp2;

public class BrandsAllowed : ValidationAttribute
{
    private readonly string[] _brandsAllowed;

    public BrandsAllowed(string[] bAllowed)
    {
        _brandsAllowed = bAllowed;
    }

    protected override ValidationResult IsValid(object value, ValidationContext validation)
    {
        if (value == null || _brandsAllowed.Contains(value.ToString()))
        {
            return ValidationResult.Success;
        }else{
            return new ValidationResult("the brand entered is not one of the valid options");
        }
    }
}
