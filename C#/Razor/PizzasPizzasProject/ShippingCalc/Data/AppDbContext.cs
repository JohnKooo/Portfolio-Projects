using System;
using Microsoft.EntityFrameworkCore;
using ShippingCalc.Models;

namespace ShippingCalc.Data;

public class AppDbContext : DbContext
{
    public DbSet<ObjectItem> Objects { get; set; }

    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }
}
