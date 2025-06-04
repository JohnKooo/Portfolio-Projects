using CourseCatalog.Models;
using Microsoft.EntityFrameworkCore;

namespace CourseCatalog.Data
{
    public class SeedingData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new CourseCatalogContext(
                serviceProvider.GetRequiredService<DbContextOptions<CourseCatalogContext>>()))
            {
                if (context == null || context.Course == null)
                {
                    throw new ArgumentNullException("Null Context");
                }
                if (context.Course.Any())
                {
                    return;
                }
                context.Course.AddRange(
                    new Course()
                    {
                        Id = 101010,
                        CourseName = "CIS 103",
                        CourseDescription = "Class",
                        RoomNumber = 169,
                    },
                    new Course()
                    {
                        Id = 101011,
                        CourseName = "CIS 103",
                        CourseDescription = "Class",
                        RoomNumber = 169,
                        
                    },
                    new Course()
                    {
                        Id = 101012,
                        CourseName = "CIS 103",
                        CourseDescription = "Class",
                        RoomNumber = 169,
                    },
                    new Course()
                    {
                        Id = 101013,
                        CourseName = "CIS 103",
                        CourseDescription = "Class",
                        RoomNumber = 169,
                    },
                    new Course()
                    {
                        Id = 101014,
                        CourseName = "CIS 103",
                        CourseDescription = "Class",
                        RoomNumber = 169,
                    }
                    );
                context.SaveChanges();
            }
        }
    }
}
