using Microsoft.AspNetCore.Mvc;
using ShippingCalc.Data;
using ShippingCalc.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc.ModelBinding;

namespace ShippingCalc.Controllers
{
    public class ShipCalcController : Controller
    {
        private readonly AppDbContext _context;

        public ShipCalcController (AppDbContext context)
        {
            _context = context;
        }
        // GET: ShipCalcController
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Index(ObjectItem model)
        {
            if (ModelState.IsValid)
            {
                switch (model.PizzaSize)
                {
                    case PizzaSize.Small:
                        model.BaseCost = 8;
                        break;
                    case PizzaSize.Medium:
                        model.BaseCost = 10;
                        break;
                    case PizzaSize.Large:
                        model.BaseCost = 12;
                        break;
                }
                switch (model.CrustType)
                {
                    case CrustType.Thin:
                        model.CrustCost = 0;
                        break;
                    case CrustType.Regular:
                        model.CrustCost = 2;
                        break;
                    case CrustType.Stuffed:
                        model.CrustCost = 4;
                        break;
                }

                model.ToppingCost = model.NumberOfToppings.Count * 1.50f;
                model.SubTotal = (model.BaseCost + model.CrustCost + model.ToppingCost) * model.NumberOfPizzas;
                model.TotalCost = model.SubTotal * 1.08f;
                return View(model);
            }

            return View(model);
        }

        [HttpPost]
        public async Task<IActionResult> SaveItem(ObjectItem model)
        {
            if (ModelState.IsValid)
            {
                _context.Add(model);
                await _context.SaveChangesAsync();
                TempData["SuccessMessage"] = "Order Saved!";
                return RedirectToAction(nameof(Index));
            }
            return View("Index");
        }

        public async Task<ActionResult> Display()
        {
            return View(await _context.Objects.ToListAsync());
        }
    }
}
