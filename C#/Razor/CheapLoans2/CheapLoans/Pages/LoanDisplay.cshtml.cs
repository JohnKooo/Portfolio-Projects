using CheapLoans.Data;
using CheapLoans.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.Threading.Tasks;

namespace CheapLoans.Pages
{
    public class LoanDisplayModel : PageModel
    {
        private readonly LoanContext _context;
        public LoanDisplayModel(LoanContext context)
        {
            _context = context;
        }
        public IList<Loan> Loans { get; set; }
        public async Task<IActionResult> OnPostDisplay()
        {
            Loans = await _context.Loans.ToListAsync();
            return Page();
        }
        public async Task<IActionResult> OnPostDisplay1()
        {
            Loans = await _context.Loans.FromSqlRaw("SELECT * FROM loans WHERE LoanAmount > 25000").ToListAsync();
            return Page();
        }
        public async Task<IActionResult> OnPostDisplay2()
        {
            Loans = await _context.Loans.FromSqlRaw("SELECT * FROM loans WHERE LoanAmount < 25000 AND LoanAmount >= 10000").ToListAsync();
            return Page();
        }
        public async Task<IActionResult> OnPostDisplay3()
        {
            Loans = await _context.Loans.FromSqlRaw("SELECT * FROM loans WHERE LoanAmount < 10000").ToListAsync();
            return Page();
        }
    }
}
