using System.ComponentModel.DataAnnotations;

namespace PhoneApp2;

public class AccentColorsAllowed : ValidationAttribute
{
    private readonly string[] _accentColorsAllowed;

    public AccentColorsAllowed(string[] acAllowed)
    {
        _accentColorsAllowed = acAllowed;
    }

    protected override ValidationResult IsValid(object value, ValidationContext validation)
    {
        if (value == null || _accentColorsAllowed.Contains(value.ToString()))
        {
            return ValidationResult.Success;
        }else{
            return new ValidationResult("the accent colors entered is not one of the valid options");
        }
    }
}
