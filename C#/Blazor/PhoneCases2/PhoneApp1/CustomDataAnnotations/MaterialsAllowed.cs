using System.ComponentModel.DataAnnotations;

namespace PhoneApp2;

public class MaterialsAllowed : ValidationAttribute
{
    private readonly string[] _materialsAllowed;

    public MaterialsAllowed(string[] mAllowed)
    {
        _materialsAllowed = mAllowed;
    }

    protected override ValidationResult IsValid(object value, ValidationContext validation)
    {
        if (value == null || _materialsAllowed.Contains(value.ToString()))
        {
            return ValidationResult.Success;
        }else{
            return new ValidationResult("the material entered is not one of the valid options");
        }
    }
}
