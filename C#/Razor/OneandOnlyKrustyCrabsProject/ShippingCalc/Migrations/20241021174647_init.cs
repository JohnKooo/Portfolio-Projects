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
                    KrabbyPattyCount = table.Column<int>(type: "INTEGER", nullable: false),
                    DoubleKrabbyPattyCount = table.Column<int>(type: "INTEGER", nullable: false),
                    KrabbyMealCount = table.Column<int>(type: "INTEGER", nullable: false),
                    KelpShakeCount = table.Column<int>(type: "INTEGER", nullable: false),
                    CoralBitsCount = table.Column<int>(type: "INTEGER", nullable: false),
                    KelpFriesCount = table.Column<int>(type: "INTEGER", nullable: false),
                    TotalAll = table.Column<float>(type: "REAL", nullable: false),
                    TaxAll = table.Column<float>(type: "REAL", nullable: false),
                    TipAll = table.Column<float>(type: "REAL", nullable: false),
                    GrantTotal = table.Column<float>(type: "REAL", nullable: false)
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
