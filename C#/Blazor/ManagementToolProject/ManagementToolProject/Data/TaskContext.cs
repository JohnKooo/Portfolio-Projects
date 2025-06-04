using Microsoft.EntityFrameworkCore;
using ManagementToolProject.Models;
using System.Threading.Tasks;


namespace ManagementToolProject.Data
{
    public class TaskContext : DbContext
    {
        public TaskContext(DbContextOptions<TaskContext> options) : base(options)
        {
        }

        public DbSet<TaskType> Tasks { get; set; }
    }
}
