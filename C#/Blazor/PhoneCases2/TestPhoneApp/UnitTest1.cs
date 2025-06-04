using Bunit;
using Xunit;
using PhoneApp1.Components.Pages;
using AngleSharp.Dom;
using Microsoft.AspNetCore.Components.Forms;
using Newtonsoft.Json;



// Phone case brand is required
// Phone case brand should not exceed 25 characters
// Model is required
// Model should not exceed 25 characters
// Material is required
// Material cannot exceed 30 characters.
// Price is required
// Price is within valid range (1 - 500)
// Trim color is required
// trim Color should need exceed 30 characters
// Accent color is required
// Accent color should not exceed 30 characters
namespace TestPhoneApp;
public class UnitTest1 : TestContext
{
    [Fact]
    public void TestBrandRequired()
    {
        var component = RenderComponent<Home>();

        component.Find("#brand").Change("Iphone");

        component.Find("button").Click();

        string inputString = component.Find("#brand").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestBrandNotExceed25Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#brand").Change("123456789112345678911234");

        component.Find("button").Click();

        string inputString = component.Find("#brand").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestModelRequired()
    {
        var component = RenderComponent<Home>();

        component.Find("#model").Change("SE 2nd Gen");

        component.Find("button").Click();

        string inputString = component.Find("#model").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestModelNotExceed25Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#model").Change("123456789112345678911234");

        component.Find("button").Click();

        string inputString = component.Find("#model").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestMaterialRequired()
    {
        var component = RenderComponent<Home>();

        component.Find("#material").Change("plastic");

        component.Find("button").Click();

        string inputString = component.Find("#material").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestMaterialNotExceed25Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#material").Change("123456789012345678901234");

        component.Find("button").Click();

        string inputString = component.Find("#material").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestPriceRequired()
    {
        var component = RenderComponent<Home>();

        component.Find("#maxCostAmount").Change("2");

        component.Find("button").Click();

        string inputString = component.Find("#maxCostAmount").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestPriceWithinRange() // 1$-500$
    {
        var component = RenderComponent<Home>();

        component.Find("#model").Change("1");

        component.Find("button").Click();

        string inputString = component.Find("#model").OuterHtml;

        Assert.Contains("valid", inputString);

        component.Find("#model").Change("500");

        component.Find("button").Click();

        inputString = component.Find("#model").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestTrimColorRequired()
    {
        var component = RenderComponent<Home>();

        component.Find("#trimColor").Change("black");

        component.Find("button").Click();

        string inputString = component.Find("#trimColor").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestTrimColorNotExceed30Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#trimColor").Change("12345678901234567890123456789");

        component.Find("button").Click();

        string inputString = component.Find("#trimColor").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestAccentColorRequired()
    {
        var component = RenderComponent<Home>();

        component.Find("#accentColor").Change("blue");

        component.Find("button").Click();

        string inputString = component.Find("#accentColor").OuterHtml;

        Assert.Contains("valid", inputString);
    }
    [Fact]
    public void TestAccentColorNotExceed30Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#accentColor").Change("123456789012345678901234567890");

        component.Find("button").Click();

        string inputString = component.Find("#accentColor").OuterHtml;

        Assert.Contains("valid", inputString);
    }

    // Opposite checks below ********************************************************************************************************************************************

    [Fact]
    public void TestBrandEmpty()
    {
        var component = RenderComponent<Home>();

        component.Find("#brand").Change("");

        component.Find("button").Click();

        string inputString = component.Find("#brand").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestBrandExceeds25Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#brand").Change("12345678911234567891123456");

        component.Find("button").Click();

        string inputString = component.Find("#brand").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestModelEmpty()
    {
        var component = RenderComponent<Home>();

        component.Find("#model").Change("");

        component.Find("button").Click();

        string inputString = component.Find("#model").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestModelExceeds25Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#model").Change("12345678911234567891123456");

        component.Find("button").Click();

        string inputString = component.Find("#model").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestMaterialEmpty()
    {
        var component = RenderComponent<Home>();

        component.Find("#material").Change("");

        component.Find("button").Click();

        string inputString = component.Find("#material").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestMaterialExceeds30Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#material").Change("1234567890123456789012345678901");

        component.Find("button").Click();

        string inputString = component.Find("#material").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestPriceEmpty()
    {
        var component = RenderComponent<Home>();

        component.Find("#maxCostAmount").Change("");

        component.Find("button").Click();

        string inputString = component.Find("#maxCostAmount").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestPriceOutOfRange() // 1$-500$
    {
        var component = RenderComponent<Home>();

        component.Find("#maxCostAmount").Change("0");

        component.Find("button").Click();

        string inputString = component.Find("#maxCostAmount").OuterHtml;

        Assert.Contains("invalid", inputString);

        component.Find("#maxCostAmount").Change("501");

        component.Find("button").Click();

        inputString = component.Find("#maxCostAmount").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestTrimColorEmpty()
    {
        var component = RenderComponent<Home>();

        component.Find("#trimColor").Change("");

        component.Find("button").Click();

        string inputString = component.Find("#trimColor").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestTrimColorExceeds30Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#trimColor").Change("1234567890123456789012345678901");

        component.Find("button").Click();

        string inputString = component.Find("#trimColor").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestAccentColorEmpty()
    {
        var component = RenderComponent<Home>();

        component.Find("#accentColor").Change("");

        component.Find("button").Click();

        string inputString = component.Find("#accentColor").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
    [Fact]
    public void TestAccentColorExceeds30Characters()
    {
        var component = RenderComponent<Home>();

        component.Find("#accentColor").Change("1234567890123456789012345678901");

        component.Find("button").Click();

        string inputString = component.Find("#accentColor").OuterHtml;

        Assert.Contains("invalid", inputString);
    }
}