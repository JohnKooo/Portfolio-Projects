using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ShippingCalc.Migrations
{
    /// <inheritdoc />
    public partial class init : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Objects",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    PizzaSize = table.Column<int>(type: "INTEGER", nullable: false),
                    CrustType = table.Column<int>(type: "INTEGER", nullable: false),
                    NumberOfToppings = table.Column<string>(type: "TEXT", nullable: false),
                    NumberOfPizzas = table.Column<float>(type: "REAL", nullable: false),
                    BaseCost = table.Column<float>(type: "REAL", nullable: false),
                    CrustCost = table.Column<float>(type: "REAL", nullable: false),
                    ToppingCost = table.Column<float>(type: "REAL", nullable: false),
                    SubTotal = table.Column<float>(type: "REAL", nullable: false),
                    TotalCost = table.Column<float>(type: "REAL", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Objects", x => x.Id);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Objects");
        }
    }
}
