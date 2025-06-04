package com.example.part2project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewGame(@RequestBody Rating game){
        gameRepository.save(game);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Rating> getAllGames(){
        return gameRepository.findAll();
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateGame(@PathVariable("id")long id, @RequestBody Rating updatedGame){
        //find the game
        Optional<Rating> optionalGame = gameRepository.findById(id);

        //update the game
        if (optionalGame.isPresent()){
            //make a new game
            Rating existingGame = optionalGame.get();
            //update new game
            existingGame.setGameCost(updatedGame.getGameCost());
            existingGame.setRating(updatedGame.getRating());
            // update database
            gameRepository.save(existingGame);
            //inform user
            return "Updated";
        }else {
            //throw an error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String updateGame(@PathVariable("id")long id){

        Optional<Rating> optionalGame = gameRepository.findById(id);

        if (optionalGame.isPresent()){
            // delete the game
            Rating game = optionalGame.get();
            gameRepository.delete(game);
            return "Deleted";
        }else {
            //throw an error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
    }
}
