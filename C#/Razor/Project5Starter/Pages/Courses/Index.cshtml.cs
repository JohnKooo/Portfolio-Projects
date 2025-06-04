using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using CourseCatalog.Data;
using CourseCatalog.Models;

namespace CourseCatalog.Pages.Courses
{
    public class IndexModel : PageModel
    {
        private readonly CourseCatalog.Data.CourseCatalogContext _context;

        public IndexModel(CourseCatalog.Data.CourseCatalogContext context)
        {
            _context = context;
        }

        public IList<Course> Course { get;set; } = default!;

        public async Task OnGetAsync()
        {
            if (_context.Course != null)
            {
                Course = await _context.Course.ToListAsync();
            }
        }
    }
}
