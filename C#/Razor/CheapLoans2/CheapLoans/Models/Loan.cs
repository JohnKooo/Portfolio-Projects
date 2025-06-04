using System.ComponentModel.DataAnnotations;

namespace CheapLoans.Models
{
    public class Loan
    {
        public int LoanId { get; set; }

        [Required]
        public string CustName { get; set; }

        [Required]
        public double LoanAmount { get; set; }
        public double AnnualIntRate { get; set; }
        public int NumPayments { get; set; }
        public double CalcMonthlyPay { get; set; }
    }
}
