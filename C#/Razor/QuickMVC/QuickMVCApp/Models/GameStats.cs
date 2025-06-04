using System;
using System.ComponentModel.DataAnnotations;

namespace QuickMVCApp.Models;

public class GameStats
{
    [Key]
    public Guid GameId { get; set; }
    public int FinalComputerPoints { get; set; }
    public int FinalPlayerPoints { get; set; }
    public string PlayerId { get; set; }
    public string PlayerName { get; set; }
    public DateTime DatePlayed { get; set; }
}
