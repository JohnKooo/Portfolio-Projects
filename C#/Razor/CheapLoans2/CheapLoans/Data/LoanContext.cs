using Microsoft.EntityFrameworkCore;
using CheapLoans.Models;

namespace CheapLoans.Data
{
    public class LoanContext : DbContext
    {
        public LoanContext(DbContextOptions<LoanContext> options) : base(options)
        {

        }

        public DbSet<Loan> Loans { get; set; }
    }
}
