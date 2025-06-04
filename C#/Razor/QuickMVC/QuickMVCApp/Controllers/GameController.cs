using System.Text.Json;
using Microsoft.AspNetCore.Mvc;
using QuickMVCApp.Data;
using QuickMVCApp.Models;

namespace QuickMVCApp.Controllers;

public class GameSession
{
    public int PlayerPoints { get; set; } = 500;
    public int ComputerPoints { get; set; } = 500;
    public int RoundsPlayed { get; set; } = 0;

    public string WinLose { get; set; } = string.Empty;
    public int computerguess { get; set; } = 0;
    public int computerBet { get; set; } = 0;
    public int playerguess { get; set; } = 0;
    public int randomNumber { get; set; } = 0;
}
public class GameController : Controller
{
    private readonly AppDbContext _context;

    public GameController(AppDbContext context)
    {
        _context = context;
    }

    // GET: GameController
    public ActionResult Index()
    {
        return View();
    }

    public ActionResult PlayGame()
    {
        var gameSession = new GameSession();
        return View(gameSession);
    }

    [HttpPost]
    public IActionResult PlayGame(int playerGuess, int betAmount)
    {
        var rnd = new Random();
        var gameSession = GetGameSession();

        var randomNumber = rnd.Next(1, 100);
        gameSession.randomNumber = randomNumber;
        
        var computerGuess = rnd.Next(1, 100);
        var computerPointsBet = rnd.Next(25, 150);
        
        gameSession.computerguess = computerGuess;
        gameSession.computerBet = computerPointsBet;
        gameSession.playerguess = playerGuess;

        if (System.Math.Abs(computerGuess - randomNumber) <= System.Math.Abs(playerGuess - randomNumber))
        {
            gameSession.ComputerPoints += betAmount;
            gameSession.PlayerPoints -= betAmount;
            gameSession.WinLose = "Computer Wins";
        }
        else
        {
            gameSession.PlayerPoints += computerPointsBet;
            gameSession.ComputerPoints -= computerPointsBet;
            gameSession.WinLose = "Player Wins";
        }

        gameSession.RoundsPlayed++;

        if (gameSession.RoundsPlayed.Equals(5))
        {
            gameSession.RoundsPlayed = 0;
            gameSession.PlayerPoints = 500;
            gameSession.ComputerPoints = 500;
            EndGame(gameSession.PlayerPoints, gameSession.ComputerPoints);
        }

        SetGameSession(gameSession);

        return View(gameSession);
    }

    public IActionResult EndGame(int playerPoints, int computerPoints)
    {
        var gameStats = new GameStats()
        {
            GameId = Guid.NewGuid(), 
            FinalComputerPoints = computerPoints,
            FinalPlayerPoints = playerPoints,
            PlayerId = "Jarrett",
            PlayerName = "Jarrett Plate",
            DatePlayed = DateTime.Now
            
        };

        _context.GameStats.Add(gameStats);
        _context.SaveChanges();

        return View(gameStats);
    }

    private void SetGameSession(GameSession gameSession)
    {
        HttpContext.Session.SetString("GameSession", JsonSerializer.Serialize(gameSession));
    }

    private GameSession GetGameSession()
    {
        var sessionData = HttpContext.Session.GetString("GameSession");
        return sessionData != null ? JsonSerializer.Deserialize<GameSession>(sessionData) : new GameSession();
    }

}

