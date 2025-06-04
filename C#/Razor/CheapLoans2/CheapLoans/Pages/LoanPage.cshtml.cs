using CheapLoans.Data;
using CheapLoans.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.VisualBasic;
using System.ComponentModel.DataAnnotations;

namespace CheapLoans.Pages
{
    public class LoanPageModel : PageModel
    {

        private readonly LoanContext _context;
        public LoanPageModel(LoanContext context)
        {
            _context = context;
        }

        [BindProperty]
        [Required(ErrorMessage = "Required")]
        public string CustName { get; set; }

        [BindProperty]
        [Required(ErrorMessage = "Required")]
        public string LoanAmount { get; set; }

        [BindProperty]
        [Required(ErrorMessage = "Required")]
        public string AnnualIntRate { get; set; }

        [BindProperty]
        [Required(ErrorMessage = "Required")]
        public string NumPayments { get; set; }

        public double CalcMonthlyPay { get; set; }
        public Loan SLoan { get; set; }

        public async Task<IActionResult> OnPostLoanCalc()
        {
            if (ModelState.IsValid)
            {
                string custName = CustName;
                double loanAmount = double.Parse(LoanAmount);
                double annualIntRate = double.Parse(AnnualIntRate);
                int numPayments = int.Parse(NumPayments);

                double rate = ((annualIntRate / 100) / 12);

                CalcMonthlyPay = Financial.Pmt(rate,numPayments, -loanAmount);

                var loan = new Loan
                {
                    CustName = custName,
                    LoanAmount = loanAmount,
                    AnnualIntRate = annualIntRate,
                    NumPayments = numPayments,
                    CalcMonthlyPay = Math.Round(CalcMonthlyPay, 2)
                };

                SLoan = loan;
                _context.Loans.Add(loan);
                await _context.SaveChangesAsync();

            }
            return Page();
        }

//        public async Task<IActionResult> OnPostSave()
//        {
            //_context.Loans.Add(SLoan);
            //await _context.SaveChangesAsync();
//            SLoan = null;
//            return Page();
//        }
        
    }
}
