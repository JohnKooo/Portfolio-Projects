using System;
using Microsoft.EntityFrameworkCore;
using QuickMVCApp.Models;
namespace QuickMVCApp.Data;

public class AppDbContext : DbContext
{
    public DbSet<Product> Products { get; set; }
    public DbSet<GameStats> GameStats{ get; set; }

    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }
}
