using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace CheapLoans.Migrations
{
    /// <inheritdoc />
    public partial class initial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Loans",
                columns: table => new
                {
                    LoanId = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    CustName = table.Column<string>(type: "TEXT", nullable: false),
                    LoanAmount = table.Column<double>(type: "REAL", nullable: false),
                    AnnualIntRate = table.Column<double>(type: "REAL", nullable: false),
                    NumPayments = table.Column<int>(type: "INTEGER", nullable: false),
                    CalcMonthlyPay = table.Column<double>(type: "REAL", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Loans", x => x.LoanId);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Loans");
        }
    }
}
