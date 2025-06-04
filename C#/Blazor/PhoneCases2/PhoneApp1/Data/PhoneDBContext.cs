using Microsoft.EntityFrameworkCore;
using PhoneApp2.Models;

namespace PhoneApp2.Data;

public class PhoneDBContext : DbContext
{
    static readonly string connectionString = "server=localhost;database=phonecase;user=root;password=1111;";

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseMySql(connectionString, ServerVersion.AutoDetect(connectionString));
    }

    public DbSet<Phone> Phones{ get; set; }
}
