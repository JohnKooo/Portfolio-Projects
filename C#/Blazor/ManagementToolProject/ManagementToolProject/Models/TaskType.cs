using System.ComponentModel.DataAnnotations;

namespace ManagementToolProject.Models
{
    public class TaskType
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "Title is required")]
        [StringLength(100, ErrorMessage = "Title cannot be more than 100 characters")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Description is required")]
        [StringLength(200, ErrorMessage = "Description cannot be more than 200 characters")]
        public string Description { get; set; }

        [Required(ErrorMessage = "Due Date is required")]
        public DateTime DueDate { get; set; }
        public bool Status { get; set; }
    }
}
