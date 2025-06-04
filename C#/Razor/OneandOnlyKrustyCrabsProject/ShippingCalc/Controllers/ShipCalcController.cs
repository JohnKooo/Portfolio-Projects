using Microsoft.AspNetCore.Mvc;
using ShippingCalc.Data;
using ShippingCalc.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Microsoft.EntityFrameworkCore.Metadata.Internal;

namespace ShippingCalc.Controllers
{
    public class ShipCalcController : Controller
    {
        private float _kp = 2.99f;
        private float _dkp = 3.99f;
        private float _km = 5.99f;
        private float _ks = 1.50f;
        private float _cb = 2.00f;
        private float _kf = 1.75f;
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
                if (model.One)
                {
                    model.KrabbyPattyTotal = _kp * model.KrabbyPattyCount;
                }else
                {
                    model.KrabbyPattyTotal = 0;
                    model.KrabbyPattyCount = 0;
                }

                if (model.Two)
                {
                    model.DoubleKrabbyPattyTotal = _dkp * model.DoubleKrabbyPattyCount;
                }else
                {
                    model.DoubleKrabbyPattyTotal = 0;
                    model.DoubleKrabbyPattyCount = 0;
                }

                if (model.Three)
                {
                    model.KrabbyMealTotal = _km * model.KrabbyMealCount;
                }else
                {
                    model.KrabbyMealTotal = 0;
                    model.KrabbyMealCount = 0;
                }

                if (model.Four)
                {
                    model.KelpShakeTotal = _ks * model.KelpShakeCount;
                }else
                {
                    model.KelpShakeTotal = 0;
                    model.KelpShakeCount = 0;
                }

                if (model.Five)
                {
                    model.CoralBitsTotal = _cb * model.CoralBitsCount;
                }else
                {
                    model.CoralBitsTotal = 0;
                    model.CoralBitsCount = 0;
                }

                if (model.Six)
                {
                    model.KelpFriesTotal = _kf * model.KelpFriesCount;
                }else
                {
                    model.KelpFriesTotal = 0;
                    model.KelpFriesCount = 0;
                }

                model.TotalAll = model.KrabbyPattyTotal + 
                                 model.DoubleKrabbyPattyTotal + 
                                 model.KrabbyMealTotal +
                                 model.KelpShakeTotal +
                                 model.CoralBitsTotal +
                                 model.KelpFriesTotal;
                                 
                model.TaxAll = model.TotalAll * .07f;
                model.TipAll = model.TotalAll * (model.TipAmount * 100);
                model.GrantTotal = model.TotalAll + model.TaxAll + model.TipAll;
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
    }
}
