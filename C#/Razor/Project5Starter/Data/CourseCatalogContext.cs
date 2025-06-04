using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using CourseCatalog.Models;

namespace CourseCatalog.Data
{
    public class CourseCatalogContext : DbContext
    {
        public CourseCatalogContext (DbContextOptions<CourseCatalogContext> options)
            : base(options)
        {
        }

        public DbSet<CourseCatalog.Models.Course> Course { get; set; } = default!;
    }
}
